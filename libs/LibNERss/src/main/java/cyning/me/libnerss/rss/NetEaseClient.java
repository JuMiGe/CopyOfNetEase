package cyning.me.libnerss.rss;

import cyning.me.librest.client.AsynHttpClient;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:34
 * Desc  : 类/接口描述
 */
public class NetEaseClient extends AsynHttpClient {


    private static NetEaseClient mInstance = null;

    public static NetEaseClient getInstance() {
        if (mInstance == null) {
            synchronized (NetEaseClient.class) {
                if (mInstance == null) {
                    mInstance = new NetEaseClient();
                }
            }
        }
        return mInstance;
    }

   public void getAllChannels(NetEaseHandler _netEaseHandler){
       String url = WebInterface.getTopicList();
       doGet(url,url,_netEaseHandler);
   }

    public void getArticleList(String tid,boolean isHeadLine,long pageNo,NetEaseHandler _netEaseHandler){
        String url = WebInterface.getArticleList(tid,isHeadLine,pageNo);
        doGet(url,url,_netEaseHandler);
    }

}
