package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
    Button Login;
    Button Detail;
    Button About;
    TextView usernameText;
    TextView userLoginCtx;
    NewsListApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle("News");
        app = (NewsListApplication) getApplicationContext();

        Login = (Button) findViewById(R.id.Loginbtn);
        Intent intent = new Intent(this, LoginActivity.class);

        Detail = (Button) findViewById(R.id.Detailsbtn);
        Intent intent2 = new Intent(this, DetailsActivity.class);

        About = (Button) findViewById(R.id.aboutBtn);
        Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://news.google.com"));

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });

        Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
                finish();
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

        usernameText = (TextView) findViewById(R.id.user);
        userLoginCtx = (TextView) findViewById(R.id.loginTextCtx);


        Intent intent4 = getIntent();
        String login;

        if(intent4.hasExtra("login")){
            usernameText.setText("Avec intent " + intent4.getStringExtra("login"));
        }
        userLoginCtx.setText("Avec Context " + app.getLogin());

    }
}