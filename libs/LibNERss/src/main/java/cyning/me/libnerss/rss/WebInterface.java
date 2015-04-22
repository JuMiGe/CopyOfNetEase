package cyning.me.libnerss.rss;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:35
 * Desc  : 网易的Rss接口
 */
public class WebInterface {

    public static String Host  = "http://c.3g.163.com/";

    /**
     * 频道列表
     */
    public static String TopicList = "nc/topicset/default.html";

    /**
     * 某个频道下的列表
     */
    public static String channelInfos = "nc/article/list/%s/%d-%d.html";



    public static String getChannelInfos(int pageNo){
        String url = new StringBuilder()
                .append(Host)
                .append(channelInfos).toString();
        return String.format(url,pageNo,pageNo,20);
    }


    public static String getTopicList(){
        return new StringBuilder()
                .append(Host)
                .append(TopicList).toString();
    }


}
