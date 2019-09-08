package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;


public class ImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        String url = "https://i.imgur.com/AxETlhd.jpg";

        android.widget.ImageView imageView = findViewById(R.id.generalimage);

        android.widget.ImageView glideImage = findViewById(R.id.glideimage);

        imageView.setImageResource(R.drawable.highimage);

        Glide.with(this)
                .load("https://t1.daumcdn.net/cfile/tistory/25257E4753D84EE013")
                .placeholder(R.drawable.ic_launcher_background)
                .into(glideImage);

    }
}
