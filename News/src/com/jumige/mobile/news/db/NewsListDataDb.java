package com.jumige.mobile.news.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

/*
 * 获得新闻列表的数据
 */
public class NewsListDataDb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Context mContext;
	private InputStream fis;
	private StringBuffer sb;
	private String line;
	private BufferedReader bufferedReader;
	private BitmapFactory.Options options;
	private BitmapFactory.Options options2;
	public String[] commentNum = new String[] { "143跟帖", "35041跟帖", "27878跟帖",
			"1023跟帖", "703跟帖", "11503跟帖", "8838跟帖", "14452跟帖", "6231跟帖",
			"3250跟帖" };

	public NewsListDataDb(Context context) {
		mContext = context;
		options = new BitmapFactory.Options();
		options2 = new BitmapFactory.Options();
	}

	// 得到新闻图片

	public Bitmap getNewsImg(String path,int size) {
		try {
			fis = mContext.getAssets().open(path);
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(fis, null, options);
			int REQUIRED_SIZE = size;
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

	// 得到标题
	public String getNewsTitle(String path) {
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
		return sb.toString();

	}

	// 得到内容
	/*
	 * j=0;得到概述。j=1;得到内容
	 */
	public String getNewsContext(int j, String path) {
		// j是用来判断得到内容和得到概述的
		sb = new StringBuffer();
		line = null;
		bufferedReader = null;
		try {
			fis = mContext.getAssets().open(path);
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
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();

	}

}
