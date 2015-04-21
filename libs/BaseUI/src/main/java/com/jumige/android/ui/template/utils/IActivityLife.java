package com.jumige.android.ui.template.utils;


import android.app.Activity;

public interface IActivityLife {
	
	public void onCreate(Activity _activity);
	public void onResume(Activity _activity);
	public void onStart(Activity _activity);
	public void onPause(Activity _activity);
    public void onStop(Activity _activity);
	public void onDestroy(Activity _activity);
}
