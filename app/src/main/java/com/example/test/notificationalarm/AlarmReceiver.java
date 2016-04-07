package com.example.test.notificationalarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.ic_launcher)
                            .setContentTitle(context.getResources().getString(R.string.notification_alarm_title))
                            .setContentText(context.getResources().getString(R.string.notification_alarm_text));
            Intent resultIntent = new Intent(context, MainActivity.class);
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            stackBuilder.addParentStack(MainActivity.class);
//            stackBuilder.addNextIntent(resultIntent);
//            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, mBuilder.build());
            resetNotificationAlarmInSharedPreferences(context); //to kanoume reset sto 0 (den ekteleitai) gia tin periptosi pou kapoios tha kanei dismiss to notification xoris na anoiksei tin efarmogi. Tote se kathe boot tha ksanaempaine to alarm me parelthousa imerominia pou simainei oti tha xtupousa amesos meta to boot
    }

    private void resetNotificationAlarmInSharedPreferences(Context context)
    {
        SharedPreferences settings = context.getSharedPreferences("NotificationAlarm", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong("alarmDateInMillis", 0 );
//        editor.putLong("alarmDateInMillis", System.currentTimeMillis() +1209600000 );
        // Commit the edits!
//        editor.commit();
        editor.apply();
    }

    //fdsfosdfpsdif spdfapsodf iapodfipa fdpiapof ipao
    //just another stupid lineg
    //1 1 1
    //6666
    //9999
    //1
    //11
    //13
    //14
    //15
    //16
}
