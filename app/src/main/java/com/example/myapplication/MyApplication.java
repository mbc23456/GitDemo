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

    private static class LitePal {
        public static void initialize(MyApplication myApplication) {
        }
        @NonNull
        @Override
        public ExerciseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup paren,int viewType){
            View view = LayoutInflater.from(paren.getContext())
                    .inflate(R.layout.item_exercise,parent,attachToRoot:false);
            View.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到习题详情页
                }
            });
            return holder;
        }
        @Override
        public void onBindViewHolder(ExerciseAdapter.ViewHolder holder,int position){
            Exercise exercise=exercises.get(position);
            holder.tvOrder.setText(String.valueOf(position+1));
            holder.tvTitle.setText(exercise.getTitle());
        }
    }
}