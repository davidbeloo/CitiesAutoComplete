package com.thepinkandroid.citiesautocomplete.rest.responses;

import com.google.gson.annotations.SerializedName;
import com.thepinkandroid.citiesautocomplete.rest.model.Prediction;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by DAVID-WORK on 19/07/2015.
 */

@Parcel
public class PredictionResponse extends BaseResponse
{
    @SerializedName("predictions")
    private ArrayList<Prediction> mPredictionList;

    public ArrayList<Prediction> getPredictionList()
    {
        return mPredictionList;
    }

    @Override
    public String toString()
    {
        return "PredictionResponse{" +
                "mPredictionList=" + mPredictionList +
                "} " + super.toString();
    }
}
