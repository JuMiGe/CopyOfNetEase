package cyning.me.librest.client;

import com.jumige.android.common.utils.LayzLog;
import com.loopj.android.http.AsyncHttpClient;

import org.apache.http.Header;

import cyning.me.librest.restcore.AbsApiClient;
import cyning.me.librest.restcore.BaseApiHandler;
import cyning.me.librest.restcore.RequestParams;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午9:50
 * Desc  : 类/接口描述
 */
public class AsynHttpClient extends AbsApiClient {

    private static AsynHttpClient mInstance = null;

    public static AsynHttpClient getInstance() {
        if (mInstance == null) {
            synchronized (AsynHttpClient.class) {
                if (mInstance == null) {
                    mInstance = new AsynHttpClient();
                }
            }
        }
        return mInstance;
    }


    @Override
    public void doRequest(Object tag, RequestType _requestType, String paramsUrl, RequestParams params, Header[] headers, BaseApiHandler responseHandler) {
        super.doRequest(tag, _requestType, paramsUrl, params, headers, responseHandler);


    }

    @Override
    public void doGet(Object tag, String paramsUrl, RequestParams params, Header[] headers, BaseApiHandler baseHandler) {
        super.doGet(tag, paramsUrl, params, headers, baseHandler);

       com.loopj.android.http.RequestParams mParams =  Aync2Parms.toPararm(params);

        LayzLog.i("url = %s",paramsUrl);

        if (mParams != null){
            LayzLog.i("mParams = %s",mParams.toString());
        }

        if (headers != null){
            LayzLog.i("headers = %s",headers.toString());
        }


        LayzLog.i("url = %s",paramsUrl);

        AsynHttpClientUtil.INSTANCE.getInstance().get(tag,paramsUrl,headers,mParams,(AynAPIHandler)baseHandler);


    }

    public void doGet(Object tag, String paramsUrl, BaseApiHandler baseHandler) {
        super.doGet(tag, paramsUrl, null, null, baseHandler);



        AsynHttpClientUtil.INSTANCE.getInstance().get(tag,paramsUrl,null,(AynAPIHandler)baseHandler);


    }

    @Override
    public void doPost(Object tag, String paramsUrl, RequestParams params, Header[] headers, BaseApiHandler baseHandler) {
        super.doPost(tag, paramsUrl, params, headers, baseHandler);
        AsynHttpClientUtil.INSTANCE.getInstance().get(tag,paramsUrl,headers,Aync2Parms.toPararm(params),(AynAPIHandler)baseHandler);
    }

    public  void cancel(Object object,boolean is){
        AsynHttpClientUtil.INSTANCE.getInstance().cancelRequests(object,is);
    }


    public static  enum AsynHttpClientUtil {
        INSTANCE;
         AsyncHttpClient  mAsyncHttpClient = new AsyncHttpClient();
        private static AsynHttpClientUtil mInstance = null;

        public  AsyncHttpClient getInstance() {
            return  mAsyncHttpClient;
        }

    }
}
