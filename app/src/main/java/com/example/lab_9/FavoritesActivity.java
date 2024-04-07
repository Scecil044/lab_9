package com.example.lab_9;

import android.os.Bundle;
import android.widget.ListView;

public class FavoritesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // Initialize ListView
        ListView favoritesListView = findViewById(R.id.favoritesListView);

        // Populate favorites list in ListView
        // You will need to implement the adapter and populate the list with saved favorites
    }
}
