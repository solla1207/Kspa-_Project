package com.example.project;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TutorItemView extends LinearLayout {
    TextView textView;
    TextView textView2;

    public TutorItemView(Context context) {
        super(context);
        init(context);
    }

    public TutorItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    //초기화를 위한 메소드, 레이아웃 뷰를 인플레이션 하는 역할
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //시스템 서비스: 단말에서 기본적으로 실행되는 서비스 (그중 인플레이터 서비스 갔다씀)
        inflater.inflate(R.layout.tutor_item_view,this,true);//인플레이션 해서 this에 붙임
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
    }

    public void setName(String name){
        textView.setText(name);

    }
    public void setTitle(String title){
        textView2.setText(title);
    }
}
