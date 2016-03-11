
/*
 * Copyright (c) 2016. YanJin Tian
 */

package com.lor.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

/**
 * <pre>
 * Created by YanJin on 2016/3/11. 17:05 <p/>
 * </pre>
 * <p/>
 * 警告对话框
 * 注意调用此 DialogFragment 的需要实现 {@link EventListener} 接口
 */

public class AlertDialogFragment extends DialogFragment {
    private static final String ARG_MSG = "agrMsg";

    public interface EventListener {
        /**
         * 对话框消失回调
         *
         * @param isCancel 标识是否取消了对话框
         */
        void onDialogDismissed(boolean isCancel);
    }

    public static AlertDialogFragment newInstance(String msg) {
        final AlertDialogFragment frag = new AlertDialogFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_MSG, msg);
        frag.setArguments(args);
        return frag;
    }

    public AlertDialogFragment() {
        super();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final String msg = getArguments().getString(ARG_MSG);

        builder.setMessage(msg);
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(true);
        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        notifyItemDialogDismissed(true);
    }

    private void notifyItemDialogDismissed(boolean isCancel) {
        ((EventListener) getActivity()).onDialogDismissed(isCancel);
    }

}
