package com.example.android.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {

    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {

        return ourInstance;
    }

    private Singleton() {
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("ip+port")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TestInterface testInterface = retrofit.create(TestInterface.class);

    public TestInterface getTestInterface() {
        return testInterface;
    }
}
