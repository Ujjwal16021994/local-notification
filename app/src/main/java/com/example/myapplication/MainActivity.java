package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static String CHANNEL_ID = "MY CHANNEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.notify);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addNotification();
            }
        });
    }

    public void addNotification(){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("massage","this is the message bought");

        PendingIntent pintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);


        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder itsABuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        itsABuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.img)
                .setContentText("This is new notification text")
                .setContentTitle("New Notification")
                .setAutoCancel(true)
                .setChannelId("CHANNEL_ID")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
            manager.createNotificationChannel(new NotificationChannel("CHANNEL_ID","name",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            itsABuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.img)
                    .setContentText("This is new notification text")
                    .setContentTitle("New Notification")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH);
        }
        itsABuilder.setContentIntent(pintent);
        manager.notify(0,itsABuilder.build());

    }
}