package Stockage;

import Produit.Produit;

import java.util.ArrayList;

public class StockageProduit {

    ArrayList<Produit> produits = new ArrayList<Produit>();

    public void enregistrerProduit(Produit p) {
        this.produits.add(p);
    }

    public int quantiteProduitStockes() {
        return this.produits.size();
    }

    public ArrayList<Produit> getTousLesProduits() {
        return this.produits;
    }

    public Produit rechercherProduitParCode(String code) {

        Produit produitRechercher = null;

        for (int i = 0; i < this.produits.size(); i++) {
            Produit p = this.produits.get(i);

            if (p.getCode().equals(code)) {
                produitRechercher = p;
                break;
            }
        }

        if (produitRechercher == null) {
            System.out.println("");
            System.out.println("Le code produit n'est pas enregistré dans le système.");
            System.out.println("Entrez un code valide!");
            System.out.println("");
        }

        return produitRechercher;
    }

    public Produit rechercherProduitParNom(String description) {

        Produit produitRechercher = null;

        for (int i = 0; i < this.produits.size(); i++) {
            Produit p = this.produits.get(i);

            if (p.getDescription().equals(description)) {
                produitRechercher = p;
                break;
            }
        }

        if (produitRechercher == null) {
            System.out.println("");
            System.out.println("Le description produit n'est pas enregistré dans le système.");
            System.out.println("Entrez une description valide!");
            System.out.println("");
        }

        return produitRechercher;
    }
}
