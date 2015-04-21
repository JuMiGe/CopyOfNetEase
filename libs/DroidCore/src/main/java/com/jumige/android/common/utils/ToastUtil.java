package com.jumige.android.common.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {

    public static Context sContext;

    public static void show(String text,int duration){
        if (sContext != null){
            show(sContext,text,duration);
        }else{
            throw  new NullPointerException("context is null ，plealse init the toast");
        }

    }

    public static void show(String text){
        if (sContext != null){
            show(sContext,text,Toast.LENGTH_SHORT);
        }else{
            throw  new NullPointerException("context is null ，plealse init the toast");
        }
    }


    public static void show(int strId,int duration){
        if (sContext != null){
            show(sContext,strId,duration);
        }else{
            throw  new NullPointerException("context is null ，plealse init the toast");
        }
    }

    public static void show(int strId){
        if (sContext != null){
            show(sContext,strId,Toast.LENGTH_SHORT);
        }else{
            throw  new NullPointerException("context is null ，plealse init the toast");
        }
    }

    public static void showTop(Context context,String text){
        Toast toast=Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.show();
    }


	public static void show(Context context ,String text,int duration){
		Toast.makeText(context.getApplicationContext(), text, duration).show();
	}
	
	public static void show(Context context ,String text){
		Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
	}
	
	
	public static void show(Context context ,int strId,int duration){
		Toast.makeText(context.getApplicationContext(), strId, Toast.LENGTH_SHORT).show();
	}
	
	public static void show(Context context ,int strId){
		Toast.makeText(context.getApplicationContext(), strId, Toast.LENGTH_SHORT).show();
	}

}
