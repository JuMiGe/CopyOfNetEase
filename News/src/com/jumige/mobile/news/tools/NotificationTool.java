package com.jumige.mobile.news.tools;

import com.jumige.mobile.news.activity.MainActivity;
import com.mobile.jumige.news.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NotificationTool {

	private NotificationManager mNotificationManager;
	private Notification notification;
	private static final int ID_DOWNLOAD_NOTIFICATION = 0;
	private static final int ID_CANCEL_DOWNLOAD= 1;
	private int Id;
	private String ns;
	private Context mContext;

	// 定义NotificationManager

	public void sendMessage(Context context, int ID) {
		Id = ID;
		mContext = context;
		// 定义通知栏展现的内容信息
		long when = System.currentTimeMillis();
		// 构建一个通知对象(需要传递的参数有三个,分别是图标,标题和 时间)
		ns = Context.NOTIFICATION_SERVICE;
		mNotificationManager = (NotificationManager) mContext
				.getSystemService(ns);
		switch (Id) {
		case ID_DOWNLOAD_NOTIFICATION:
			notification = new Notification();
			notification.icon = R.drawable.download_icon;
			notification.tickerText = "正在下载离线新闻";
			notification.when = System.currentTimeMillis();
			// 定义下拉通知栏时要展现的内容信息

			CharSequence contentTitle = "正在下载离线新闻";
			CharSequence contentText = "我的通知栏展开详细内容";
			Intent notificationIntent = new Intent(context, MainActivity.class);
			PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
					notificationIntent, 0);
			notification.setLatestEventInfo(context, contentTitle, contentText,
					null);
			// 发动通知,id由自己指定，每一个Notification对应的唯一标志
			mNotificationManager.notify(Id, notification);
			break;
		case ID_CANCEL_DOWNLOAD:
			mNotificationManager.cancel(ID_DOWNLOAD_NOTIFICATION);

		default:
			break;
		}

	}

	// notification.flags = Notification.FLAG_AUTO_CANCEL;// 点击后自动消失
	// notification.defaults = Notification.DEFAULT_SOUND;// 声音默认

	// 可以使用ID来取消Notification，通过调用NotificationManager的cancel方法，代码如下。
	//
	// 　　notificationManager.cancel(notificationRef);

}
