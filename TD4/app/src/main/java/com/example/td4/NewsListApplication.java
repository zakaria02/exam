package com.example.td4;

import android.app.Application;

public class NewsListApplication extends Application {
    String login;

    @Override
    public void onCreate(){
        super.onCreate();
        this.login = null;
    }

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }
}
