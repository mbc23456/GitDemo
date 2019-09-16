package com.example.myapplication.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.utils.StatusUtils;

import java.util.zip.Deflater;


public class SettingActivity extends AppCompatActivity {


    public static Deflater instance;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        StatusUtils.setImmersionMode(this);

        setContentView(R.layout.fragment_setting);



        StatusUtils.initToolbar(this, "设置", true, false);

    }

}