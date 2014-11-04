package com.jumige.mobile.news.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/*
 * 从资源文件取头条新闻数据的类
 */
public class NewsHeadDataDb {
	private Context mContext;
	private StringBuffer sb;
	private String line;
	private BufferedReader bufferedReader;
	private InputStream fis;
	private BitmapFactory.Options options;
	private BitmapFactory.Options options2;

	public NewsHeadDataDb(Context context) {

		mContext = context;
		options2 = new BitmapFactory.Options();
		options = new BitmapFactory.Options();
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
	public String getNewsContext(String path) {

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
		return sb.toString();

	}

	// 得到新闻图片
	public Bitmap getNewsImg(String path, int size) {
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
}
