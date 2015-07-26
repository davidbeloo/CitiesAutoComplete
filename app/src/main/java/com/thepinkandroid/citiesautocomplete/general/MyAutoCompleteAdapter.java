package com.thepinkandroid.citiesautocomplete.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.thepinkandroid.citiesautocomplete.managers.ContentManager;
import com.thepinkandroid.citiesautocomplete.rest.RestClientManager;
import com.thepinkandroid.citiesautocomplete.rest.model.Prediction;

/**
 * Created by DAVID-WORK on 23/07/2015.
 */
public class MyAutoCompleteAdapter extends BaseAdapter implements Filterable
{
    private Context mContext;
    private List<String> resultList = new ArrayList<>();

    public MyAutoCompleteAdapter(Context context)
    {
        mContext = context;
    }

    @Override
    public int getCount()
    {
        return resultList.size();
    }

    @Override
    public String getItem(int index)
    {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
        }
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(getItem(position));
        return convertView;
    }

    @Override
    public Filter getFilter()
    {
        Filter filter = new Filter()
        {
            @Override
            protected Filter.FilterResults performFiltering(CharSequence constraint)
            {
                FilterResults filterResults = new FilterResults();
                if (constraint != null)
                {
                    List<String> predicationList = findCities(constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = predicationList;
                    filterResults.count = predicationList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results)
            {
                if (results != null && results.count > 0)
                {
                    resultList = (List<String>) results.values;
                    notifyDataSetChanged();
                }
                else
                {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }

    /**
     * Returns a search result for the given city prefix
     */
    private List<String> findCities(String input)
    {
        // synchronous execution!
        ArrayList<Prediction> syncPredictionList = RestClientManager.getInstance().getSyncPredictionList(input);
        if(syncPredictionList != null)
        {
            return ContentManager.getInstance().getPredictionDescriptionList();
        }

        return null;
    }
}