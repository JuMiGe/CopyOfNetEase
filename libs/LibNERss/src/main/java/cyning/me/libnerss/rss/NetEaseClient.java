package cyning.me.libnerss.rss;


import cyning.me.libnerss.network.RestHttpClient;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:34
 * Desc  : 类/接口描述
 */
public class NetEaseClient  {


    private static NetEaseClient mInstance = null;


    private  RestHttpClient mHttpClient;

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


    private NetEaseClient(){
        mHttpClient = RestHttpClient.getInstance();

    }
   public void getAllChannels(NetEaseHandler _netEaseHandler){
       String url = WebInterface.getTopicList();
       mHttpClient.doGet(url,url,_netEaseHandler);
   }

    public void getArticleList(String tid,boolean isHeadLine,long pageNo,NetEaseHandler _netEaseHandler){
        String url = WebInterface.getArticleList(tid,isHeadLine,pageNo);
        mHttpClient.doGet(tid+"_"+pageNo,url,_netEaseHandler);
    }

    public void cancelArticleList(String tid,long pageNo){
        mHttpClient.cancel(tid+"_"+pageNo);
    }


}
