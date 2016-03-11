/*
 * Copyright (c) 2016. YanJin Tian
 */

package com.lor.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lor.fragments.dialog.AlertDialogFragment;
import com.lor.utils.LogUtil;

/**
 * <pre>
 * Created by YanJin on 2015/12/28.
 * Natural Scope
 * </pre>
 * <p/>
 * <p>主页的 Activity，继承{@link AppCompatActivity}</p>
 * <P>布局最外围是一个带有 ViewPager 的 TabLayout。</P>
 */
public class BaseCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.i("进入:" + this.getClass().getSimpleName());

    }


    /**
     * 显示系统自带的 Toast
     */
    public void showSysToast(@StringRes final int msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseCompatActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 显示系统自带的 Toast
     */
    public void showSysToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseCompatActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public static final String TAG_FRAGMENT_DIALOG = "tag_fragment_dialog";

    /**
     * 显示对话框
     *
     * @param msg --
     */
    public void showAlertDialog(String msg) {
        AlertDialogFragment dialogFragment = AlertDialogFragment.newInstance(msg);
        getSupportFragmentManager().beginTransaction().add(dialogFragment, TAG_FRAGMENT_DIALOG)
                .commit();
    }

    /**
     * 关闭对话框
     */
    public void dismissAlertDialog() {
        AlertDialogFragment dialogFragment = (AlertDialogFragment) getSupportFragmentManager()
                .findFragmentByTag(TAG_FRAGMENT_DIALOG);
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }
}
