package cyning.me.libnerss.rss;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jumige.android.common.utils.LayzLog;

import java.util.ArrayList;
import java.util.List;

import cyning.me.libnerss.utils.GsonUtils;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:20
 * Desc  : 类/接口描述
 */
public class NetEaseParser {


    public static <T> List<T> getItems(String jsonString, final Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = GsonUtils.Instance.getInstance();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
        }
        LayzLog.d("list-->%s",list);
        return list;
    }
}
