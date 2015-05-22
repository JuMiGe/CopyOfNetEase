package com.jumige.android.common.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by CyningLi on 2014/9/16 0016.
 */
public class ViewCompat {





    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static int getMaxHeight(ImageView view) {
        if (VersionCompatUtils.hasJellyBean())
            return view.getMaxHeight();
        else {
            int maxHeight = -1;


            try {
                Field maxHeightField = ImageView.class.getDeclaredField("mMaxHeight");
                maxHeightField.setAccessible(true);

                maxHeight = (Integer) maxHeightField.get(view);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return maxHeight;
        }

    }

    public static int getMaxWidth(ImageView view) {
        if (VersionCompatUtils.hasJellyBean())
            return view.getMaxWidth();
        else {
            int maxWidth = -1;
            int maxHeight = -1;


            try {
                Field maxWidthField = ImageView.class.getDeclaredField("mMaxWidth");
                maxWidthField.setAccessible(true);

                maxWidth = (Integer) maxWidthField.get(view);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return maxWidth;
        }

    }
}
