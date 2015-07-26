package com.thepinkandroid.citiesautocomplete.rest;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thepinkandroid.citiesautocomplete.managers.ContentManager;
import com.thepinkandroid.citiesautocomplete.rest.model.Prediction;
import com.thepinkandroid.citiesautocomplete.rest.responses.PredictionResponse;
import com.thepinkandroid.citiesautocomplete.rest.service.ApiService;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by DAVID BELOOSESKY on 18/06/2015.
 */
public class RestClientManager
{
    private final Context mContext;
    private ApiService mApiService;
    private static RestClientManager msInstance;
    public static final String LOG_TAG = RestClientManager.class.getSimpleName();

    private RestClientManager(Context context)
    {
        mContext = context;
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ServerParams.BASE_SERVER_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        mApiService = restAdapter.create(ApiService.class);
    }

    public static RestClientManager init(Context context)
    {
        if (msInstance == null)
        {
            msInstance = new RestClientManager(context);
        }

        return msInstance;
    }

    public static RestClientManager getInstance()
    {
        return msInstance;
    }

    public ArrayList<Prediction> getSyncPredictionList(String input)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put(ServerParams.INPUT, input);
        params.put(ServerParams.KEY, ServerParams.YOUR_PLACES_KEY);
        params.put(ServerParams.TYPES, ServerParams.TYPE_CITY);
        PredictionResponse predictions = mApiService.getPredictions(params);
        ContentManager.getInstance().setPredictionList(predictions.getPredictionList());
        return predictions.getPredictionList();
    }
}
