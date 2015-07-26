package com.thepinkandroid.citiesautocomplete.rest.responses;

import com.google.gson.annotations.SerializedName;

import com.thepinkandroid.citiesautocomplete.rest.ServerParams;


/**
 * Created by DAVID BELOOSESKY on 03/12/2014.
 */
public class BaseResponse
{
    @SerializedName("status")
    private String mStatus;

    @SerializedName("error_message")
    private String mErrorMessage;

    public String getStatus()
    {
        return mStatus;
    }

    public boolean isSucceeded()
    {
        if (mStatus.equals(ServerParams.STATUS_SUCCEEDED))
        {
            return true;
        }

        return false;
    }

    public boolean isFailure()
    {
        return !isSucceeded();
    }

    @Override
    public String toString()
    {
        return "BaseResponse{" +
                "mStatus='" + mStatus + '\'' +
                ", mErrorMessage='" + mErrorMessage + '\'' +
                '}';
    }
}
