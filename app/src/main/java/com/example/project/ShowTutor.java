package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ShowTutor extends AppCompatActivity {
    ArrayList<TutorItem> tutors;
    TutorAdaptor adaptor;
    ListView listView;
    String title;
    String name;
    int requestCode;
    TutorItem val;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tutor);

        Button button = (Button) findViewById(R.id.tutorButton);
        Button button2 = (Button) findViewById(R.id.tutorFindButton);
        Button writeButton = (Button) findViewById(R.id.wrtieButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v != null){
                    showTutorWrite();}
            }
        });
        listView = (ListView) findViewById(R.id.listView);

        adaptor =new TutorAdaptor();
        adaptor.addItem(new TutorItem("title: korean speaking for beginners","price: 10 euro per hour"));
        adaptor.addItem(new TutorItem("title: korean grammar for beginners","price: 5 euro per hour"));
       listView.setAdapter(adaptor);
    }

    public void showTutorWrite(){
        Intent intent = new Intent(getApplicationContext(),tutorWriteView.class);
        startActivityForResult(intent,101);
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 101) {
            if(intent !=null){
                name = intent.getStringExtra("Name");
                title = intent.getStringExtra("title");

                val = new TutorItem("title: "+title,"name: "+name);
                if (val != null) {
                    adaptor.addItem(val);
                }
                listView.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();
            }
        }
    }



        class TutorAdaptor extends BaseAdapter{

    ArrayList<TutorItem> tutors=new ArrayList<TutorItem>();
    @Override
    public int getCount() {
        return tutors.size();
    }
    public void addItem(TutorItem item){
        tutors.add(item);
    }
    public void newItem(){
        val = new TutorItem("name:"+name,"title:"+title);
        tutors.add(val);
    }

    @Override
    public Object getItem(int position) {
        return tutors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TutorItemView view;

        if(convertView == null){
            view = new TutorItemView(getApplicationContext());
        }else{
            view = (TutorItemView) convertView;
        }
        TutorItem item = tutors.get(position);
        view.setTitle(item.getTitle());
        view.setName(item.getName());

        return view;
    }

}
}
