package com.jumige.mobile.news.adapter;

import java.util.ArrayList;
import java.util.List;

import com.jumige.mobile.news.view.fragment.SlippageViewPager;
import com.jumige.mobile.news.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsImgPagerViewMark extends LinearLayout implements Runnable {

	/*
	 * 核心类，被封装的底部带指示物的ViewPager，基本思路是自定义一个类继承LinearLayout，
	 * 在里面加入两个子视图ViewPager和LinearLayout
	 * (放置指示物)，并且，因为要定期轮转，还实现了Runnable接口，定义了以下的变量：
	 */
	// 新闻数据
	private TextView newsImgTitle;
	private ImageView newsImage;
	// 要显示的ViewPager对象
	private SlippageViewPager viewPager;
	// 要放置指示物的子视图
	private LinearLayout viewDots;
	// viewDots上的指示物项
	// private List<ImageView> dots;
	// views是ViewPager项
	private List<View> views = new ArrayList<View>();;
	// 指示当前正在显示第几张图
	private int position = 0;
	// 表示可不可以自动轮转(当手指触摸时不轮转)
	private boolean isContinue = true;
	// 标志图
	private ImageView doctsImageView;
	private ImageView tempImageView;
	private ImageView[] dots = new ImageView[10];
	// 在下面的就是与attrs.xml中定义的属性相对应的值
	private float dotsViewHeight;
	private float dotsSpacing;
	private Drawable dotsFocusImage;
	private Drawable dotsBlurImage;
	private ScaleType scaleType = ScaleType.FIT_XY;
	private int gravity = Gravity.RIGHT;
	private Drawable dotsBackground;
	private float dotsBgAlpha;
	private int changeInterval;

	// 作为一个能够在xml布局文件中直接使用的View，必须重写拥有Context和
	// AttributeSet参数的构造函数：
	public NewsImgPagerViewMark(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.NewsImgPagerViewMark, 0, 0);

		try {
			dotsViewHeight = a.getDimension(
					R.styleable.NewsImgPagerViewMark_dotsViewHeight, 40);
			// 这里依次获取所有的属性值，此处省略，可参看最后附上的全部代码

			dotsSpacing = a.getDimension(

			R.styleable.NewsImgPagerViewMark_dotsSpacing, 2);
			dotsBgAlpha = a.getDimension(

			R.styleable.NewsImgPagerViewMark_dotsBgAlpha, 0.5f);
			changeInterval = (int) a.getDimension(

			R.styleable.NewsImgPagerViewMark_changeInterval, 1000);
			dotsFocusImage = a.getDrawable(

			R.styleable.NewsImgPagerViewMark_dotsFocusImage);
			dotsBlurImage = a.getDrawable(

			R.styleable.NewsImgPagerViewMark_dotsBlurImage);
			dotsBackground = a.getDrawable(

			R.styleable.NewsImgPagerViewMark_dotsBackground);

		} finally {
			a.recycle();
		}

		initView();
		newsImage = new ImageView(getContext());
		newsImage.setImageResource(R.drawable.image1);
		views.add(newsImage);
		newsImage = new ImageView(getContext());
		newsImage.setImageResource(R.drawable.image2);
		views.add(newsImage);
		newsImage = new ImageView(getContext());
		newsImage.setImageResource(R.drawable.image1);
		views.add(newsImage);
		newsImage = new ImageView(getContext());
		newsImage.setImageResource(R.drawable.image2);
		views.add(newsImage);
		this.setViewPagerViews(views);
	}

	// 最后调用的函数initView，用来初始化ViewPager和LinearLayout这两个子视图，
	// 同时，如果xml中给指示物设置了背景，在这里进行设置：
	@SuppressLint("NewApi")
	private void initView() {
		// TODO Auto-generated method stub
		newsImgTitle = new TextView(getContext());
		viewPager = new SlippageViewPager(getContext());
		viewDots = new LinearLayout(getContext());
		ListView.LayoutParams lp = new ListView.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

		addView(viewPager, lp);
//		newsImgTitle.setText("图片新闻的标题");
//		addView(newsImgTitle, lp);
		if (dotsBackground != null) {
			dotsBackground.setAlpha((int) (dotsBgAlpha * 255));
			viewDots.setBackground(dotsBackground);
		}
		viewDots.setGravity(gravity);
		addView(viewDots, lp);
	}

	/*
	 * 使用这个类时，关键就是创建一个List，并作为参数传进来供ViewPager(PagerAdapter)使用，
	 * 对外的接口就是这个setViewPagerViews：
	 * addDots就是在底部添加多少个小点，默认第一个处于被选中状态，关键是OnPageChangeListener的
	 * onPageSelected方法 ，这个方法在viewPager进行切换时调用，做的工作就是把底部的指示物切换到对应的标识上，
	 * 在这个方法的最后，启动了轮转的线程。
	 */
	public void setViewPagerViews(List<View> views) {
		this.views = views;
		addDots(views.size());
		System.out.println(scaleType);
		viewPager.setAdapter(new NewsImgPagerViewAdapter(views, scaleType));

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int index) {
				// TODO Auto-generated method stub
				position = index;
				switchToDot(index);
			}

			private void switchToDot(int index) {
				if (tempImageView != null) {
					tempImageView
							.setBackgroundResource(R.drawable.news_img_no_read);
				}
				dots[index].setBackgroundResource(R.drawable.news_img_read);
				tempImageView = dots[index];
			}

			// override的两个空方法，此处省略

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}
		});

		viewPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent motionevent) {
				// TODO Auto-generated method stub
				switch (motionevent.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_MOVE:
					isContinue = false;
					break;
				case MotionEvent.ACTION_UP:
					isContinue = true;
					break;
				default:
					isContinue = true;
					break;
				}
				return false;
			}
		});
		new Thread(this).start();

	}

	@Override
	public void run() {
		// // 定时轮换才会用到的
		// while (true) {
		// if (isContinue) {
		// pageHandler.sendEmptyMessage(position);
		// position = (position + 1) % views.size();
		// try {
		// Thread.sleep(changeInterval);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
	}

	Handler pageHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			viewPager.setCurrentItem(msg.what);
			super.handleMessage(msg);
		}
	};

	/*
	 * 作为一个自定义的View，要重写父类的onLayout方法来对子元素进行布局
	 * ViewPager在显示时，会默认初始化当前页和前后页，对于第一张来说
	 * ，没有前一页，所以初始化了两张，在ViewPager滑动时，每次都会调用onLayout方法，而且，changed
	 * 参数为false，我已开始只判断changed为true时才进行布局
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		View child = this.getChildAt(0);
		child.layout(0, 0, getWidth(), getHeight());

		if (changed) {
			child = this.getChildAt(1);
			child.measure(r - l, (int) dotsViewHeight);
			child.layout(0, getHeight() - (int) dotsViewHeight, getWidth(),
					getHeight());
		}
	}

	private void addDots(int size) {
		for (int i = 0; i < size; i++) {
			doctsImageView = new ImageView(getContext());
			// 设置小圆点imageview的参数
			doctsImageView.setLayoutParams(new LayoutParams(20, 20));// 创建一个宽高均为20的布局
			// RelativeLayout.LayoutParams params = new
			// RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, 20);

			// imageView.setLayoutParams(params);
			doctsImageView.setPadding(20, 0, 20, 0);
			// 将小圆点layout添加到数组中
			// Log.d("test", "imageView::" + imageView);
			// Log.d("test", "imageViews[i]::" + dots[i]);
			dots[i] = doctsImageView;

			// 默认选中的是第一张图片，此时第一个小圆点是选中状态，其他不是
			if (i == 0) {
				dots[i].setBackgroundResource(R.drawable.news_img_read);
				tempImageView = dots[i];
			} else {
				dots[i].setBackgroundResource(R.drawable.news_img_no_read);
			}

			// 将imageviews添加到小圆点视图组
			viewDots.addView(dots[i]);
		}
	}

}
