package com.jumige.android.ui.template.utils;

import android.app.Activity;

import com.shijiebang.template.R;

/**
 * 页面的特效
 */
public class AcitvityHelper {


	/**
	 * @param activity
     * <p><----</p>
	 */
	static public void enterWithAnimationIn(Activity activity){
		activity.overridePendingTransition(R.anim.action_push_right_in, R.anim.action_push_left_out);
	}
    /**
     * @param activity
     * <p>---></p>
     */
	static public void finishWithAnimationOut(Activity activity){
        activity.overridePendingTransition(R.anim.action_push_left_in, R.anim.action_push_right_out);
	}
	static public void finishWithAnimation(Activity act,int enterAnim,int exitAnim ){
		act.overridePendingTransition(enterAnim, exitAnim);
	}
    static public void enterLeft(Activity act,int enterAnim,int exitAnim ){
        act.overridePendingTransition(R.anim.action_push_right_in,R.anim.action_push_left_out );
    }
    static public void exitRight(Activity act){
        act.overridePendingTransition(R.anim.hold,R.anim.action_push_right_out);
    }


}
