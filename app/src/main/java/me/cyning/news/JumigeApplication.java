package me.cyning.news;

import com.jumige.android.libbell.BaseNetEaseApplication;

/**
 * Author: cyning
 * Date  : 2015.04.21
 * Time  : 下午11:34
 * Desc  : 类/接口描述
 */
public class JumigeApplication extends BaseNetEaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        initLog(true);
    }
}
