package ProduitTest;

import Fournisseur.Fournisseur;
import Produit.Medicament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MedicamentTest {

    Medicament medicament;

    @DisplayName("Rabais Maximal 5% - $6.0 - $0.3")
    @Test
    public void rabaisMax_5pourcent_6dollars_0dot3dollars() {

        medicament = new Medicament("0101", "DescTU1", 10, LocalDate.now(), 6.0, new Fournisseur("0101", "FornTU1"));

        double actuel = medicament.rabaisMax();
        double attendu = 0.3;

        Assertions.assertEquals(attendu, actuel, 1);
    }

    @DisplayName("Rabais Maximal 10% - $12.0 - $1.2")
    @Test
    public void rabaisMax_10pourcent_12dollars_1dot2dollars() {

        medicament = new Medicament("0202", "DescTU2", 10, LocalDate.now(), 12.0, new Fournisseur("0202", "FornTU2"));

        double actuel = medicament.rabaisMax();
        double attendu = 1.2;

        Assertions.assertEquals(attendu, actuel, 1);
    }

    @DisplayName("Rabais maximal 0% - $0.0 - $0.0")
    @Test
    public void rabaisMax_0pourcent_0dollar_0dollar() {

        medicament = new Medicament("0303", "DescTU3", 10, LocalDate.now(), 0.0, new Fournisseur("0303", "FornTU3"));

        double actuel = medicament.rabaisMax();
        double attendu = 0.0;

        Assertions.assertEquals(attendu, actuel);
    }

    @DisplayName("Rabais maximal 0% - $-1.0 - $0.0")
    @Test
    public void rabaisMax_moins1dollar_0Dollar() {

        medicament = new Medicament("0404", "DescTU4", 10, LocalDate.now(), -1.0, new Fournisseur("0404", "FornTU4"));

        double actuel = medicament.rabaisMax();
        double attendu = 0.0;

        Assertions.assertEquals(attendu, actuel);
    }
}
