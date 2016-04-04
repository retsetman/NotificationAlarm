package com.example.test.notificationalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            SharedPreferences settings = context.getSharedPreferences("NotificationAlarm", 0);
            long alarmDateInMillis = settings.getLong("alarmDateInMillis", 0);
//            if (alarmDateInMillis > System.currentTimeMillis()) //check to see if the retrieved alarm date/time is still valid (i.e in the future)
            if (alarmDateInMillis != 0) //check to see if the retrieved alarm is set
            {
                Intent alarmIntent = new Intent(context, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmDateInMillis, pendingIntent);
            }
        }
    }
}
