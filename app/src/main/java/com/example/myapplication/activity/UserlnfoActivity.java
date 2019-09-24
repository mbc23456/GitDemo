package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;

public class UserlnfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlnfo);
    }

    private void initView(){
        //1.获取控件对象
        tvUsername=findViewById(R.id.tv_username);
        tvNickname=findViewById(R.id.tv_nickname);
        tvSex=findViewById(R.id.tv_sex);
        tvSignature=findViewById()
    }
}

