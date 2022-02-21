
package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchedRepo extends AppCompatActivity {
    List<Repo> repos = new ArrayList<Repo>();
    String repoName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_repo);
        setTitle("Mes repos");

        RecyclerView rvRepo = (RecyclerView) findViewById(R.id.rvRepo);

        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        Intent myIntent = getIntent();
        if(myIntent.hasExtra("repo")){
            repoName = myIntent.getStringExtra("repo");
        }

        githubService.listRepos(repoName).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repos = response.body();
                RepoAdapter adapter = new RepoAdapter(repos);

                rvRepo.setAdapter(adapter);
                rvRepo.setLayoutManager(new LinearLayoutManager(SearchedRepo.this));
            }
            public void onFailure(Call<List<Repo>> call, Throwable t) {
            }
        });
    }
}