package com.example.jim.dontforgettodrinkwaterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jim.dontforgettodrinkwaterapp.broadcast_receivers.NotificationEventReceiver;

/***
 * Created by klogi
 *
 * One-pager app which sends the notification every 2 hours. This is the main Activity,
 * whose only purpose is to provide a button to start the notification service
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendNotificationsButtonClick(View view) {
        NotificationEventReceiver.setupAlarm(getApplicationContext());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    // To prevent crash on resuming activity  : interaction with fragments allowed only after Fragments Resumed or in OnCreate
    // http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        // handleIntent();
    }
}
