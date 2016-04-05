package com.example.test.notificationalarm;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancelNotification();  //Gia na fugei to Notification me to anoigma tis efarmogis se periptosi pou einai anoixto
        updateNotificationAlarm();
        updateNotificationAlarmInSharedPreferences();
    }

    private void cancelNotification()
    {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(1);
    }

    //
    private void updateNotificationAlarm() {
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +30000, pendingIntent);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +1209600000, pendingIntent); //14 days
    }

    private void updateNotificationAlarmInSharedPreferences()
    {
        SharedPreferences settings = getSharedPreferences("NotificationAlarm", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong("alarmDateInMillis", System.currentTimeMillis() +30000 );
//        editor.putLong("alarmDateInMillis", System.currentTimeMillis() +1209600000 );
        // Commit the edits!
//        editor.commit();
        editor.apply();
    }
}

//4444
