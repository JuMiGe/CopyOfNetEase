package com.jumige.android.common.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * 里面存放的是关于路径的一些helper类
 *
 * @author Cyning
 * @date 2014-7-10 上午9:57:12
 */
public class PathUtil {
    private static final String FILEPATH = "file";

    public static File getFileDiskCacheDir(Context context, String fileName) throws IOException {
        return getFileDiskCacheDir(context, fileName, true);
    }

    public static File getFileDiskCacheDir(Context context, String fileName, boolean isCreate) throws IOException {
        File folder = getDiskCacheDir(context, FILEPATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder, fileName);
        if (!file.exists() && isCreate) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * Get a usable cache directory (external if available, internal otherwise).
     *
     * @param context    The context to use
     * @param uniqueName A unique directory name to append to the cache dir
     * @return The cache dir
     */
    public synchronized static File getDiskCacheDir(Context context, String uniqueName) {
        // Check if media is mounted or storage is built-in, if so, try and use external cache dir
        // otherwise use internal cache dir
        final String cachePath =
                Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !isExternalStorageRemovable() ?
                        getExternalCacheDir(context).getPath() :
                        context.getCacheDir().getPath();
        return new File(cachePath + File.separator + uniqueName);
    }

    /**
     * @param context
     * @param uniqueName
     * @return  获取内部存储。/data/data 下的
     */
    public synchronized static File getInterCacheDir(Context context, String uniqueName) {
        // Check if media is mounted or storage is built-in, if so, try and use external cache dir
        // otherwise use internal cache dir
        return new File(context.getCacheDir().getPath() + File.separator + uniqueName);
    }


    /**
     * Check if external storage is built-in or removable.
     *
     * @return True if external storage is removable (like an SD card), false
     * otherwise.
     */
    @TargetApi(9)
    public static boolean isExternalStorageRemovable() {
        if (VersionCompatUtils.hasGingerbread()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    @TargetApi(8)
    public static File getExternalCacheDir(Context context) {
        if (VersionCompatUtils.hasFroyo()) {
            return context.getExternalCacheDir() == null ? getExCacheFile(context) : context.getExternalCacheDir();
        }
        return getExCacheFile(context);
    }

    private static File getExCacheFile(Context context) {
        final String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
        return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
    }
}
