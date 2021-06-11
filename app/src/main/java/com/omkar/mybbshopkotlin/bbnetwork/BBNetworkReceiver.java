package com.omkar.mybbshopkotlin.bbnetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;


public class BBNetworkReceiver extends BroadcastReceiver {
    public String status = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        status = BBNetworkstate.getConnectivityStatusString(context);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

// set the title of the Alert Dialog
        alertDialogBuilder.setTitle("MyBBshop");

// set dialog message
        alertDialogBuilder
                .setMessage(BBNetworkstate.getConnectivityStatusString(context))
                .setCancelable(false);

         final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.cancel();
        if(status.equals("Wifi enabled")){
            if(alertDialog.isShowing()){
                alertDialog.cancel();
                alertDialog.dismiss();
            }
            Toast.makeText(context,status,Toast.LENGTH_LONG).show();
        }
        else if(status.equals("Mobile data enabled")){
            Toast.makeText(context,status,Toast.LENGTH_LONG).show();
        }
        else if(status.equals("Not connected to Internet")){

            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (alertDialog.isShowing()){
                        alertDialog.dismiss();
                    }
                }
            }, 3000);

        }
    }
}

