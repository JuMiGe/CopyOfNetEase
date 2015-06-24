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
     * template : manual
     * img :
     * recommendOrder : 0
     * color :
     * hasCover : false
     * tname : 头条
     * recommend : 0
     * isNew : 0
     * tid : T1348647909107
     * headLine : true
     * topicid : 003406E3
     * ename : androidnews
     * hasIcon : false
     * bannerOrder : 0
     * alias : Top News
     * showType : comment
     * subnum : 3.2万
     * isHot : 0
     * cid : C1348646712614
     */
    private String template;
    private String img;
    private int recommendOrder;
    private String color;
    private boolean hasCover;
    private String tname;
    private String recommend;
    private int isNew;
    private String tid;
    private boolean headLine;
    private String topicid;
    private String ename;
    private boolean hasIcon;
    private int bannerOrder;
    private String alias;
    private String showType;
    private String subnum;
    private int isHot;
    private String cid;


    public String cName;
    public String cId;


    public String getTemplate() {
        return template;
    }

    public void setTemplate(String _template) {
        template = _template;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String _img) {
        img = _img;
    }

    public int getRecommendOrder() {
        return recommendOrder;
    }

    public void setRecommendOrder(int _recommendOrder) {
        recommendOrder = _recommendOrder;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String _color) {
        color = _color;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public void setHasCover(boolean _hasCover) {
        hasCover = _hasCover;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String _tname) {
        tname = _tname;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String _recommend) {
        recommend = _recommend;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int _isNew) {
        isNew = _isNew;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String _tid) {
        tid = _tid;
    }

    public boolean isHeadLine() {
        return headLine;
    }

    public void setHeadLine(boolean _headLine) {
        headLine = _headLine;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String _topicid) {
        topicid = _topicid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String _ename) {
        ename = _ename;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public void setHasIcon(boolean _hasIcon) {
        hasIcon = _hasIcon;
    }

    public int getBannerOrder() {
        return bannerOrder;
    }

    public void setBannerOrder(int _bannerOrder) {
        bannerOrder = _bannerOrder;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String _alias) {
        alias = _alias;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String _showType) {
        showType = _showType;
    }

    public String getSubnum() {
        return subnum;
    }

    public void setSubnum(String _subnum) {
        subnum = _subnum;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int _isHot) {
        isHot = _isHot;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String _cid) {
        cid = _cid;
    }


    public String getcName() {
        return cName;
    }

    public void setcName(String _cName) {
        cName = _cName;
    }


    public String getcId() {
        return cId;
    }

    public void setcId(String _cId) {
        cId = _cId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.template);
        dest.writeString(this.img);
        dest.writeInt(this.recommendOrder);
        dest.writeString(this.color);
        dest.writeByte(hasCover ? (byte) 1 : (byte) 0);
        dest.writeString(this.tname);
        dest.writeString(this.recommend);
        dest.writeInt(this.isNew);
        dest.writeString(this.tid);
        dest.writeByte(headLine ? (byte) 1 : (byte) 0);
        dest.writeString(this.topicid);
        dest.writeString(this.ename);
        dest.writeByte(hasIcon ? (byte) 1 : (byte) 0);
        dest.writeInt(this.bannerOrder);
        dest.writeString(this.alias);
        dest.writeString(this.showType);
        dest.writeString(this.subnum);
        dest.writeInt(this.isHot);
        dest.writeString(this.cid);
        dest.writeString(this.cName);
        dest.writeString(this.cId);
    }

    public ChanInfo() {
    }

    private ChanInfo(Parcel in) {
        this.template = in.readString();
        this.img = in.readString();
        this.recommendOrder = in.readInt();
        this.color = in.readString();
        this.hasCover = in.readByte() != 0;
        this.tname = in.readString();
        this.recommend = in.readString();
        this.isNew = in.readInt();
        this.tid = in.readString();
        this.headLine = in.readByte() != 0;
        this.topicid = in.readString();
        this.ename = in.readString();
        this.hasIcon = in.readByte() != 0;
        this.bannerOrder = in.readInt();
        this.alias = in.readString();
        this.showType = in.readString();
        this.subnum = in.readString();
        this.isHot = in.readInt();
        this.cid = in.readString();
        this.cName = in.readString();
        this.cId = in.readString();
    }

    public static final Creator<ChanInfo> CREATOR = new Creator<ChanInfo>() {
        public ChanInfo createFromParcel(Parcel source) {
            return new ChanInfo(source);
        }

        public ChanInfo[] newArray(int size) {
            return new ChanInfo[size];
        }
    };

    @Override
    public String toString() {
        return "ChanInfo{" +
                "template='" + template + '\'' +
                ", img='" + img + '\'' +
                ", recommendOrder=" + recommendOrder +
                ", color='" + color + '\'' +
                ", hasCover=" + hasCover +
                ", tname='" + tname + '\'' +
                ", recommend='" + recommend + '\'' +
                ", isNew=" + isNew +
                ", tid='" + tid + '\'' +
                ", headLine=" + headLine +
                ", topicid='" + topicid + '\'' +
                ", ename='" + ename + '\'' +
                ", hasIcon=" + hasIcon +
                ", bannerOrder=" + bannerOrder +
                ", alias='" + alias + '\'' +
                ", showType='" + showType + '\'' +
                ", subnum='" + subnum + '\'' +
                ", isHot=" + isHot +
                ", cid='" + cid + '\'' +
                ", cName='" + cName + '\'' +
                ", cId='" + cId + '\'' +
                '}';
    }
}
