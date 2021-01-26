package Stockage;

import Produit.Produit;
import Vente.Vente;

import java.util.ArrayList;

//Cette classe stocke les ventes dans l'arraylist
public class StockageVente {

    ArrayList<Vente> ventes = new ArrayList<Vente>();

    //Cette méthode insère les ventes dans l'arraylist
    public void enregistrerVente(Vente v) {
        this.ventes.add(v);
    }

    //Cette méthode renvoie le nombre de ventes stockés.
    public int quantiteVenteRealisees() {
        return this.ventes.size();
    }

    //Cette méthode renvoie tous les ventes stockés.
    public ArrayList<Vente> getTousLesVentes() {
        return this.ventes;
    }

    //Cette méthode recherche une vente par son code.
    public Vente rechercherVenteParCode(int code) {

        Vente venteRechercher = null;

        for (int i = 0; i < this.ventes.size(); i++) {
            Vente v = this.ventes.get(i);

            if (v.getCode() == code) {
                venteRechercher = v;
                break;
            }
        }

        if (venteRechercher == null) {
            System.out.println("");
            System.out.println("Le code vente n'est pas enregistré dans le système.");
            System.out.println("Entrez un code valide!");
            System.out.println("");
        }

        return venteRechercher;
    }
}
