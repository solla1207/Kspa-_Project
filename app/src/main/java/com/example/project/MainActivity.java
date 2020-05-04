package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.tutorButton);
        Button button2 = (Button) findViewById(R.id.postButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v != null){
                showTutor();}
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v!=null){
                    showPost();
                }
            }
        });
    }
    public void showTutor(){
        Intent intent = new Intent(getApplicationContext(), ShowTutor.class);
        startActivity(intent);
    }
    public void showPost(){
        Intent intent = new Intent(getApplicationContext(), postView.class);
        startActivity(intent);
    }
}
