package cyning.me.libnerss.rss.Channel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午11:49
 * Desc  : 类/接口描述
 */
public class ChanInfo implements Parcelable {


    /**
     * topics : 00340P92
     * cname : 新闻
     * tname : 画报
     * type : 新闻
     * tid : T1422935072191
     */
    private String topics;
    private String cname;
    private String tname;
    private String type;
    private String tid;

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTopics() {
        return topics;
    }

    public String getCname() {
        return cname;
    }

    public String getTname() {
        return tname;
    }

    public String getType() {
        return type;
    }

    public String getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return "ChanInfo{" +
                "topics='" + topics + '\'' +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                ", type='" + type + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.topics);
        dest.writeString(this.cname);
        dest.writeString(this.tname);
        dest.writeString(this.type);
        dest.writeString(this.tid);
    }

    public ChanInfo() {
    }

    private ChanInfo(Parcel in) {
        this.topics = in.readString();
        this.cname = in.readString();
        this.tname = in.readString();
        this.type = in.readString();
        this.tid = in.readString();
    }

    public static final Parcelable.Creator<ChanInfo> CREATOR = new Parcelable.Creator<ChanInfo>() {
        public ChanInfo createFromParcel(Parcel source) {
            return new ChanInfo(source);
        }

        public ChanInfo[] newArray(int size) {
            return new ChanInfo[size];
        }
    };
}
