package com.jumige.mobile.news.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class NewsHeadDataDb {
	private Context mContext;
	private StringBuffer sb;
	private String line;
	private BufferedReader bufferedReader;
	private InputStream fis;
	private BitmapFactory.Options options;
	private BitmapFactory.Options options2;
	private ArrayList<String> newsHeadTitle;
	private ArrayList<String> newsHeadContext;
	private ArrayList<Bitmap> newsHeadImg;
	private String[] newsPath = new String[] { "newsheaddata/newshead_1_",
			"newsheaddata/newshead_2_", "newsheaddata/newshead_3_",
			"newsheaddata/newshead_4_" };

	public NewsHeadDataDb(Context context) {
		
		mContext = context;
		options2 = new BitmapFactory.Options();
		options = new BitmapFactory.Options();
	}

	// 获得新闻的标题
	public ArrayList<String> getNewsHeadTitle() {
		newsHeadTitle = new ArrayList<String>();
		for (int i = 0; i < newsPath.length; i++) {
			getTitle(newsPath[i] + "context");
			newsHeadTitle.add(sb.toString());
		}
		return newsHeadTitle;
	}

	// 获得新闻的内容
	public ArrayList<String> getNewsHeadContext() {
		newsHeadContext = new ArrayList<String>();
		for (int i = 0; i < newsPath.length; i++) {
			getContext(newsPath[i] + "context");
			newsHeadContext.add(sb.toString());
		}

		return newsHeadContext;
	}

	/*
	 * 获取头条新闻图片； index = 0;获取第一张图片 index = 1;获取所有图片 (有待完善)
	 */
//	public ArrayList<Bitmap> getNewsHeadImg(int index) {
//		newsHeadImg = new ArrayList<Bitmap>();
//		if (index == 0) {
//			for (int i = 0; i < newsPath.length; i++) {
//
//				newsHeadImg.add(getImg(newsPath[i] + "img1.jpg"));
//			}
//		} else {
//			for (int i = 0; i < newsPath.length; i++) {
//
//				newsHeadImg.add(getImg(newsPath[i] + "img2.jpg"));
//			}
//		}
//		return newsHeadImg;

//	}

	// 得到标题
	private StringBuffer getTitle(String path) {
		sb = new StringBuffer();
		line = null;
		bufferedReader = null;
		try {
			fis = mContext.getAssets().open(path);
			bufferedReader = new BufferedReader(new InputStreamReader(fis));
			line = bufferedReader.readLine();
			sb.append(line);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb;

	}

	// 得到内容
	private StringBuffer getContext(String path) {
		
		sb = new StringBuffer();
		line = null;
		bufferedReader = null;
		try {
			fis = mContext.getAssets().open(path);
			bufferedReader = new BufferedReader(new InputStreamReader(fis));

			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb;

	}

	// 得到新闻图片
	public Bitmap getNewsImg(String path) {
		try {
			fis = mContext.getAssets().open(path);
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(fis, null, options);
			final int REQUIRED_SIZE = 350;
			int width_tmp = options.outWidth, height_tmp = options.outHeight;
			int scale = 1;
			while (true) {
				if (width_tmp / 2 < REQUIRED_SIZE
						|| height_tmp / 2 < REQUIRED_SIZE) {
					break;
				}
				width_tmp /= 2;
				height_tmp /= 2;
				scale *= 2;
			}

			// decode with inSampleSize
			options2.inSampleSize = scale;
			return BitmapFactory.decodeStream(fis, null, options2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}
}
