package Produit;

import Fournisseur.Fournisseur;

import java.time.LocalDate;

// Produits enregistrés dans le système
public abstract class Produit {

    // Attributs du produit
    private String code;
    private String description;
    private int stock;
    private LocalDate validite;
    private double prix;
    private Fournisseur fournisseur;

    // Constructeur du produit
    public Produit(String code, String description, int stock, LocalDate validite, double prix, Fournisseur fournisseur) {
        this.code = code;
        this.description = description;
        this.stock = stock;
        this.validite = validite;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    //Getters du produit
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public LocalDate getValidite() {
        return validite;
    }

    public double getPrix() {
        return prix;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    // Cette méthode augmente la quantité dans le stock de produits
    public void ajouterStock(int quantite) {
        this.stock += quantite;
    }

    // Cette méthode valide si une quantité sera supprimée du stock de produits
    public boolean retirerStock(int quantite) {
        if (this.stock <= 0) {
            System.out.println("");
            System.out.println("Produit manquant, stock insuffisant!");
            System.out.println("");
            return false;
        } else if (this.stock < quantite) {
            System.out.println("");
            System.out.println("Le stock est inférieur à la quantité souhaitée!");
            System.out.println("");
            return false;
        } else if (quantite <= 0) {
            System.out.println("");
            System.out.println("Quantité invalide!");
            System.out.println("");
            return false;
        } else if (quantite <= this.stock) {
            this.stock -= quantite;
            return true;
        } else {
            System.out.println("");
            System.out.println("Aucun des flux précédents");
            System.out.println("");
        }
        return false;
    }

    // Cette méthode définit le rabais maximale pour chaque produit.
    public abstract double rabaisMax();
}
