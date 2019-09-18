package com.example.android.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBtn = findViewById(R.id.btn1);

        Button receiveBtn = findViewById(R.id.btn2);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("TEST","Clicked!");

                DTO dtos = new DTO("Joon","27","Java");

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("ip + port")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                TestInterface testInterface = retrofit.create(TestInterface.class);
                Call<String> repos = testInterface.listRepos(dtos);

                repos.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("TEST","dsfsdfds");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("TEST",t.getMessage());
                    }
                });

            }
        });

        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
