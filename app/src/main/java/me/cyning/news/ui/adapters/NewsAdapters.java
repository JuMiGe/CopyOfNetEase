package me.cyning.news.ui.adapters;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jumige.android.common.adapter.ArrayListAdapter;
import com.jumige.android.ui.template.utils.CommonViewHolder;

import cyning.me.libnerss.rss.Channel.ArticleItem;
import me.cyning.news.R;

/**
 * Author: cyning
 * Date  : 2015.04.27
 * Time  : 下午12:27
 * Desc  : 新闻列表
 */
public class NewsAdapters extends ArrayListAdapter<ArticleItem> {


    private Fragment mFragment =null;

    public NewsAdapters(Fragment _fragment) {
        super(_fragment.getActivity(),true);
        this.mFragment = _fragment;

    }

    @Override
    public ArticleItem getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null){
            convertView = View.inflate(mContext, R.layout.item_article_cover_text,null);
        }

        ImageView ivCover      = CommonViewHolder.get(convertView,R.id.ivCover);
        TextView  tvTitle      = CommonViewHolder.get(convertView,R.id.tvTitle);
        TextView  tvSubTitle   = CommonViewHolder.get(convertView,R.id.tvSubTitle);


        ArticleItem mItem = getItem(position);

        Glide.with(mFragment)
                .load(mItem.getImgsrc())
                .centerCrop()
                .placeholder(R.drawable.icon_title)
                .crossFade()
                .into(ivCover);
        tvTitle.setText(getItem(position).getTitle());
        tvSubTitle.setText(getItem(position).getDigest());

        return convertView;
    }



    public class  ViewHolderType1 {



    }



}
