package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ListView viewLV;
    ListView viewGroupLV;
    ArrayList<String> viewList;
    ArrayList<String> viewGroupList;

    Intent intent;


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

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        viewLV = (ListView) findViewById(R.id.mainLV);
        viewGroupLV = (ListView) findViewById(R.id.viewGroupLV);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,viewList);
        ArrayAdapter viewGroupAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,viewGroupList);

        viewLV.setAdapter(arrayAdapter);
        setListViewHeightBasedOnChildren(viewLV,viewList);

        viewGroupLV.setAdapter(viewGroupAdapter);
        setListViewHeightBasedOnChildren(viewGroupLV,viewGroupList);

        viewLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0){
                    intent = new Intent(getApplicationContext(), TextView.class);
                }else if(i==1){
                    intent = new Intent(getApplicationContext(), ImageView.class);
                }else if(i==2){
                    Log.d("KJ","2222");
                }
                startActivity(intent);
            }
        });
    }

    public static void setListViewHeightBasedOnChildren(ListView listView, ArrayList<String> arrayList){
        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null){
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        View listItem = listAdapter.getView(0, null, listView);
        listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
        totalHeight += listItem.getMeasuredHeight();

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
