package cyning.me.libnerss.rss;

import com.jumige.android.common.utils.StringUtils;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import cyning.me.libnerss.rss.Channel.ChanInfo;
import cyning.me.librest.client.AynAPIHandler;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:02
 * Desc  : 类/接口描述
 */
public class NetEaseHandler extends AynAPIHandler{

    public String tag;

    private Class mClazz;

    public NetEaseHandler(String _tag, Class _clazz) {
        tag = _tag;
        mClazz = _clazz;
    }

    public NetEaseHandler(Class _clazz) {
        mClazz = _clazz;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String _tag) {
        tag = _tag;
    }

    public Class getClazz() {
        return mClazz;
    }

    public void setClazz(Class _class) {
        mClazz = _class;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);

        if (!StringUtils.isEmpty(tag)){
            JSONArray itemInfos = response.optJSONArray(tag);
            NetEaseParser.getItems(itemInfos.toString(), ChanInfo.class);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }

    @Override
    public void onSuccess(String jsonStr) {
        super.onSuccess(jsonStr);
    }

    @Override
    public void onServerError() {
        super.onServerError();
    }

    @Override
    public void onClientError() {
        super.onClientError();
    }
}
