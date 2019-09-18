package com.example.android.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface TestInterface {
    @POST("/joon")
    Call<String> listRepos(@Body DTO dto);
}
