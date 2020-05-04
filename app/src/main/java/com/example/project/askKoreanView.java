package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class askKoreanView extends AppCompatActivity {
    private ListView listView;
    ArrayAdapter<String> adapter;
    List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_korean_view);

        listView = (ListView) findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,data);

        data.add("what is the difference between 숟가락 and 젓가락");
        data.add("what is the past tense of 먹다");
        data.add("how can you say nice weather in korean");
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter); }


}
