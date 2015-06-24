package com.jumige.android.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * 针对App包的一些辅助类
 * 
 * @author Cyning
 * 
 */
public class AppUtil {

	/**
	 * 获取当前应用的版本号
	 * <p>
	 * 如1.0.0
	 * </p>
	 * 
	 * @param context
	 * @return <p>
	 *         如果为空就返回null
	 *         </p>
	 */
	public static String getVerionName(Context context) {


		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			return info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 获取当前应用的报名
	 * <p>
	 * 如com.shijiebang.android.im
	 * </p>
	 * 
	 * @param context
	 * @return <p>
	 *         如果为空就返回null
	 *         </p>
	 */
	public static String getPackageName(Context context) {
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			return info.packageName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getAppName(Context context) {
		PackageInfo info = null;
		try {
			info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			return info.applicationInfo.name;
		} catch (NameNotFoundException e) {
			return null;
		} 
		

	}

	public static boolean isInstall(Context context, String packagename) {
		boolean isInstall = false;
		PackageInfo packageInfo;

		try {
			packageInfo = context.getApplicationContext().getPackageManager()
					.getPackageInfo(packagename, 0);

		} catch (NameNotFoundException e) {
			packageInfo = null;
			e.printStackTrace();
		}
		if (packageInfo == null) {
			isInstall = false;
		} else {
			isInstall = true;
		}
		return isInstall;
	}

	public static void gotoMarket(Context context, String packagename) {
		String strUrl = "market://details?id=" + packagename;
		Uri uri = Uri.parse(strUrl);// id为包名
		Intent it = new Intent(Intent.ACTION_VIEW, uri);
		context.startActivity(it);
	}

	public static void searchApp(Context context, String packagename) {
        try {
            String strUrl = "market://search?q=pname:" + packagename;
            Uri uri = Uri.parse(strUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }catch (Exception e){
            ToastUtil.show(context,"cannot find this app");
            e.printStackTrace();
        }

	}

	public static void openApp(Context context, String packagename) {
		try {
			Intent intent = context.getPackageManager()
					.getLaunchIntentForPackage(packagename);
			context.startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(context, "没有安装", Toast.LENGTH_LONG).show();
		}
	}

    /**
     * 隐藏键盘
     *
     * @param context
     */
    public static void hiddenSoftKeyBoard(Context context) {
        try {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus()
                    .getApplicationWindowToken(), 0);
        } catch (Exception e) {

        }
    }

    /**
     * 获取友盟渠道名
     * @param context
     * @return
     */
    public static String getChannel(Context context)
    {
        String channelName = null;

        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            channelName = appInfo.metaData.getString("UMENG_CHANNEL");
        } catch (Exception e) {
            channelName = "noChannel";
        }
        return channelName;
    }


    /**
     * @param context
     * @return 获取设备id
     */
    public static String getDeviceId(Context context){
        android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        String device_id = tm.getDeviceId();
        if(StringUtils.isEmpty(device_id)){
            device_id="deviceidError";
        }
        return device_id;
    }

}
