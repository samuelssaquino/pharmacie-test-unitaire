package Produit;

import Fournisseur.Fournisseur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CosmetiqueTest {

    private Cosmetique cosmetique;

    @DisplayName("Rabais maximal 15% - $30.0 - $4.5")
    @Test
    public void rabaisMax_15pourcent_30dollars_4dot5dollars() {

        cosmetique = new Cosmetique("0101", "DescTU1", 10, LocalDate.now(), 30.0, new Fournisseur("0101", "FornTU1"));

        double actuel = cosmetique.rabaisMax();
        double attendu = 4.5;

        Assertions.assertEquals(attendu, actuel);

    }

    @DisplayName("Rabais maximal 20% - $70.0 - $14.0")
    @Test
    public void rabaisMax_20pourcent_70dollars_14dollars() {

        cosmetique = new Cosmetique("0202", "DescTU2", 10, LocalDate.now(), 70.0, new Fournisseur("0202", "FornTU2"));

        double actuel = cosmetique.rabaisMax();
        double attendu = 14;

        Assertions.assertEquals(attendu, actuel);

    }

    @DisplayName("Rabais maximal 0% - $0.0 - $0.0")
    @Test
    public void rabaisMax_0pourcent_0dollar_0dollar() {

        cosmetique = new Cosmetique("0303", "DescTU3", 10, LocalDate.now(), 0.0, new Fournisseur("0303", "FornTU3"));

        double actuel = cosmetique.rabaisMax();
        double attendu = 0.0;

        Assertions.assertEquals(attendu, actuel);
    }

    @DisplayName("Rabais maximal 0% - $-1.0 - $0.0")
    @Test
    public void rabaisMax_moins1dollar_0Dollar() {

        cosmetique = new Cosmetique("0404", "DescTU4", 10, LocalDate.now(), -1.0, new Fournisseur("0404", "FornTU4"));

        double actuel = cosmetique.rabaisMax();
        double attendu = 0.0;

        Assertions.assertEquals(attendu, actuel);
    }
}
