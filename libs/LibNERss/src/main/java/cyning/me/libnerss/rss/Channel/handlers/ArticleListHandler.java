package cyning.me.libnerss.rss.Channel.handlers;

import org.json.JSONArray;

import java.util.ArrayList;

import cyning.me.libnerss.rss.Channel.ArticleItem;
import cyning.me.libnerss.rss.NetEaseHandler;
import cyning.me.libnerss.rss.NetEaseParser;

/**
 * Author: cyning
 * Date  : 2015.04.27
 * Time  : 下午1:02
 * Desc  : 类/接口描述
 */
public class ArticleListHandler extends NetEaseHandler {

    public ArticleListHandler() {
        super( ArticleItem.class);
    }




    @Override
    public void parseJsonArr(JSONArray itemInfos) {

        ArrayList<ArticleItem> mArticals = NetEaseParser.getArticalList(itemInfos);
        onSuccess(mArticals);

    }

    public void onSuccess( ArrayList<ArticleItem> mArticals){

    }
}
