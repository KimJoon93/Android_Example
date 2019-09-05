package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView viewLV;
    ListView viewGroupLV;
    ArrayList<String> viewList;
    ArrayList<String> viewGroupList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewList = new ArrayList<>();
        viewList.add("TextView");
        viewList.add("ImageView");
        viewList.add("Progressbar");

        viewGroupList = new ArrayList<>();
        viewGroupList.add("LinearLayout");
        viewGroupList.add("RelativeLayout");
        viewGroupList.add("FrameLayout");
        viewGroupList.add("AbsoluteLayout");
        viewGroupList.add("AdapterView");

        viewLV = (ListView) findViewById(R.id.mainLV);
        viewGroupLV = (ListView) findViewById(R.id.viewGroupLV);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,viewList);
        ArrayAdapter viewGroupAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,viewGroupList);

        viewLV.setAdapter(arrayAdapter);
        viewGroupLV.setAdapter(viewGroupAdapter);

        viewLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0){
                    Intent intent = new Intent(getApplicationContext(), TextView.class);
                    startActivity(intent);
                }else if(i==1){
                    Log.d("KJ","1111");
                }else if(i==2){
                    Log.d("KJ","2222");
                }

            }
        });
    }
}
