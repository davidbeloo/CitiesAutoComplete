package com.thepinkandroid.citiesautocomplete.general;

import android.app.Application;

import com.thepinkandroid.citiesautocomplete.managers.ContentManager;
import com.thepinkandroid.citiesautocomplete.rest.RestClientManager;


/**
 * Created by DAVID-WORK on 18/06/2015.
 */
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        RestClientManager.init(getApplicationContext());
        ContentManager.init(getApplicationContext());
    }
}
