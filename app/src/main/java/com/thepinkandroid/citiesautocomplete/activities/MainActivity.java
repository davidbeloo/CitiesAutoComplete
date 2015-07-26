package com.thepinkandroid.citiesautocomplete.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.thepinkandroid.citiesautocomplete.R;
import com.thepinkandroid.citiesautocomplete.general.DelayAutoCompleteTextView;
import com.thepinkandroid.citiesautocomplete.general.MyAutoCompleteAdapter;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    private void setViews()
    {
        final DelayAutoCompleteTextView cityPrediction = (DelayAutoCompleteTextView) findViewById(R.id.cityTitle);
        cityPrediction.setThreshold(1);
        cityPrediction.setAdapter(new MyAutoCompleteAdapter(this));
        cityPrediction.setLoadingIndicator((android.widget.ProgressBar) findViewById(R.id.progressBar));
        cityPrediction.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                String city = (String) adapterView.getItemAtPosition(position);
                cityPrediction.setText(city);
                cityPrediction.setSelection(cityPrediction.getText().length());
            }
        });
    }
}
