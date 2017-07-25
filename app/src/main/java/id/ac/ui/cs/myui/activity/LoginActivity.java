package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.task.NewsSceleTask;

/**
 * This class defining Login page Logic
 * This class also need some fixing because Login logic isn't actually complete
 */
public class LoginActivity extends AppCompatActivity {

    private static final int uniqueID = 007;
    NotificationCompat.Builder notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notification = (NotificationCompat.Builder) new NotificationCompat.Builder(LoginActivity.this)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notification")
                .setContentText("Notification sucsess");

        //set title bar
        setTitle("Halaman Login");

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(LoginActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(uniqueID, notification.build());

                Intent i = new  Intent(LoginActivity.this, NewsHomeActivity.class);
                startActivity(i);
            }
        });


    }
}
