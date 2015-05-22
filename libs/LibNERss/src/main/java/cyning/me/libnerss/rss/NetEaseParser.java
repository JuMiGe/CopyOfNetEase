package cyning.me.libnerss.rss;

import com.google.gson.Gson;
import com.jumige.android.common.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cyning.me.libnerss.rss.Channel.ArticleItem;
import cyning.me.libnerss.rss.Channel.ChanInfo;
import cyning.me.libnerss.utils.GsonUtils;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午12:20
 * Desc  : 类/接口描述
 */
public class NetEaseParser {


    /**
     * 解析所有的Channel
     * @param string
     * @return
     */
    public static ArrayList<ChanInfo> allChannels(String string){
        ArrayList<ChanInfo> mArrayList = null;
        try {


            if (!StringUtils.isEmpty(string)){
                mArrayList = new ArrayList<ChanInfo>();
                JSONArray mJSONArray = new JSONArray(string);
                int size = mJSONArray.length();
                for (int i = 0; i < size; i++) {
                    JSONObject topicList = mJSONArray.optJSONObject(i);
                    String cname = topicList.optString("cName");
                    String cid = topicList.optString("cid");

                    JSONArray topics = topicList.optJSONArray("tList");
                    int topSize = topics.length();

                    for (int j=0;j<topSize;j++){
                        JSONObject mTopic  = topics.optJSONObject(j);
                        Gson gson = GsonUtils.Instance.getInstance();
                        ChanInfo mChanInfo  = gson.fromJson(mTopic.toString(), ChanInfo.class);
                        mChanInfo.setcName(cname);
                        mChanInfo.setCid(cid);
                        mArrayList.add(mChanInfo);


                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  mArrayList;

    }

   public static  ArrayList<ArticleItem>  getArticalList(JSONArray itemInfos ){

       ArrayList<ArticleItem> mArticleItems = null;
       if (itemInfos != null){
           int size = itemInfos.length();
           mArticleItems = new ArrayList<>();
           for (int i = 0; i < size; i++) {

               JSONObject  mArticalObj = itemInfos.optJSONObject(i);
               Gson gson = GsonUtils.Instance.getInstance();
               ArticleItem mArticleItem  = gson.fromJson(mArticalObj.toString(), ArticleItem.class);
               mArticleItems.add(mArticleItem);
           }
       }
       return mArticleItems;
   }




}
