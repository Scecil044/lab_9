package com.example.lab_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        // Get data from Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Create a new instance of the DetailsFragment
            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(bundle);

            // Get the FragmentManager
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Begin a FragmentTransaction
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}