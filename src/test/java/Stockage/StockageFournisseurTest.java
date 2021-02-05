package Stockage;

import Client.Client;
import Fournisseur.Fournisseur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StockageFournisseurTest {

    @DisplayName("Il devrait enregistrer un fournisseur et verifier le code=0101, nom=Fournisseur1")
    @Test
    public void enregistrerFournisseur_fournisseur1_getCodeGetNom() {

        Fournisseur fournisseur1 = new Fournisseur("0101", "Fournisseur1");
        StockageFournisseur stockageFournisseur = new StockageFournisseur();

        stockageFournisseur.enregistrerFournisseur(fournisseur1);

        Assertions.assertAll(
                () -> Assertions.assertEquals("0101", stockageFournisseur.fournisseurs.get(0).getCode()),
                () -> Assertions.assertEquals("Fournisseur1", stockageFournisseur.fournisseurs.get(0).getNom())
        );
    }

    @DisplayName("Il devrait enregistrer 5 fournisseur et verifier le taille=5")
    @Test
    public void quantiteFournisseurStockes_5Fournisseurs_taille5() {

        Fournisseur fournisseur1 = new Fournisseur("0101", "Fournisseur1");
        Fournisseur fournisseur2 = new Fournisseur("0202", "Fournisseur2");
        Fournisseur fournisseur3 = new Fournisseur("0303", "Fournisseur3");
        Fournisseur fournisseur4 = new Fournisseur("0404", "Fournisseur4");
        Fournisseur fournisseur5 = new Fournisseur("0505", "Fournisseur5");

        StockageFournisseur stockageFournisseur = new StockageFournisseur();

        stockageFournisseur.enregistrerFournisseur(fournisseur1);
        stockageFournisseur.enregistrerFournisseur(fournisseur2);
        stockageFournisseur.enregistrerFournisseur(fournisseur3);
        stockageFournisseur.enregistrerFournisseur(fournisseur4);
        stockageFournisseur.enregistrerFournisseur(fournisseur5);

        int resultat = stockageFournisseur.quantiteFournisseurStockes();

        Assertions.assertEquals(5, resultat);
    }
}
