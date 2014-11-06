package com.jumige.mobile.news.tools;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.jumige.mobile.news.db.NewsHeadDataDb;
import com.jumige.mobile.news.db.NewsListDataDb;

import android.content.Context;
import android.graphics.Bitmap;

public class ImageCacheTool {
	private static final int HARD_CACHE_CAPACITY = 100;
	private Context mContext;
	private NewsListDataDb newsListDataDb;
	private NewsHeadDataDb newsHeadDataDb;
	private Bitmap bitmap;
	private Bitmap bitmap2;
	private Bitmap bitmap3;
	private SoftReference<Bitmap> bitmapReference;

	/*
	 * 图片缓存模块
	 */
	private int required_size ;
	public ImageCacheTool(Context context,int size) {
		// TODO Auto-generated constructor stub
		required_size = size;
		mContext = context;
		newsListDataDb = new NewsListDataDb(mContext);
		newsHeadDataDb = new NewsHeadDataDb(mContext);
	}

	private final HashMap<String, Bitmap> mHardBitmapCache = new LinkedHashMap<String, Bitmap>(
			HARD_CACHE_CAPACITY / 2, 0.75f, true) {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected boolean removeEldestEntry(Entry<String, Bitmap> eldest) {
			if (size() > HARD_CACHE_CAPACITY) {
				// 当map的size大于30时，把最近不常用的key放到mSoftBitmapCache中，从而保证mHardBitmapCache的效率
				mSoftBitmapCache.put(eldest.getKey(),
						new SoftReference<Bitmap>(eldest.getValue()));
				return true;
			} else
				return false;
		}

	};
	/*
	 * 当mHardBitmapCache的key大于30的时候，会根据LRU算法把最近没有被使用的key放入到这个缓存中。
	 * Bitmap使用了SoftReference，当内存空间不足时，此cache中的bitmap会被垃圾回收掉
	 */
	private final static ConcurrentHashMap<String, SoftReference<Bitmap>> mSoftBitmapCache = new ConcurrentHashMap<String, SoftReference<Bitmap>>(
			HARD_CACHE_CAPACITY / 2);

	/*
	 * 从缓存中获取图片 List列表数据
	 */
	public Bitmap getBitmapFromCacheList(String url) {
		// 先从mHardBitmapCache缓存中获取
		synchronized (mHardBitmapCache) {
			bitmap = mHardBitmapCache.get(url);
			if (bitmap != null) {
				// 如果找到的话，把元素移到linkedhashmap的最前面，从而保证在LRU算法中是最后被删除
				mHardBitmapCache.remove(url);
				mHardBitmapCache.put(url, bitmap);
				return bitmap;
			}
		}
		// 如果mHardBitmapCache中找不到，到mSoftBitmapCache中找
		bitmapReference = mSoftBitmapCache.get(url);
		if (bitmapReference != null) {
			bitmap = bitmapReference.get();
			if (bitmap != null) {
				return bitmap;
			} else {
				// 如果再找不到就去下载
				mSoftBitmapCache.remove(url);
				
				bitmap2 = newsListDataDb.getNewsImg(url,required_size);
				mHardBitmapCache.put(url, bitmap2);
				return bitmap2;
			}
		} else {
			bitmap3 = newsListDataDb.getNewsImg(url,required_size);
			mHardBitmapCache.put(url, bitmap3);
			return bitmap3;
		}
	}
	/*
	 * Head列表数据
	 */
	public Bitmap getBitmapFromCacheHead(String url) {
		// 先从mHardBitmapCache缓存中获取
		synchronized (mHardBitmapCache) {
			bitmap = mHardBitmapCache.get(url);
			if (bitmap != null) {
				// 如果找到的话，把元素移到linkedhashmap的最前面，从而保证在LRU算法中是最后被删除
				mHardBitmapCache.remove(url);
				mHardBitmapCache.put(url, bitmap);
				return bitmap;
			}
		}
		// 如果mHardBitmapCache中找不到，到mSoftBitmapCache中找
		bitmapReference = mSoftBitmapCache.get(url);
		if (bitmapReference != null) {
			final Bitmap bitmap = bitmapReference.get();
			if (bitmap != null) {
				return bitmap;
			} else {
				// 如果再找不到就去下载
				mSoftBitmapCache.remove(url);
				bitmap2 = newsHeadDataDb.getNewsImg(url,required_size);
				mHardBitmapCache.put(url, bitmap2);
				return bitmap2;
			}
		} else {
			
			bitmap3 = newsHeadDataDb.getNewsImg(url,required_size);
			mHardBitmapCache.put(url, bitmap3);
			return bitmap3;
		}
	}
}
