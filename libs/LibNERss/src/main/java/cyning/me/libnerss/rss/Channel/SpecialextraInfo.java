package cyning.me.libnerss.rss.Channel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: cyning
 * Date  : 2015.04.27
 * Time  : 下午6:57
 * Desc  : 类/接口描述
 */
public  class SpecialextraInfo implements Parcelable{

    /**
     * votecount : 1521
     * docid : AO6A8E0900014AED
     * lmodify : 2015-04-27 15:36:31
     * url_3w : http://news.163.com/15/0427/04/AO6A8E0900014AED.html
     * source : 中安在线
     * title : 乘客醉酒后发钱 醒来以为遭贼
     * priority : 79
     * url : http://3g.163.com/news/15/0427/04/AO6A8E0900014AED.html
     * replyCount : 1724
     * subtitle :
     * digest : 上火车后四处发钱，幸得工作人员帮忙钱都收了回来。
     * boardid : news3_bbs
     * imgsrc : http://img1.cache.netease.com/3g/2015/4/27/201504271009397fa70.png
     * ptime : 2015-04-27 04:12:14
     */
    private int votecount;
    private String docid;
    private String lmodify;
    private String url_3w;
    private String source;
    private String title;
    private int priority;
    private String url;
    private int replyCount;
    private String subtitle;
    private String digest;
    private String boardid;
    private String imgsrc;
    private String ptime;

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public void setUrl_3w(String url_3w) {
        this.url_3w = url_3w;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public int getVotecount() {
        return votecount;
    }

    public String getDocid() {
        return docid;
    }

    public String getLmodify() {
        return lmodify;
    }

    public String getUrl_3w() {
        return url_3w;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public String getUrl() {
        return url;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDigest() {
        return digest;
    }

    public String getBoardid() {
        return boardid;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getPtime() {
        return ptime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.votecount);
        dest.writeString(this.docid);
        dest.writeString(this.lmodify);
        dest.writeString(this.url_3w);
        dest.writeString(this.source);
        dest.writeString(this.title);
        dest.writeInt(this.priority);
        dest.writeString(this.url);
        dest.writeInt(this.replyCount);
        dest.writeString(this.subtitle);
        dest.writeString(this.digest);
        dest.writeString(this.boardid);
        dest.writeString(this.imgsrc);
        dest.writeString(this.ptime);
    }

    public SpecialextraInfo() {
    }

    private SpecialextraInfo(Parcel in) {
        this.votecount = in.readInt();
        this.docid = in.readString();
        this.lmodify = in.readString();
        this.url_3w = in.readString();
        this.source = in.readString();
        this.title = in.readString();
        this.priority = in.readInt();
        this.url = in.readString();
        this.replyCount = in.readInt();
        this.subtitle = in.readString();
        this.digest = in.readString();
        this.boardid = in.readString();
        this.imgsrc = in.readString();
        this.ptime = in.readString();
    }

    public static final Creator<SpecialextraInfo> CREATOR = new Creator<SpecialextraInfo>() {
        public SpecialextraInfo createFromParcel(Parcel source) {
            return new SpecialextraInfo(source);
        }

        public SpecialextraInfo[] newArray(int size) {
            return new SpecialextraInfo[size];
        }
    };
}
