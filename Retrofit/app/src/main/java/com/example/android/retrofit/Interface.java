package com.example.android.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface Interface {
    @GET("/joon")
    Call<String>  listRepos(@Body DTO dto);
}
