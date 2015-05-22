package cyning.me.libnerss.rss;

import android.content.Context;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:45
 * Desc  : 网易的新闻接口
 */
public class NetEaseRssAPI  {


    private static NetEaseRssAPI mInstance = null;

    private Context mContext;

    public static NetEaseRssAPI getInstance(Context _context) {
        if (mInstance == null) {
            synchronized (NetEaseRssAPI.class) {
                if (mInstance == null) {
                    mInstance = new NetEaseRssAPI(_context);
                }
            }
        }
        return mInstance;
    }

    private NetEaseRssAPI(Context _context) {
        mContext = _context;
    }





}
