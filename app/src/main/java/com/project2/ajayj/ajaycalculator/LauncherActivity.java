package com.project2.ajayj.ajaycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project2.ajayj.ajaycalculator.Utils.SharedUtils;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Thread timerthread = new Thread() {
            public void run() {
                try
                {
                    sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                } finally
                {
                    finish();
                    if (SharedUtils.isFirstTime(LauncherActivity.this))
                    {
                        Intent intent1 = new Intent(LauncherActivity.this, FirstTimeLauncherActivity.class);
                        startActivity(intent1);

                        SharedUtils.storeFirstTime( LauncherActivity.this, false);
                    } else
                    {
                        Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        timerthread.start();
    }
}