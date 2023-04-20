package com.example.CrossTheRoad;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class Dialog {
    private AlertDialog.Builder alertBuilder;
    private AlertDialog dialog;
    public Dialog(Context context) {
        alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                return;
            }
        });
        alertBuilder.setTitle("ERROR");
        alertBuilder.setCancelable(true);
        dialog = alertBuilder.create();
    }
    public AlertDialog createDialog(String message) {
        dialog.setMessage(message);
        dialog.show();
        return dialog;
    }
    public AlertDialog createDialog(String message, String title) {
        dialog.setTitle(title);
        return createDialog(message);
    }
}
