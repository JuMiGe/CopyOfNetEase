package com.jumige.mobile.news.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

/*
 * 获得新闻列表的数据
 */
public class NewsListDataDb {
	private Context mcontext;
	private ArrayList<String> newsListTitle;
	private ArrayList<String> newsListContext;
	private ArrayList<Bitmap> newsListImg;
	private ArrayList<String> newsListBrieft;
	private InputStream fis;
	private StringBuffer sb;
	private Bitmap bitmap;
	private String line;
	private BufferedReader bufferedReader;
	private String[] newsPath = new String[] { "newslistdata/newslist_1_",
			"newslistdata/newslist_2_", "newslistdata/newslist_3_",
			"newslistdata/newslist_4_", "newslistdata/newslist_5_",
			"newslistdata/newslist_6_", "newslistdata/newslist_7_",
			"newslistdata/newslist_8_", "newslistdata/newslist_9_",
			"newslistdata/newslist_10_" };

	public NewsListDataDb(Context context) {
		mcontext = context;
	}

	// 获得新闻的标题
	public ArrayList<String> getNewsListTitle() {
		newsListTitle = new ArrayList<String>();
		for (int i = 0; i < newsPath.length; i++) {
			getTitle(newsPath[i] + "context");
			newsListTitle.add(sb.toString());
		}
		return newsListTitle;
	}

	// 获得新闻的内容
	public ArrayList<String> getNewsListContext() {
		newsListContext = new ArrayList<String>();
		for (int i = 0; i < newsPath.length; i++) {
			getContext(1, newsPath[i] + "context");
			newsListContext.add(sb.toString());
		}

		return newsListContext;
	}

	// 获得新闻的图片
	public ArrayList<Bitmap> getNewsListImg(int index) {
		newsListImg = new ArrayList<Bitmap>();
		if (index == 1) {
			for (int i = 0; i < newsPath.length; i++) {

				newsListImg.add(getImg(newsPath[i] + "img1.jpg"));
			}
		} else {
			for (int i = 0; i < newsPath.length; i++) {

				newsListImg.add(getImg(newsPath[i] + "img2.jpg"));
			}
		}
		return newsListImg;

	}

	// 获得新闻的简述
	public ArrayList<String> getNewsListDigest() {
		newsListBrieft = new ArrayList<String>();
		for (int i = 0; i < newsPath.length; i++) {
			getContext(0, newsPath[i] + "brieft");
			newsListBrieft.add(sb.toString());
		}

		return newsListBrieft;

	}

	// 得到新闻图片
	private Bitmap getImg(String path) {
		try {
			fis = mcontext.getAssets().open(path);
			BitmapFactory.Options options = new BitmapFactory.Options();
			bitmap = BitmapFactory.decodeStream(fis, null, options);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bitmap;

	}

	// 得到标题
	private StringBuffer getTitle(String path) {
		sb = new StringBuffer();
		line = null;
		bufferedReader = null;
		try {
			fis = mcontext.getAssets().open(path);
			bufferedReader = new BufferedReader(new InputStreamReader(fis));
			line = bufferedReader.readLine();
			sb.append(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;

	}

	// 得到内容
	private StringBuffer getContext(int j, String path) {
		sb = new StringBuffer();
		line = null;
		bufferedReader = null;
		try {
			fis = mcontext.getAssets().open(path);
			bufferedReader = new BufferedReader(new InputStreamReader(fis));
			if (j == 0) {
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
				}
			} else {
				int i = 0;
				while ((line = bufferedReader.readLine()) != null) {
					if (i == 0) {
						i++;
						continue;
					}
					sb.append(line);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;

	}

}
