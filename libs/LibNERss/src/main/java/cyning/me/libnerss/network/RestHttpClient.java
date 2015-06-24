package cyning.me.libnerss.network;

import com.jumige.android.common.utils.LayzLog;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.apache.http.Header;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午9:50
 * Desc  : 类/接口描述
 */
public class RestHttpClient {

    private static RestHttpClient mInstance = null;

    public static RestHttpClient getInstance() {
        if (mInstance == null) {
            synchronized (RestHttpClient.class) {
                if (mInstance == null) {
                    mInstance = new RestHttpClient();
                }
            }
        }
        return mInstance;
    }


    private RestHttpClient() {

    }


    public void doGet(Object tag, String paramsUrl, Header[] headers, BaseApiHandler baseHandler) {


        LayzLog.i("url = %s", paramsUrl);


        if (headers != null) {
            LayzLog.i("headers = %s", headers.toString());
        }

        LayzLog.i("url = %s", paramsUrl);
        OkHttpClient mOkHttpClient = AsynHttpClientUtil.INSTANCE.getInstance();
        request(RequestType.GET, mOkHttpClient, paramsUrl, headers, tag, baseHandler);
    }

    void request(RequestType mRequestType, OkHttpClient mOkHttpClient, String url, Header[] headers, Object tag, BaseApiHandler baseHandler) {
        Request.Builder mBuilder = new Request.Builder();

        mBuilder.url(url);
        if (mRequestType == RequestType.GET) {
            mBuilder.get();
        } else {
            mBuilder.post(null);
        }


        if (headers != null) {
            Headers.Builder mHB = new Headers.Builder();
            for (int i = 0; i < headers.length; i++) {
                String value = headers[i].getValue();
                String key = headers[i].getName();
                mHB.add(key, value);


            }
            Headers mHeader = mHB.build();
            mBuilder.headers(mHeader);
        }


        mBuilder.tag(tag);


        Call mCall = mOkHttpClient.newCall(mBuilder.build());
        mCall.enqueue(baseHandler);
    }

    public void doGet(Object tag, String paramsUrl, BaseApiHandler baseHandler) {
        this.doGet(tag, paramsUrl, null, baseHandler);


    }

    public void doPost(Object tag, String paramsUrl, Header[] headers, BaseApiHandler baseHandler) {
        OkHttpClient mOkHttpClient = AsynHttpClientUtil.INSTANCE.getInstance();
        request(RequestType.GET, mOkHttpClient, paramsUrl, headers, tag, baseHandler);
    }

    public void cancel(Object object, boolean is) {
        AsynHttpClientUtil.INSTANCE.getInstance().cancel(object);
    }

    public void cancel(Object object) {
        cancel(object, true);
    }


    public static enum AsynHttpClientUtil {
        INSTANCE;
        OkHttpClient mAsyncHttpClient = new OkHttpClient();
        private static AsynHttpClientUtil mInstance = null;

        public OkHttpClient getInstance() {
            return mAsyncHttpClient;
        }

    }
}
