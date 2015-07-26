package com.thepinkandroid.citiesautocomplete.rest.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by DAVID-WORK on 22/07/2015.
 */

@Parcel
public class MatchedSubstring
{
    @SerializedName("length")
    private int mLength;

    @SerializedName("offset")
    private int mOffset;

    public int getLength()
    {
        return mLength;
    }

    public int getOffset()
    {
        return mOffset;
    }

    @Override
    public String toString()
    {
        return "MatchedSubstring{" +
                "mLength=" + mLength +
                ", mOffset=" + mOffset +
                '}';
    }
}
