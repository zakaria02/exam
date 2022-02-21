package com.example.td5;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// A modifier : le nom de la classe
public class ContactAdpater extends RecyclerView.Adapter<ContactAdpater.ViewHolder> {
    // A modifier : le nom et le type des données ( il faut penser à créer la classe des données);
    private final List<Contact> mContacts;

    // A modifier le paramètre du constructeur
    public ContactAdpater(List<Contact> contacts){
        mContacts = contacts;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        // il faut modifier les éléments de la page
        public TextView nomTextView;
        public TextView prenomTextView;
        public ImageView imageUtilisateur;

        public ViewHolder(View itemView){
            super(itemView);

            nomTextView = (TextView) itemView.findViewById(R.id.nom);
            prenomTextView = (TextView) itemView.findViewById(R.id.prenom);
            imageUtilisateur= (ImageView) itemView.findViewById(R.id.imageUtilisateur);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.activity_item_contact, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Contact contact = mContacts.get(position);

        TextView nomTextView = holder.nomTextView;
        nomTextView.setText(contact.getNom());

        TextView prenomTextView = holder.prenomTextView;
        prenomTextView.setText(contact.getPrenom());

        ImageView imageUtilisateur = holder.imageUtilisateur;
        Glide.with(holder.itemView).load(contact.getImageUrl()).into(imageUtilisateur);
    }

    @Override
    public int getItemCount(){
        return mContacts.size();
    }
}
