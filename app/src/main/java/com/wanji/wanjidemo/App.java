package com.wanji.wanjidemo;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.mabeijianxi.smallvideorecord2.DeviceUtils;
import com.mabeijianxi.smallvideorecord2.JianXiCamera;

import java.io.File;

/**
 * by  :   syz
 * Time: 2018/10/9 13:13
 * Description:
 */
public class App extends Application {

    public static  String filePath;
    private static App    mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initSmallVideo();
    }

    public static App getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }


    public static void initSmallVideo() {
        // 设置拍摄视频缓存路径
        File dcim = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        filePath = dcim + "/WJFiles/";
        if (DeviceUtils.isZte() && !dcim.exists()) {
            filePath = dcim.getPath().replace("/sdcard/",
                    "/sdcard-ext/")
                    + "/WJFiles/";
        }
        JianXiCamera.setVideoCachePath(filePath);
        // 初始化拍摄，遇到问题可选择开启此标记，以方便生成日志
        JianXiCamera.initialize(true, null);
    }
}
