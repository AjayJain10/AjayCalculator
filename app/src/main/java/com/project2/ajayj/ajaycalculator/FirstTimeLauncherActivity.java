package com.project2.ajayj.ajaycalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class FirstTimeLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_launcher);


        AlertDialog.Builder doalert = new AlertDialog.Builder(FirstTimeLauncherActivity.this);

        doalert.setTitle("Do`s and Dont`s in this Calculator App. ");
        doalert.setMessage("* Do`s \n" +
                "------------\n" +
                "1. You can try giving the 2nd value(denominmator) value during division as 0 and try it...!!\n" +
                "2. You can give a long  number as you want for the calculation.\n" +
                "3. you will get only 2 decimal points after the decimal point.\n" +
                "4. Press the DEL button to clear, Press and hold it to clear everything.\n" +
                "5. You can insert, delete the numbers where ever you want by placing the cursor in that position.\n \n \n" +


                "* Dont`s \n" +
                "--------------\n" +
                "1. You cannot insert the symbols middle of the numbers by placing the cursor. \n" +
                "2. You cannot give the negative numbers for the calculation..!! \n \n \n" +


                "* As I will try to overcome all the issues(dont`s) in the next update");


        doalert.setCancelable(false);

        doalert.setPositiveButton("Take me To the APP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

                Intent intent = new Intent(FirstTimeLauncherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog al = doalert.create();
        al.show();


    }
}
