package Vente;

import Client.Client;
import Produit.Produit;

import java.util.ArrayList;

// Enregistre les ventes des produits.
public class Vente {

    // Attributs des ventes
    private int code;
    private int quantite;
    private double prixTotal;
    Client client; // Une vente a seleument un client
    ArrayList<Produit> produits; // Une vente comporte un ou plusieurs produits

    // Getters et Setters des produits
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite += quantite;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    // Cette méthode calcule le prix total de la vente.
    public void setPrixTotal(double prix, int quantite, double rabais) {
        this.prixTotal += (prix - rabais) * quantite;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
