package com.example.td5;

public class Contact {
    String nom;
    String prenom;
    String imageUrl;

    Contact(String nom, String prenom, String imageUrl){
        this.nom = nom;
        this.prenom = prenom;
        this.imageUrl = imageUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
