package com.example.myapplication;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.example.myapplication.adapter.ExerciseAdapter;
import com.example.myapplication.dao.UserInfoDao;
import com.example.myapplication.entity.Exercise;


public class MyApplication extends Application {

    public static UserInfoDao LitePal;

    @Override

    public void onCreate() {

        super.onCreate();

        LitePal.initialize(this);

    }
}

