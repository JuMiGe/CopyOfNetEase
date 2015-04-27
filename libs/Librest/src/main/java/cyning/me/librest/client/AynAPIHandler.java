package cyning.me.librest.client;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import cyning.me.librest.restcore.BaseApiHandler;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:19
 * Desc  : API返回的Handler
 */
public class AynAPIHandler extends JsonHttpResponseHandler implements BaseApiHandler {




    @Override
    public  void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
    }

    @Override
    public  void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        super.onSuccess(statusCode, headers, response);
    }

    @Override
    public final void onSuccess(int statusCode, Header[] headers, String responseString) {
        super.onSuccess(statusCode, headers, responseString);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        super.onFailure(statusCode, headers, throwable, errorResponse);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        super.onFailure(statusCode, headers, throwable, errorResponse);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        super.onFailure(statusCode, headers, responseString, throwable);
    }



    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onSuccess(String jsonStr) {

    }

    @Override
    public void onServerError() {

    }

    @Override
    public void onClientError() {

    }
}
