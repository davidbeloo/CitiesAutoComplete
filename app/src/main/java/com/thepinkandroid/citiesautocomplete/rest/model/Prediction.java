package com.thepinkandroid.citiesautocomplete.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by DAVID-WORK on 22/07/2015.
 */

@Parcel
public class Prediction
{
    @SerializedName("description")
    private String mDescription;

    @SerializedName("id")
    private String mID;

    @SerializedName("matched_substrings")
    private ArrayList<MatchedSubstring> mMatchedSubstrings;

    @SerializedName("place_id")
    private String mPlaceID;

    @SerializedName("reference")
    private String mReference;

    @SerializedName("terms")
    private ArrayList<Terms> mTerms;

    @SerializedName("types")
    private ArrayList<String> mTypes;

    public String getDescription()
    {
        return mDescription;
    }

    public String getID()
    {
        return mID;
    }

    public ArrayList<MatchedSubstring> getMatchedSubstrings()
    {
        return mMatchedSubstrings;
    }

    public String getPlaceID()
    {
        return mPlaceID;
    }

    public String getReference()
    {
        return mReference;
    }

    public ArrayList<Terms> getTerms()
    {
        return mTerms;
    }

    public ArrayList<String> getTypes()
    {
        return mTypes;
    }

    @Override
    public String toString()
    {
        return "Prediction{" +
                "mDescription='" + mDescription + '\'' +
                ", mID='" + mID + '\'' +
                ", mMatchedSubstrings=" + mMatchedSubstrings +
                ", mPlaceID='" + mPlaceID + '\'' +
                ", mReference='" + mReference + '\'' +
                ", mTerms=" + mTerms +
                ", mTypes=" + mTypes +
                '}';
    }
}
