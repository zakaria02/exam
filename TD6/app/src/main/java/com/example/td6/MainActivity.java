package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText nomRepo;
    Button searchBtn;
    Intent searchedRepoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rechercher une repo");

        nomRepo = (EditText) findViewById(R.id.nomRepo);
        searchBtn = (Button) findViewById(R.id.searchButton);
        searchedRepoActivity = new Intent(this, SearchedRepo.class);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchedRepoActivity.putExtra("repo", nomRepo.getText().toString());
                startActivity(searchedRepoActivity);
            }
        });

        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);


        githubService.listRepos("zakaria02").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                afficherRepos(response.body());
            }
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }

    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this,"nombre de dépots : " + repos.size(), Toast.LENGTH_LONG).show();
    }
}