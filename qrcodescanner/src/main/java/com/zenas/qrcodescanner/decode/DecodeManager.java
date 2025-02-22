package com.zenas.qrcodescanner.decode;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.zenas.qrcodescanner.R;


public class DecodeManager {

    public void showPermissionDeniedDialog(Context context) {
        Log.e("DecodeManager", "Permissions not granted");
        
        new AlertDialog.Builder(context).setTitle(R.string.qr_code_notification)
                .setMessage(R.string.qr_code_camera_not_open)
                .setPositiveButton(R.string.qr_code_positive_button_know, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void showResultDialog(Activity activity, String resultString, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(activity).setTitle(R.string.qr_code_notification).setMessage(resultString)
                .setPositiveButton(R.string.qr_code_positive_button_confirm, listener).show();
    }

    public void showCouldNotReadQrCodeFromScanner(Context context, final OnRefreshCameraListener listener) {
        new AlertDialog.Builder(context).setTitle(R.string.qr_code_notification)
                .setMessage(R.string.qr_code_could_not_read_qr_code_from_scanner)
                .setPositiveButton(R.string.qc_code_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (listener != null) {
                            listener.refresh();
                        }
                    }
                }).show();
    }

    public void showCouldNotReadQrCodeFromPicture(Context context) {
        new AlertDialog.Builder(context).setTitle(R.string.qr_code_notification)
                .setMessage(R.string.qr_code_could_not_read_qr_code_from_picture)
                .setPositiveButton(R.string.qc_code_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public interface OnRefreshCameraListener {
        void refresh();
    }

}
