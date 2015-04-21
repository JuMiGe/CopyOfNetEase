package com.jumige.android.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *关于正则校验的工具类
 * Created by CyningLi on 2014/9/12 0012.
 */
public class ValidatorUtils {


    /**
     * 验证输入的邮箱格式是否符合
     *
     * @param email
     * @return 是否合法
     */
    public static boolean isEmail(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
