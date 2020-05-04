package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class postView extends AppCompatActivity {
    private ListView listView;
    ArrayAdapter<String> adapter;
    List<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);
        listView = (ListView) findViewById(R.id.listView);

        data = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        data.add("free post");
        data.add("ask anything about korean");
        data.add("what do in Busan");
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);


    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View clickedView, int position, long id) {
            String toastMessage = "position is" + position;
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            if (position == 1) {
                if(clickedView !=null){
                showAskKoreanView();}
            }
        }
    };

    public void showAskKoreanView() {
        Intent intent = new Intent(getApplicationContext(), askKoreanView.class);
        startActivity(intent);
    }
}


