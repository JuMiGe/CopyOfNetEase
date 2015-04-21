package com.jumige.android.common.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于字符串格式化的工具类
 * Created by CyningLi on 2014/9/12 0012.
 */
public class StringFormatUtil {

    /**
     * str -- >yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date toDate(String strDate) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;

    }
}
