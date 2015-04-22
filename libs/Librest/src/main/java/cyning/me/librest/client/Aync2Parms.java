package cyning.me.librest.client;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import cyning.me.librest.restcore.RequestParams;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:04
 * Desc  : 类/接口描述
 */
public class Aync2Parms {


    public static com.loopj.android.http.RequestParams toPararm(RequestParams _requestParams){

        com.loopj.android.http.RequestParams mParams = new com.loopj.android.http.RequestParams();
        for (ConcurrentHashMap.Entry<String, String> entry : _requestParams.getUrlParams().entrySet()) {

            mParams.put(entry.getKey(),entry.getValue());

        }

        for (ConcurrentHashMap.Entry<String, RequestParams.StreamWrapper> entry : _requestParams.getStreamParams().entrySet()) {
            mParams.put(entry.getKey(),entry.getValue());
        }

        for (ConcurrentHashMap.Entry<String, RequestParams.FileWrapper> entry : _requestParams.getFileParams().entrySet()) {
            mParams.put(entry.getKey(),entry.getValue());
        }

        List<BasicNameValuePair> params = mParams.getParamsList(null, _requestParams.getUrlParamsWithObjects());
        for (BasicNameValuePair kv : params) {
            mParams.put(kv.getName(),kv.getValue());
        }
        return  mParams;

    }

}
