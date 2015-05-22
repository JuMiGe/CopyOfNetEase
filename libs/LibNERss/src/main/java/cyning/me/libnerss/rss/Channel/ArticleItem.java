package cyning.me.libnerss.rss.Channel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.jumige.android.common.utils.ParcelableUtils;

import java.util.ArrayList;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:53
 * Desc  : 类/接口描述
 */
public class ArticleItem implements Parcelable {


    /**
     * editor :
     * votecount : 3186
     * docid : ALNTLFOR00014J1V
     * lmodify : 2015-03-27 18:14:41
     * url_3w : http://news.163.com/15/0327/17/ALNTLFOR00014J1V.html
     * source : 网易探索
     * title : 跳标准广场舞 做标准中国人
     * priority : 70
     * url : http://3g.163.com/news/15/0327/17/ALNTLFOR00014J1V.html
     * replyCount : 3647
     * subtitle :
     * digest : 国家体育总局要标准化《小苹果》，测测你是否标准。
     * boardid : news_shehui7_bbs
     * imgsrc : http://img1.cache.netease.com/3g/2015/3/27/2015032717590190384.jpg
     * ptime : 2015-03-27 17:33:46
     * imgType : 1
     */
    @SerializedName("a")
    private String editor;
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
    private int imgType;

    private String skipType;
    private String skipId;

    private ArrayList<SpecialextraInfo> specialextra;

    private ArrayList<ImageUrl> imgextra;

    public String getSkipType() {
        return skipType;
    }

    public void setSkipType(String _skipType) {
        skipType = _skipType;
    }

    public String getSkipId() {
        return skipId;
    }

    public void setSkipId(String _skipId) {
        skipId = _skipId;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

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

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public String getEditor() {
        return editor;
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

    public int getImgType() {
        return imgType;
    }

    public ArrayList<SpecialextraInfo> getSpecialextra() {
        return specialextra;
    }

    public void setSpecialextra(ArrayList<SpecialextraInfo> _specialextra) {
        specialextra = _specialextra;
    }

    public ArrayList<ImageUrl> getImgextra() {
        return imgextra;
    }

    public void setImgextra(ArrayList<ImageUrl> _imgextra) {
        imgextra = _imgextra;
    }

    @Override
    public String toString() {
        return "ArticleItem{" +
                "editor='" + editor + '\'' +
                ", votecount=" + votecount +
                ", docid='" + docid + '\'' +
                ", lmodify='" + lmodify + '\'' +
                ", url_3w='" + url_3w + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", url='" + url + '\'' +
                ", replyCount=" + replyCount +
                ", subtitle='" + subtitle + '\'' +
                ", digest='" + digest + '\'' +
                ", boardid='" + boardid + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", ptime='" + ptime + '\'' +
                ", imgType=" + imgType +
                ", skipType='" + skipType + '\'' +
                ", skipId='" + skipId + '\'' +
                ", specialextra=" + specialextra +
                ", imgextra=" + imgextra +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.editor);
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
        dest.writeInt(this.imgType);
        dest.writeString(this.skipType);
        dest.writeString(this.skipId);

        ParcelableUtils.writeList(dest, this.imgextra, flags);
        ParcelableUtils.writeList(dest, this.specialextra, flags);
    }

    public ArticleItem() {
    }

    private ArticleItem(Parcel in) {
        this.editor = in.readString();
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
        this.imgType = in.readInt();
        this.skipType = in.readString();
        this.skipId = in.readString();
        this.imgextra =ParcelableUtils.readParcelableList(in,ImageUrl.class.getClassLoader());
        this.specialextra =ParcelableUtils.readParcelableList(in,SpecialextraInfo.class.getClassLoader());
    }

    public static final Creator<ArticleItem> CREATOR = new Creator<ArticleItem>() {
        public ArticleItem createFromParcel(Parcel source) {
            return new ArticleItem(source);
        }

        public ArticleItem[] newArray(int size) {
            return new ArticleItem[size];
        }
    };

    public  static class ImageUrl implements Parcelable {
        private String imgsrc ;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String _imgsrc) {
            imgsrc = _imgsrc;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.imgsrc);
        }

        public ImageUrl() {
        }

        private ImageUrl(Parcel in) {
            this.imgsrc = in.readString();
        }

        public static final Creator<ImageUrl> CREATOR = new Creator<ImageUrl>() {
            public ImageUrl createFromParcel(Parcel source) {
                return new ImageUrl(source);
            }

            public ImageUrl[] newArray(int size) {
                return new ImageUrl[size];
            }
        };


        @Override
        public String toString() {
            return "ImageUrl{" +
                    "imgsrc='" + imgsrc + '\'' +
                    '}';
        }
    }



}
