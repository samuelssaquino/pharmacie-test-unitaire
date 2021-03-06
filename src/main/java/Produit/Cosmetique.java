package Produit;

import Fournisseur.Fournisseur;

import java.time.LocalDate;

// Sous-classe cosmetiques
public class Cosmetique extends Produit {

    // Constructeur des cosmetiques
    public Cosmetique(String code, String description, int stock, LocalDate validite, double prix, Fournisseur fournisseur) {
        super(code, description, stock, validite, prix, fournisseur);
    }

    // Ce méthode configure rabais seulement pour les cosmetiques.
    @Override
    public double rabaisMax() {

        double rabais = 0.00;

        if (getPrix() <= 0.0) { //Pour valider si le prix est negative ou zero
            rabais = 0.00;

        } else if (getPrix() <= 30.00) { //15% de rabais sur les cosmétiques jusqu'à $30,00
            rabais = 0.15 * getPrix();

        } else if (getPrix() <= 70.00) { //20% de rabais sur les cosmétiques jusqu'à $70,00
            rabais = 0.2 * getPrix();
        }
        return rabais;
    }
}
