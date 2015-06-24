package cyning.me.libnerss.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.jumige.android.common.utils.LayzLog;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Author: cyning
 * Date  : 2015.04.28
 * Time  : 下午10:53
 * Desc  : 类/接口描述
 */
public abstract  class BaseApiHandler  implements Callback{

    public abstract void onSuccess(String string);


    public abstract void onFailure(String url,String string);


    public  abstract void onError(String string);







    @Override
    public void onFailure(Request request, IOException e) {

        sendMessage(FAILURE,new String[]{request.urlString(),e.getMessage()});

    }

    /**
     * Helper method to create Message instance from handler
     *
     * @param responseMessageId   constant to identify Handler message
     * @param responseMessageData object to be passed to message receiver
     * @return Message instance, should not be null
     */
    protected Message obtainMessage(int responseMessageId, Object responseMessageData) {
        return Message.obtain(mHandler, responseMessageId, responseMessageData);
    }

    protected void sendMessage(int responseMessageId, Object responseMessageData) {

        Message mMessage = obtainMessage(responseMessageId,responseMessageData);
        mHandler.sendMessage(mMessage);
    }
    @Override
    public void onResponse(Response response) throws IOException {
        String string = response.body().string();

        LayzLog.i("onResponse >> %s",string);
        Message mMessage = obtainMessage(SUCCESS, string);
        mHandler.sendMessage(mMessage);

    }

    public static final int  SUCCESS = 0;
    public static final int  FAILURE = 1;

    private Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {

            Object[] respon = null;
            int what = msg.what;

            if (what == SUCCESS){
                String responStr =(String) msg.obj;
                onSuccess(responStr);
            }else if (what == FAILURE){
                 respon =(Object[]) msg.obj;

                 onFailure((String)respon[0],(String)respon[1]);

            }
        }
    };
}
