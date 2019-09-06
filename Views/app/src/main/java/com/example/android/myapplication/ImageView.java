package com.example.android.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.net.URI;


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
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(glideImage);

    }
}
