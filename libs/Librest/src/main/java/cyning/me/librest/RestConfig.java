package cyning.me.librest;

import android.content.Context;

/**
 * Author: cyning
 * Date  : 2015.04.09
 * Time  : 下午5:22
 * Desc  : Rest请求的配置
 */
public class RestConfig {

    private static RestConfig mInstance = null;

    private Context mContext;

    public static RestConfig getInstance() {
        if (mInstance == null) {
            synchronized (RestConfig.class) {
                if (mInstance == null) {
                    mInstance = new RestConfig();
                }
            }
        }
        return mInstance;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context _context) {
        mContext = _context;
    }
}
