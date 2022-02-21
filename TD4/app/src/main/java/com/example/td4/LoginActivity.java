package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    EditText login;

    EditText loginCtx;
    NewsListApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        setTitle("LOGIN");

        loginBtn = (Button) findViewById(R.id.loginBtn);
        login = (EditText) findViewById(R.id.loginUserName);
        loginCtx = (EditText) findViewById(R.id.loginContext);
        app = (NewsListApplication) getApplicationContext();

        Intent intent = new Intent(this, NewsActivity.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("login", login.getText().toString());
                app.setLogin(loginCtx.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}