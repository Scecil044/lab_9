package com.example.lab_9;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ListView listView;
    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up toolbar and navigation drawer
        setupToolbar();
        setupNavigationDrawer();

        listView = findViewById(R.id.articleListView);

        // Execute AsyncTask to fetch data from the API
        new FetchArticlesTask().execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article article = articleList.get(position);

                // Check if we are on a tablet or phone
                FrameLayout frameLayout = findViewById(R.id.frame_layout);
                if (frameLayout != null) {
                    // Tablet: Replace the FrameLayout with the DetailsFragment directly
                    DetailsFragment detailsFragment = new DetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", article.getSectionName());
                    bundle.putString("title", article.getTitle());
                    bundle.putString("url", article.getUrl());
                    detailsFragment.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, detailsFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    // Phone: Start EmptyActivity and pass relevant information in a bundle
                    Intent intent = new Intent(MainActivity.this, EmptyActivity.class);
                    intent.putExtra("name", article.getSectionName());
                    intent.putExtra("title", article.getTitle());
                    intent.putExtra("url", article.getUrl());
                    startActivity(intent);
                }
            }
        });
    }

    // AsyncTask to fetch characters from the Star Wars API
    private class FetchArticlesTask extends AsyncTask<Void, Void, List<Article>> {

        @Override
        protected List<Article> doInBackground(Void... voids) {
            List<Article> articles = new ArrayList<>();
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL("https://content.guardianapis.com/search?api-key=4f732a4a-b27e-4ac7-9350-e9d0b11dd949&amp;q=Tesla");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder buffer = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                String json = buffer.toString();
                Log.d(TAG, "JSON Response: " + json);
                JSONObject jsonObject = new JSONObject(json);
                Log.d(TAG, "JSONObject: " + jsonObject.toString());
                JSONObject responseObj = jsonObject.getJSONObject("response");
                Log.d(TAG, "Response Object: " + responseObj.toString());
                JSONArray jsonArray = responseObj.getJSONArray("results");
                Log.d(TAG, "JSONArray: " + jsonArray.toString());


                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String sectionName = obj.getString("sectionName");
                    String webTitle = obj.getString("webTitle");
                    String webUrl = obj.getString("webUrl");
                    articles.add(new Article(webTitle, webUrl, sectionName));
                    Log.d(TAG, "Object: " + obj.toString());
                }


            } catch (IOException | JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "Articles: " + articles.toString());

            return articles;
        }

        @Override
        protected void onPostExecute(List<Article> articles) {
            super.onPostExecute(articles);
            articleList = articles;
            // Populate ListView with character names
            ArticleAdapter adapter = new ArticleAdapter(MainActivity.this, articleList);
            listView.setAdapter(adapter);
        }
    }
}





