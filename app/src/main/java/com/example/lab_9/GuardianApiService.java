package com.example.lab_9;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GuardianApiService {

    @GET("search")
    Call<ApiResponse> searchArticles(
            @Query("q") String query,
            @Query("api-key") String apiKey
    );
}
