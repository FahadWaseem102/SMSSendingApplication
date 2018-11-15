package com.example.fahad.smssendingapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class SendSMS extends BroadcastReceiver {

    String phoneNumber ;
    private static final String SENT_SMS_FLAG="1";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras() ;
        if (bundle != null){
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);
            Toast.makeText(context, ""+state, Toast.LENGTH_SHORT).show();
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                phoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER) ;
                SmsManager sms = SmsManager.getDefault() ;
                sms.sendTextMessage(phoneNumber,null,"Thanks for calling me ! This App is " +
                        "developed by Fahad Waseem",null,null);
            }
            Toast.makeText(context, phoneNumber+" is calling", Toast.LENGTH_SHORT).show();
        }
    }
}
