package Produit;

import Fournisseur.Fournisseur;

import java.time.LocalDate;

// Sous-classe médicaments
public class Medicament extends Produit {

    // Constructeur des médicaments
    public Medicament(String code, String description, int stock, LocalDate validite, double prix, Fournisseur fournisseur) {
        super(code, description, stock, validite, prix, fournisseur);
    }

    // Ce méthode configure rabais seulement pour les medicaments.
    @Override
    public double rabaisMax() {

        double rabais = 0.00;

        if (getPrix() <= 0.0) { //Pour valider si le prix est negative ou zero
            rabais = 0.00;

        } else if (getPrix() <= 6.00) { //5% de rabais sur les medicament jusqu'à $6,00
            rabais = 0.05 * getPrix();

        } else if (getPrix() <= 12.00) { //10% de rabais sur les medicament jusqu'à $12,00
            rabais = 0.1 * getPrix();
        }
        return rabais;
    }
}
