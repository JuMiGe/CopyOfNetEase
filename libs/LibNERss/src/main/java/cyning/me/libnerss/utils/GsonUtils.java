package cyning.me.libnerss.utils;

import com.google.gson.Gson;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:24
 * Desc  : 类/接口描述
 */
public enum  GsonUtils {

    Instance;

    Gson gson = new Gson();

    public Gson getInstance(){
        return  gson;
    }


}
