package com.jumige.mobile.news.view.fragment;


import android.content.Context;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class SlippageViewPager extends ViewPager implements OnGestureListener,
		android.view.GestureDetector.OnGestureListener {

	/** 手势滑动处理类 **/
	/*
	 * 提供了GestureDetector（Gesture：手势Detector：识别）类，通过这个类我们可以识别很多的手势，
	 * 主要是通过他的onTouchEvent(event)方法完成了不同手势的识别
	 */
	private GestureDetector mDetector;

	public SlippageViewPager(Context context) {
		super(context);

		GestureDetector detector = new GestureDetector(context, this);
		mDetector = detector;
	}

	public GestureDetector getGestureDetector() {
		return mDetector;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
	}

	/*
	 * 一次点击up事件；在touch down后又没有滑动 （onScroll），又没有长按（onLongPress），然后Touchup时触发。
	 */
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		if (listener != null) {
			listener.setOnSimpleClickListenr(getCurrentItem());
		}
		return true;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		return false;
	}

	private onSimpleClickListener listener;

	/** 单击监听接口 **/
	public interface onSimpleClickListener {
		void setOnSimpleClickListenr(int position);
	}

	public void setOnSimpleClickListener(onSimpleClickListener listener) {
		this.listener = listener;
	}

	@Override
	public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGesture(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {
		// TODO Auto-generated method stub

	}

}
