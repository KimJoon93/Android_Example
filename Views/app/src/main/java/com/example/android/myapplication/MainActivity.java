package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mainList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> viewList = new ArrayList<>();
        viewList.add("TextView");
        viewList.add("ImageView");
        viewList.add("Progressbar");

        mainList = (ListView) findViewById(R.id.mainLV);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,viewList);
        mainList.setAdapter(arrayAdapter);
    }
}
