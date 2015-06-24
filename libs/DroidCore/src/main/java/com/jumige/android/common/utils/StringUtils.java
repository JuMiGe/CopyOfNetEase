package com.jumige.android.common.utils;

import android.text.TextUtils;

import java.util.ArrayList;

public class StringUtils {


    
    
	public static String join(String[] strs, String split) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			if (split != null) {
				sb.append(split);
			}

			sb.append(strs[i]);
		}

		return sb.toString();
	}

	public static String validString(String str) {
		return TextUtils.isEmpty(str) ? "" : str;
	}

	public static String ToDBC(String input) {
		if (null == input) {
			return "";
		}

		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}



    /**
     * 判断一个字符串是否为空
     *
     * @author 贺博
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().equals("");
    }

    /**
     * 判断一组字符串是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(String ...s) {
        for(String str:s){
            if(isEmpty(str)){
                return true;
            }
        }
        return false;
    }

    /**
     * 去掉字符串中的空白字符
     * <li>为空，就返回""</li>
     * @param s
     * @return
     */
    public static String notNull(String s) {
        if (s == null)
            return "";
        else
            return s.trim();
    }

    public static String[] split(String sourse, String spliter) {
        sourse = notNull(sourse);
        int index = 0, nextIndex = 0, spliterLen = spliter.length();
        ArrayList<String> list = new ArrayList<String>();
        while ((nextIndex = sourse.indexOf(spliter, index)) != -1) {
            list.add(sourse.substring(index, nextIndex));
            index = nextIndex + spliterLen;
        }
        if (list.size() > 0)
            list.add(sourse.substring(sourse.lastIndexOf(spliter) + spliter.length(), sourse.length()));
        String splits[] = new String[list.size()];
        list.toArray(splits);

        return splits;
    }

    /**
     * 截取固定长度的字符，超过长度的
     * @param orgStr  源字符
     * @param lenght  最大长度
     * @param indiStr 超过长度部分用这个字符替代
     * @return
     */
    public static String getInterceptionStr(String orgStr,int lenght,String indiStr){
        if(!isEmpty(orgStr)){
            String tempStr = orgStr;
           if(orgStr.length() > lenght){
               tempStr = orgStr.substring(0,lenght);

               tempStr += notNull(indiStr);
           }
            return tempStr;

        }else{
            return "";
        }


    }
}
