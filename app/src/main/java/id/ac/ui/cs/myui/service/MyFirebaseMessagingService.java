package id.ac.ui.cs.myui.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.LoginActivity;
import id.ac.ui.cs.myui.activity.NewsHomeActivity;

/**
 * Created by muhammad.yusuf43 on 19/07/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent = new Intent(MyFirebaseMessagingService.this, NewsHomeActivity.class);
        intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));

        PendingIntent pendingIntent = PendingIntent.getActivity(MyFirebaseMessagingService.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notification = (NotificationCompat.Builder) new NotificationCompat.Builder(MyFirebaseMessagingService.this)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("MyUI")
                .setContentText(remoteMessage.getNotification().getBody())
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification.build());
    }
}
