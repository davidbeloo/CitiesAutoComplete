# CitiesAutoComplete

Auto complete EditText for cities, using Google Places

https://cloud.githubusercontent.com/assets/4125349/8894778/4076509a-33cb-11e5-845d-e6268c6542b7.gif

This git based on this great tutorial by Alex Melnykov:

http://makovkastar.github.io/blog/2014/04/12/android-autocompletetextview-with-suggestions-from-a-web-service/

FYI, There is SDK from Google for places (https://developers.google.com/places/android/start), but there is no support to get only cities without street names ("The (cities) type collection instructs the Places service to return results that match locality or administrative_area_level_3. The (cities) type collection is not supported in Google Places API for Android or Google Places API for iOS.")


To run the project you only need your Google API Key.

Open https://console.developers.google.com, login and generate your own key.

Put your key in ServerParams.class under:  

public static final String YOUR_PLACES_KEY = "YOUR_KEY";

Enjoy!
