package com.example.myapplication.dao;

import com.example.myapplication.MyApplication;
import com.example.myapplication.entity.UserInfo;

import java.util.List;
import java.util.Properties;

public class UserInfoDaoLiteImpl {
    @Override

    public List<UserInfo> select() {

        return MyApplication.LitePal.findAll(UserInfo.class);

    }



    @Override

    public UserInfo select(String username) {

        boolean userInfos = MyApplication.LitePal.where("username=?", username)

                .find(UserInfo.class);

        return userInfos.isEmpty() ? null : userInfos.get(0);

    }



    @Override

    public void insert(UserInfo userInfo) {

        userInfo.save();

    }



    @Override

    public void update(UserInfo userInfo) {

        userInfo.save();

    }



    @Override

    public void delete(UserInfo userInfo) {

        LitePal.delete(UserInfo.class, userInfo.get_id());

    }

}