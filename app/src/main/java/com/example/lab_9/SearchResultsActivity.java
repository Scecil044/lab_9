package com.example.lab_9;

import android.os.Bundle;
import android.widget.ListView;

public class SearchResultsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Initialize ListView
        ListView searchResultsListView = findViewById(R.id.searchResultsListView);

        // Populate search results in ListView
        // You will need to implement the adapter and populate the list with data
    }
}

