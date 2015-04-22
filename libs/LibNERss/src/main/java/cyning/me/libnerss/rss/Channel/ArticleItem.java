package cyning.me.libnerss.rss.Channel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:53
 * Desc  : 类/接口描述
 */
public class ArticleItem implements Parcelable {


    /**
     * template : manual
     * lmodify : 2015-04-20 22:11:19
     * source : 网易
     * title : 不可复制的朝阳群众
     * hasImg : 0
     * digest : 举报毒星嫖星不在话下，朝阳群众凭什么出名？
     * boardid : tinyblog_bbs
     * alias : Visual News
     * hasAD : 0
     * imgsrc : http://img2.cache.netease.com/3g/2015/4/20/2015042013421647763.png
     * ptime : 2015-04-20 17:38:46
     * hasHead : 1
     * order : 1
     * imgType : 1
     * editor : d
     * votecount : 2353
     * hasCover : true
     * docid : ANLNFSL90004659K
     * tname : 画报
     * url_3w : http://help.3g.163.com/15/0420/17/ANLNFSL90004659K.html
     * priority : 86
     * url : http://3g.163.com/ntes/15/0420/17/ANLNFSL90004659K.html
     * replyCount : 2674
     * ename : Huabao
     * hasIcon : true
     * subtitle :
     * TAG : 画报
     * TAGS : 画报
     * cid : C1348647991705
     */
    private String template;
    private String lmodify;
    private String source;
    private String title;
    private int hasImg;
    private String digest;
    private String boardid;
    private String alias;
    private int hasAD;
    private String imgsrc;
    private String ptime;
    private int hasHead;
    private int order;
    private int imgType;
//    private String editor;
    private int votecount;
    private boolean hasCover;
    private String docid;
    private String tname;
    private String url_3w;
    private int priority;
    private String url;
    private int replyCount;
    private String ename;
    private boolean hasIcon;
    private String subtitle;
    private String TAG;
    private String TAGS;
    private String cid;

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHasImg(int hasImg) {
        this.hasImg = hasImg;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setHasAD(int hasAD) {
        this.hasAD = hasAD;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public void setHasHead(int hasHead) {
        this.hasHead = hasHead;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

//    public void setEditor(String editor) {
//        this.editor = editor;
//    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setUrl_3w(String url_3w) {
        this.url_3w = url_3w;
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

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public void setTAGS(String TAGS) {
        this.TAGS = TAGS;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTemplate() {
        return template;
    }

    public String getLmodify() {
        return lmodify;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public int getHasImg() {
        return hasImg;
    }

    public String getDigest() {
        return digest;
    }

    public String getBoardid() {
        return boardid;
    }

    public String getAlias() {
        return alias;
    }

    public int getHasAD() {
        return hasAD;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getPtime() {
        return ptime;
    }

    public int getHasHead() {
        return hasHead;
    }

    public int getOrder() {
        return order;
    }

    public int getImgType() {
        return imgType;
    }

//    public String getEditor() {
//        return editor;
//    }

    public int getVotecount() {
        return votecount;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public String getDocid() {
        return docid;
    }

    public String getTname() {
        return tname;
    }

    public String getUrl_3w() {
        return url_3w;
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

    public String getEname() {
        return ename;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTAG() {
        return TAG;
    }

    public String getTAGS() {
        return TAGS;
    }

    public String getCid() {
        return cid;
    }


    @Override
    public String toString() {
        return "ArticleItem{" +
                "template='" + template + '\'' +
                ", lmodify='" + lmodify + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                ", hasImg=" + hasImg +
                ", digest='" + digest + '\'' +
                ", boardid='" + boardid + '\'' +
                ", alias='" + alias + '\'' +
                ", hasAD=" + hasAD +
                ", imgsrc='" + imgsrc + '\'' +
                ", ptime='" + ptime + '\'' +
                ", hasHead=" + hasHead +
                ", order=" + order +
                ", imgType=" + imgType +
                ", votecount=" + votecount +
                ", hasCover=" + hasCover +
                ", docid='" + docid + '\'' +
                ", tname='" + tname + '\'' +
                ", url_3w='" + url_3w + '\'' +
                ", priority=" + priority +
                ", url='" + url + '\'' +
                ", replyCount=" + replyCount +
                ", ename='" + ename + '\'' +
                ", hasIcon=" + hasIcon +
                ", subtitle='" + subtitle + '\'' +
                ", TAG='" + TAG + '\'' +
                ", TAGS='" + TAGS + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.template);
        dest.writeString(this.lmodify);
        dest.writeString(this.source);
        dest.writeString(this.title);
        dest.writeInt(this.hasImg);
        dest.writeString(this.digest);
        dest.writeString(this.boardid);
        dest.writeString(this.alias);
        dest.writeInt(this.hasAD);
        dest.writeString(this.imgsrc);
        dest.writeString(this.ptime);
        dest.writeInt(this.hasHead);
        dest.writeInt(this.order);
        dest.writeInt(this.imgType);
        dest.writeInt(this.votecount);
        dest.writeByte(hasCover ? (byte) 1 : (byte) 0);
        dest.writeString(this.docid);
        dest.writeString(this.tname);
        dest.writeString(this.url_3w);
        dest.writeInt(this.priority);
        dest.writeString(this.url);
        dest.writeInt(this.replyCount);
        dest.writeString(this.ename);
        dest.writeByte(hasIcon ? (byte) 1 : (byte) 0);
        dest.writeString(this.subtitle);
        dest.writeString(this.TAG);
        dest.writeString(this.TAGS);
        dest.writeString(this.cid);
    }

    public ArticleItem() {
    }

    private ArticleItem(Parcel in) {
        this.template = in.readString();
        this.lmodify = in.readString();
        this.source = in.readString();
        this.title = in.readString();
        this.hasImg = in.readInt();
        this.digest = in.readString();
        this.boardid = in.readString();
        this.alias = in.readString();
        this.hasAD = in.readInt();
        this.imgsrc = in.readString();
        this.ptime = in.readString();
        this.hasHead = in.readInt();
        this.order = in.readInt();
        this.imgType = in.readInt();
        this.votecount = in.readInt();
        this.hasCover = in.readByte() != 0;
        this.docid = in.readString();
        this.tname = in.readString();
        this.url_3w = in.readString();
        this.priority = in.readInt();
        this.url = in.readString();
        this.replyCount = in.readInt();
        this.ename = in.readString();
        this.hasIcon = in.readByte() != 0;
        this.subtitle = in.readString();
        this.TAG = in.readString();
        this.TAGS = in.readString();
        this.cid = in.readString();
    }

    public static final Parcelable.Creator<ArticleItem> CREATOR = new Parcelable.Creator<ArticleItem>() {
        public ArticleItem createFromParcel(Parcel source) {
            return new ArticleItem(source);
        }

        public ArticleItem[] newArray(int size) {
            return new ArticleItem[size];
        }
    };
}
