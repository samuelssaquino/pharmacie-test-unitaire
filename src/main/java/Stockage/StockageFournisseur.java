package Stockage;

import Fournisseur.Fournisseur;

import java.util.ArrayList;

//Cette classe stocke les fournisseurs dans l'arraylist
public class StockageFournisseur {

    ArrayList<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

    //Cette méthode insère les fournisseurs dans l'arraylist
    public void enregistrerFournisseur(Fournisseur f) {
        this.fournisseurs.add(f);
    }

    //Cette méthode renvoie le nombre de fournisseurs stockés.
    public int quantiteFournisseurStockes() {
        return this.fournisseurs.size();
    }

    //Cette méthode renvoie tous les fournisseurs stockés.
    public ArrayList<Fournisseur> getTousLesFournisseurs() {
        return this.fournisseurs;
    }

    //Cette méthode recherche un fournisseur par son code.
    public Fournisseur rechercherFournisseurParCode(String code) {

        Fournisseur fournisseurRechercher = null;

        for (int i = 0; i < this.fournisseurs.size(); i++) {
            Fournisseur f = this.fournisseurs.get(i);

            if (f.getCode().equals(code)) {
                fournisseurRechercher = f;
                break;
            }
        }

        if (fournisseurRechercher == null) {
            System.out.println("");
            System.out.println("Le code fournisseur n'est pas enregistré dans le système.");
            System.out.println("Entrez un code valide!");
            System.out.println("");
        }

        return fournisseurRechercher;
    }

    //Cette méthode recherche un fournisseur par son nom.
    public Fournisseur rechercherFournisseurParNom(String nom) {
        Fournisseur fournisseurRechercher = null;

        for (int i = 0; i < this.fournisseurs.size(); i++) {
            Fournisseur f = this.fournisseurs.get(i);

            if (f.getNom().equals(nom)) {
                fournisseurRechercher = f;
                break;
            }
        }

        if (fournisseurRechercher == null) {
            System.out.println("");
            System.out.println("Le nom fournisseur n'est pas enregistré dans le système.");
            System.out.println("Entrez un nom valide!");
            System.out.println("");
        }

        return fournisseurRechercher;
    }
}
