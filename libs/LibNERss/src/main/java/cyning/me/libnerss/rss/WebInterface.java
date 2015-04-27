package cyning.me.libnerss.rss;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:35
 * Desc  : 网易的Rss接口
 */
public class WebInterface {

    public static String Host  = "http://c.m.163.com/";

    /**
     * 频道列表
     */
    public static String TopicList = "nc/topicset/android/v4/subscribe/news/all.html";

    /**
     * 某个频道下的列表
     * nc/article/headline/T1422935072191/0-20.html
     */
    public static String channelInfos = "nc/article/%s/%s/%d-20.html";



    public static String getArticleList(String tid,boolean isHeadLine,long pageNo){
        String url = new StringBuilder()
                .append(Host)
                .append(channelInfos).toString();
        String pre = "list";
        if (isHeadLine){
            pre = "headline";
        }
        return String.format(url,pre,tid,pageNo*20);
    }


    public static String getTopicList(){
        return new StringBuilder()
                .append(Host)
                .append(TopicList).toString();
    }



    public static final String DEFAULT_TOPICSET = "default-topicset";



}
