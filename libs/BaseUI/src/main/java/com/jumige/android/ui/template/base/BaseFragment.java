package com.jumige.android.ui.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumige.android.common.utils.LayzLog;
import com.jumige.android.common.utils.ViewUtil;
import com.jumige.android.ui.template.utils.IFragmentLife;

import java.util.ArrayList;

/**
 * Fragmeng的基类
 * <p>所有的Fragment都要继承于这个Fragment,这个类提供了部分Fragmeng可以使用的方法，如设置View的方法就是getRootViewId（）</p>
 *
 *
 */
public class BaseFragment extends Fragment {
    public static ArrayList<IFragmentLife> mSubscribers = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (IFragmentLife mFragLife:mSubscribers){
            mFragLife.onCreate(this);
        }
        LayzLog.d(this.getClass().getSimpleName() + " >>> %s", "onCreate");
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LayzLog.d(this.getClass().getSimpleName() + ">>> %s", "onActivityCreated");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = setContentView(inflater);
        if (view != null)
           setupViews(view);
        return view;
    }
    protected void setupViews(View view) {

    }
    protected  View setContentView(LayoutInflater inflater) {
        if (getRootViewId() >0){
            View view  = inflater.inflate(getRootViewId(), null);
            return view;
        }
        return null;

    }
    protected int getRootViewId() {
        return -1;
    }
    @Override
    public void onResume() {
        super.onResume();
        for (IFragmentLife mFragLife:mSubscribers){
            mFragLife.onResume(this);
        }
        LayzLog.d(this.getClass().getSimpleName() + ">>> %s", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        for (IFragmentLife mFragLife:mSubscribers){
            mFragLife.onPause(this);
        }
        LayzLog.d(this.getClass().getSimpleName() + ">>> %s", "onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        for (IFragmentLife mFragLife:mSubscribers){
            mFragLife.onStart(this);
        }
        LayzLog.d(this.getClass().getSimpleName() + ">>> %s", "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        for (IFragmentLife mFragLife:mSubscribers){
            mFragLife.onStop(this);
        }
        LayzLog.d(this.getClass().getSimpleName() + ">>> %s", "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        for (IFragmentLife mFragLife:mSubscribers){
            mFragLife.onDestroy(this);
        }
        LayzLog.d(this.getClass().getSimpleName() + ">>> %s", "onDestroy");
    }

    public <T extends View> T v(View v,int id){
        return ViewUtil.find(v, id);
    }

    /**
     * Fragment关联的Activity要去继承#BaseActivity
     * @return
     */
   public BaseActivity getSJBActvity(){
       if (getActivity() != null && getActivity() instanceof  BaseActivity){
           return (BaseActivity) getActivity();
       }
       else{
           return null;
       }
   }
    public void  setUpTitle(String _title){
        BaseActivity mBaseActivity = getSJBActvity();
        if(mBaseActivity != null  ){
            mBaseActivity.setupActionbarWithUp(_title);
        }

    }
    public static  void addSubscriber(IFragmentLife _fragmentLife){
        mSubscribers.add(_fragmentLife);
    }


}
