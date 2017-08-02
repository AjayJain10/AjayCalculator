package com.project2.ajayj.ajaycalculator.Utils;

import android.content.Context;

/**
 * Created by ajayj on 21-07-2017.
 */

public class SharedUtils {

    public static void storeFirstTime(Context context, boolean isFirstTime){
        context.getSharedPreferences("IsLogin",Context.MODE_PRIVATE).edit().putBoolean("a",isFirstTime).apply();
    }

    public static  boolean isFirstTime(Context context)
    {
        return  context.getSharedPreferences("IsLogin",Context.MODE_PRIVATE).getBoolean("a",true);
    }

}
