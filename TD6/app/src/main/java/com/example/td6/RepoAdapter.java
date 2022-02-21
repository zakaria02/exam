package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {
    private final List<Repo> mRepo;
    public RepoAdapter(List<Repo> repos){
        mRepo = repos;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.repo_item, parent, false);
        return new ViewHolder(contactView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView idTextView;
        public TextView nameTextView;
        public TextView fullnameTextView;
        public TextView urlTextView;

        public ViewHolder(View itemView){
            super(itemView);

            idTextView = (TextView) itemView.findViewById(R.id.idText);
            nameTextView = (TextView) itemView.findViewById(R.id.nomText);
            fullnameTextView = (TextView) itemView.findViewById(R.id.fullNameText);
            urlTextView = (TextView) itemView.findViewById(R.id.urlText);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = mRepo.get(position);

        TextView nameTextView = holder.nameTextView;
        nameTextView.setText(repo.getName());

        TextView fullnameTextView = holder.fullnameTextView;
        fullnameTextView.setText(repo.getFull_name());

        TextView urlTextView = holder.urlTextView;
        urlTextView.setText(repo.getHtml_url());
    }

    @Override
    public int getItemCount() {
        return mRepo.size();
    }
}
