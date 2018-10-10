package com.wanji.wanjidemo.base;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.mabeijianxi.smallvideorecord2.StringUtils;
import com.wanji.wanjidemo.App;

/**
 * by  :   syz
 * Time: 2018/10/10 15:24
 * Description:
 */
public class BaseActivity extends AppCompatActivity {


    private ProgressDialog mProgressDialog;
    private Toast          mToast;

    protected void showProgress(String title, String message, int theme) {
        if (mProgressDialog == null) {
            if (theme > 0)
                mProgressDialog = new ProgressDialog(this, theme);
            else
                mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setCanceledOnTouchOutside(false);// 不能取消
            mProgressDialog.setCancelable(false);
            mProgressDialog.setIndeterminate(true);// 设置进度条是否不明确
        }

        if (!StringUtils.isEmpty(title))
            mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }


    protected void toast(int res) {
        if (mToast == null) {
            mToast = Toast.makeText(App.getAppContext(), res, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(res);
        }
        mToast.show();
    }

    protected void toast(String str) {
        if (mToast == null) {
            mToast = Toast.makeText(App.getAppContext(), str, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }



}
