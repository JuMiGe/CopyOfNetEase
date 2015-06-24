package com.jumige.android.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class DisplayUtil {

    public static  final  float RATIO_BANNER_PIC  = 300 / 640f;
	private static DisplayMetrics dm = null;

	static public DisplayMetrics getDisplayMetrics(Context context) {
		if (dm == null) {
			dm = context.getResources().getDisplayMetrics();
			// L.i(dm.toString());
		}
		return dm;
	}

	static public int px2dp(Context context, int px) {
		if (context == null) {
			return px;
		}
		getDisplayMetrics(context);
		final float density = dm.density;
		return (int) (px / density + 0.5f);
	}

	static public int dp2px(Context context, float dp) {
		if (context == null) {
			return (int) dp;
		}
		getDisplayMetrics(context);
		final float density = dm.density;
		return (int) (dp * density + 0.5f);
	}

	static public int px2sp(Context context, float px) {
		if (context == null) {
			return (int) px;
		}
		getDisplayMetrics(context);
		return (int) (px / dm.scaledDensity + 0.5f);
	}

	static public int sp2px(Context context, float sp) {
		if (context == null) {
			return (int) sp;
		}
		getDisplayMetrics(context);
		return (int) (sp * dm.scaledDensity + 0.5f);
	}

	static public int getScreenWidthInPx(Context context) {
		getDisplayMetrics(context);
		return dm.widthPixels;
	}

	static public int getScreenHeightInPx(Context context) {
		getDisplayMetrics(context);
		return dm.heightPixels;
	}

	static public int getScreenWidthInDp(Context context) {
		getDisplayMetrics(context);
		return (int) ((float) dm.widthPixels * (160 / dm.xdpi));
	}

	static public int getScreenHeightInDp(Context context) {
		getDisplayMetrics(context);
		int screenHeight = dm.heightPixels;
		return (int) ((float) screenHeight / dm.density);
	}

	static public float getDensity(Context context) {
		getDisplayMetrics(context);
		return dm.density;
	}

	public static int getScreenTitleBarHeight(Context context) {
		Rect rect = new Rect();
		((Activity) context).getWindow().getDecorView()
				.getWindowVisibleDisplayFrame(rect);
		return rect.top;
	}
}
