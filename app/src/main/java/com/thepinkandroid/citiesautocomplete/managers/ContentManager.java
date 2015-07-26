package com.thepinkandroid.citiesautocomplete.managers;

import android.content.Context;

import com.thepinkandroid.citiesautocomplete.rest.model.Prediction;

import java.util.ArrayList;

/**
 * Created by DAVID BELOOSESKY on 28/04/2014
 */
public class ContentManager
{
    private final Context mContext;
    private static ContentManager msInstance;

    public static final String LOG_TAG = ContentManager.class.getSimpleName();
    private ArrayList<Prediction> mPredictionList = new ArrayList<>();

    private ContentManager(Context context)
    {
        mContext = context;
    }

    public static ContentManager init(Context context)
    {
        if (msInstance == null)
        {
            msInstance = new ContentManager(context);
        }

        return msInstance;
    }

    public static ContentManager getInstance()
    {
        return msInstance;
    }

    public ArrayList<Prediction> getPredictionList()
    {
        return mPredictionList;
    }

    public void setPredictionList(ArrayList<Prediction> predictionList)
    {
        mPredictionList = predictionList;
    }

    public ArrayList<String> getPredictionDescriptionList()
    {
        ArrayList<String> descriptionList = new ArrayList<>();
        for (Prediction prediction : mPredictionList)
        {
            descriptionList.add(prediction.getDescription());
        }

        return descriptionList;
    }

}
