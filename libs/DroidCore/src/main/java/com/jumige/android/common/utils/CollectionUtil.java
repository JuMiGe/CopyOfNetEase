/*
 * Copyright (c) 2014.
 * Shijiebang
 */

package com.jumige.android.common.utils;

import java.util.List;

/**
 * Created by CyningLi on 2014/10/24 0024.
 */
public class CollectionUtil {

    public static boolean  isListMoreOne(List mArrayList){
        if (mArrayList != null && mArrayList.size() >0)
            return  true;
        return false;
    }
}
