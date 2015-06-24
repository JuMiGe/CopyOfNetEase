package cyning.me.libnerss.rss;

import com.jumige.android.common.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cyning.me.libnerss.network.BaseApiHandler;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:02
 * Desc  : 类/接口描述
 */
public class NetEaseHandler<T> extends BaseApiHandler{

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






    public void  parseJsonArr(JSONArray itemInfos){

    }



    /**************************************************** *BaseAPIHandler ************************************************************/
    @Override
    public void onSuccess(String string) {

        try {
            JSONObject response = new JSONObject(string);
            if (!StringUtils.isEmpty(tag)){
                JSONArray itemInfos = response.optJSONArray(tag);
                parseJsonArr(itemInfos);
            }
        } catch (JSONException e) {
            e.printStackTrace();


            onFailure(null,string);
        }
    }

    @Override
    public void onFailure(String url, String string) {

    }

    @Override
    public void onError(String string) {

    }


}
