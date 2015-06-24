package com.jumige.android.ui.template.utils;

import android.support.v4.app.Fragment;

/**
 * Created by cyning on 1/27/15.
 */
public interface IFragmentLife {
    public void onCreate(Fragment mFragment);
    public void onResume(Fragment mFragment);
    public void onStart(Fragment mFragment);
    public void onPause(Fragment mFragment);
    public void onStop(Fragment mFragment);
    public void onDestroy(Fragment mFragment);
}
