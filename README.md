# CitiesAutoComplete

Auto complete EditText for cities, using Google Places

FYI, There is SDK from Google for places (https://developers.google.com/places/android/start), but there is support to get only cities ("The (cities) type collection instructs the Places service to return results that match locality or administrative_area_level_3. The (cities) type collection is not supported in Google Places API for Android or Google Places API for iOS.")

So I made one ! :)

To run the project you only need your Google API Key.

Open https://console.developers.google.com, login and generate your own key.

Put your key in ServerParams.class under:  

public static final String YOUR_PLACES_KEY = "YOUR_KEY";

Enjoy!
