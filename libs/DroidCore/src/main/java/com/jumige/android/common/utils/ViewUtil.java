package com.jumige.android.common.utils;

import android.app.Activity;
import android.view.View;

public class ViewUtil {
	@SuppressWarnings("unchecked")
    public static <V extends View> V find(Activity ac, int id) {

        return (V) ac.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public static <V extends View> V find(View view, int id) {

        return (V) view.findViewById(id);
    }

    public static  void goneView(View _view){
        if (_view!= null && _view.getVisibility() != View.GONE){
            _view.setVisibility(View.GONE);
        }
    }
    public static  void viewVisuble(View _view){
        if (_view!= null && _view.getVisibility() != View.VISIBLE){
            _view.setVisibility(View.VISIBLE);
        }
    }

}
