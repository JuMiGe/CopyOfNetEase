package com.jumige.android.libbell;

import com.jumige.android.common.utils.LayzLog;
import com.jumige.android.ui.template.base.DroidApplication;

/**
 * Author: cyning
 * Date  : 2015.04.08
 * Time  : 下午7:08
 * Desc  : 基本Application
 */
public class BaseNetEaseApplication extends DroidApplication {


    protected void initLog(boolean open) {
        if (open) {
            LayzLog.plant(new LayzLog.DebugTree());
        } else {
            LayzLog.plant(new CrashReportingTree());
        }
    }


    /**
     * A tree which logs important information for crash reporting.
     */
    private static class CrashReportingTree extends LayzLog.HollowTree {
        @Override
        public void i(String message, Object... args) {
        }

        @Override
        public void i(Throwable t, String message, Object... args) {
            i(message, args); // Just add to the log.
        }

        @Override
        public void e(String message, Object... args) {
            i("ERROR: " + message, args); // Just add to the log.
        }

        @Override
        public void e(Throwable t, String message, Object... args) {
            e(message, args);
        }
    }

}
