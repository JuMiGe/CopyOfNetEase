package cyning.me.libnerss.rss.Channel.handlers;

import com.jumige.android.common.utils.LayzLog;

import java.util.ArrayList;

import cyning.me.libnerss.rss.Channel.ChanInfo;
import cyning.me.libnerss.rss.NetEaseHandler;
import cyning.me.libnerss.rss.NetEaseParser;
import cyning.me.libnerss.rss.WebInterface;

/**
 * Author: cyning
 * Date  : 2015.04.23
 * Time  : 上午2:54
 * Desc  : 加载频道的Handler
 */
public class ChannelsHandler extends NetEaseHandler{

    public ChannelsHandler() {
        super(WebInterface.DEFAULT_TOPICSET, ChanInfo.class);
    }

    @Override
    public void onSuccess(String jsonStr) {
       ArrayList<ChanInfo> mChanInfos =  NetEaseParser.allChannels(jsonStr);
        onLoadSuccess(mChanInfos);

    }

    protected void onLoadSuccess(ArrayList<ChanInfo> mList) {
        LayzLog.d("onLoadSuccess -- > %s",mList.toString());
    }
}
