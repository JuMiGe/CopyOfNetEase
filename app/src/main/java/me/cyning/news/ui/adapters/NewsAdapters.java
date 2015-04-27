package me.cyning.news.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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


    public NewsAdapters(Context context) {
        super(context,true);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null){
            convertView = View.inflate(mContext, R.layout.item_article_cover_text,null);
        }

        ImageView ivCover      = CommonViewHolder.get(convertView,R.id.ivCover);
        TextView  tvTitle      = CommonViewHolder.get(convertView,R.id.tvTitle);
        TextView  tvSubTitle   = CommonViewHolder.get(convertView,R.id.tvSubTitle);


        tvTitle.setText(getItem(position).getTitle());
        tvSubTitle.setText(getItem(position).getSubtitle());

        return convertView;
    }



    public class  ViewHolderType1 {



    }



}
