package com.example.myapplication.activity;

import android.widget.RadioGroup;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
 private RadioGroup group;
 private Toolbar toolbar;

 //定义标题的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
