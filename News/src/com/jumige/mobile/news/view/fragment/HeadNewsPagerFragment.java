package com.jumige.mobile.news.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeadNewsPagerFragment extends Fragment {
	/*
	 * 点击头条新闻，显示头条图片的Fragment
	 */
	private static final String KEY_CONTENT = "TestFragment:Content";
	private static Bitmap bitmap;

	public static HeadNewsPagerFragment newInstance(Bitmap iBitmap) {
		HeadNewsPagerFragment fragment = new HeadNewsPagerFragment();
		bitmap = iBitmap;
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ImageView img = new ImageView(getActivity());
		img.setPadding(20, 20, 20, 20);
		img.setMaxHeight(250);
		img.setImageBitmap(bitmap);
		LinearLayout l = new LinearLayout(getActivity());
		l.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		l.setGravity(Gravity.CENTER);
		LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(
				new LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT));
		layout.setMargins(0, 50, 0, 50);
		img.setLayoutParams(layout);
		l.addView(img);
		return l;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

}
