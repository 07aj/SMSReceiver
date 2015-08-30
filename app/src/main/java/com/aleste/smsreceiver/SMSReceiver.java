package com.aleste.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by aleste on 30/08/15.
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        String messages = "";
        Log.i("SMSReceiver", "Recibí un SMS");
        if (extras != null){
            Object[] smsExtra = (Object[]) extras.get("pdus");

            for ( int i = 0; i < smsExtra.length; ++i )
            {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);

                String body = sms.getMessageBody().toString();

                String address = sms.getOriginatingAddress();

                messages += "SMS from " + address + " :\n";
                messages += body + "\n";

                //Log.i("SMSReceived", "SMS_BODY:"+sms.getMessageBody().toString());
                //Log.i("SMSReceived", "SMS_FROM:"+sms.getOriginatingAddress().toString());
            }
            Toast.makeText( context, messages, Toast.LENGTH_SHORT ).show();
        }









    }
}
