package com.jumige.android.ui.template.base;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.jumige.android.common.utils.ViewUtil;
import com.jumige.android.ui.template.utils.IActivityLife;
import com.jumige.android.ui.template.appRunning.AppRunningInBackground;
import com.jumige.android.ui.template.utils.AcitvityHelper;

import java.util.ArrayList;


/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午6:31
 * Desc  : 所有的Acvity都要继承的方法，这就说，这个类是所有Activity的基类
 */
public class BaseActivity extends ActionBarActivity {
    private boolean isShowBackIcon = false;
    public static  ArrayList<IActivityLife> mSubscribers = new ArrayList<>();

    private DroidApplication app = null;
    private AppRunningInBackground appRunningInBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(IActivityLife mLife :mSubscribers){
            mLife.onCreate(this);
        }

        if (getApplication() != null) {
            app = (DroidApplication) getApplication();
        }else{
            throw new IllegalStateException("no Application");

        }
        appRunningInBackground = AppRunningInBackground.getInstance(this);
        appRunningInBackground.onCreate();
        app.addActivity(this);
        supportRequestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView();
        setupViews();
    }


    protected void setupActionbarWithUp(String title) {
        ActionBar mActionBar = getSJBActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);// 显示ActionBar的返回箭头
        mActionBar.setDisplayShowTitleEnabled(true);
        mActionBar.setHomeButtonEnabled(true); // 设置ActionBar可点击返回
        mActionBar.setDisplayShowHomeEnabled(false);


        if (!TextUtils.isEmpty(title)) {
            mActionBar.setTitle(title);
        }
    }

    protected void setupActionbarWithUp(int titleID) {
        String title = getString(titleID);
        setupActionbarWithUp(title);
    }

    protected ActionBar getSJBActionBar() {
        return getSupportActionBar();
    }

    protected void setupActionBarBackgound() {
//        change ActionBar color just if an ActionBar is available
//        都弃用，改用theme解决
        Drawable whiteDrawable = new ColorDrawable(0xFF3C3D4E);
//        Drawable bottomDrawable = getResources().getDrawable(R.drawable.actionbar_bottom);
//        LayerDrawable oldLd = new LayerDrawable(new Drawable[]{whiteDrawable, bottomDrawable});
//        getSupportActionBar().setBackgroundDrawable(oldLd);

        //Change Title Color
        int actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (actionBarTitleId > 0) {
            TextView title = (TextView) findViewById(actionBarTitleId);
            if (title != null) {
                title.setTextColor(getResources().getColor(android.R.color.black));
            }
        }
    }

    protected void setContentView() {
    }

    protected void setupViews() {

    }
    @Override
    protected void onResume() {
        super.onResume();
        for(IActivityLife mLife :mSubscribers){
            mLife.onResume(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for(IActivityLife mLife :mSubscribers){
            mLife.onPause(this);
        }
    }

    public void showActionBarProgressBar(boolean isShow) {
        //设置actionbar上面显示进度条，true表示显示，如果是false表示不显示
        setSupportProgressBarIndeterminateVisibility(isShow);
    }
    /**
     * 显示ActionBar上面的返回键
     */
    public void showBackIcon() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        isShowBackIcon = true;
    }

    public void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        isShowBackIcon = true;
        actionBar.setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (goForward())
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 在goForward前做一下判断
     * <li>true &nbsp;&nbsp;就finish</li>
     * <li>true &nbsp;&nbsp;就不finish</li>
     *
     * @return
     */
    protected boolean goForward() {
        return true;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T v(int id) {
        View view = ViewUtil.find(this, id);
        if (view == null) {
            throw new InflateException();
        }
        return (T) view;
    }

    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
    }

    /**
     * 返回这个activity的
     *
     * @return
     */
    public BaseActivity getThisActivity() {
        return this;
    }



    @Override
    protected void onStop() {
        super.onStop();
        if (appRunningInBackground != null){
            appRunningInBackground.onStop();
        }
        for(IActivityLife mLife :mSubscribers){
            mLife.onStop(this);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (app != null) {
            app.removeActivity(this);
        }
        for(IActivityLife mLife :mSubscribers){
            mLife.onDestroy(this);
        }
    }

    public static  void addSubscriber(IActivityLife _activityLife){
        mSubscribers.add(_activityLife);
    }

    /**
     * 退出时默认特效
     *
     * @return
     */
    public boolean isExitAnimation() {
        return true;
    }

    public void exitWithAnimation() {
        if (isExitAnimation()) {
            AcitvityHelper.finishWithAnimationOut(this);
        }
    }


    /**
     * 退出时使用自定义特效
     */
    public void exitWithAnimation(int enterAnim, int exitAnim) {
        if (isExitAnimation()) {
            AcitvityHelper.finishWithAnimation(this, enterAnim, exitAnim);
        }
    }
}
