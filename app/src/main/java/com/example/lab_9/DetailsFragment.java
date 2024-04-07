package com.example.lab_9;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        // Get the bundle passed when the Fragment was created
        Bundle bundle = getArguments();
        if (bundle != null) {
            // Log the contents of the bundle
            for (String key : bundle.keySet()) {
                Object value = bundle.get(key);
                assert value != null;
                Log.d("DetailsFragment", String.format("%s %s (%s)", key,
                        value.toString(), value.getClass().getName()));
            }

            // Retrieve values from the bundle
            String name = bundle.getString("name");
            String title = bundle.getString("title");
            String url = bundle.getString("url");

            // Populate the TextViews with the values from the bundle
            TextView textViewName = view.findViewById(R.id.textViewName);
            TextView textViewTitle = view.findViewById(R.id.textViewTitle);
            TextView textViewUrl = view.findViewById(R.id.textViewUrl);

            // Check for null values
            if (textViewName != null && textViewTitle != null && textViewUrl != null) {
                // Set the text for each TextView
                textViewName.setText("Name: " + (name != null ? name : "N/A"));
                textViewTitle.setText("Title: " + (title != null ? title : "N/A"));
                textViewUrl.setText("Url: " + (url != null ? url : "N/A"));
            } else {
                Log.e("DetailsFragment", "One or more TextViews is null");
            }
        } else {
            Log.e("DetailsFragment", "Bundle is null");
        }

        return view;
    }
}