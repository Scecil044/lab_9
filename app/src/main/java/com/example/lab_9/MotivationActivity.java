package com.example.lab_9;

import android.os.Bundle;
import android.widget.TextView;

public class MotivationActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);

        drawerLayout = findViewById(R.id.drawer_layout);
        setupToolbar();
        setupNavigationDrawer();

        // Set the motivation quote
        TextView motivationTextView = findViewById(R.id.textView);
        motivationTextView.setText(R.string.today_motivation);
    }
}
