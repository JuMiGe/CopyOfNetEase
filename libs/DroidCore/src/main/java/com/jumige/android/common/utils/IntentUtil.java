package com.jumige.android.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * 系统的Intent控制
 */
public class IntentUtil {
	
	public static void goToDial(Context ctx,String number){
		if(ctx != null && !TextUtils.isEmpty(number)){

            try {
                if (!number.startsWith("tel:")) {
                    number = "tel:" + number;
                }
                Intent intent = new Intent(
                        Intent.ACTION_DIAL, Uri.parse(number)
                        );
                ctx.startActivity(intent);
            } catch (Exception e) {
               ToastUtil.show(ctx,"您的手机没有拨号功能");
            }

        }
		
	}

    public static  Intent getIntent(){
        Intent mIntent =  new Intent();
        return  mIntent;
    }

	

}
