package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tutorWriteView extends AppCompatActivity {
    EditText nameText;
    EditText titleText;
    Button saveButton;
    Button cancelButton;

    // 과외생이 조건 올리는 곳.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_write_view);
        nameText = (EditText) findViewById(R.id.nameText);
        titleText = (EditText) findViewById(R.id.titleText);
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToShowTutor();
            }
        });
    }
 public void returnToShowTutor(){
     String name = nameText.getText().toString();
     String title = titleText.getText().toString();
     Intent intent = new Intent();
     intent.putExtra("Name",name);
     intent.putExtra("title",title);
     setResult(RESULT_OK, intent);
     finish();

 }
}
