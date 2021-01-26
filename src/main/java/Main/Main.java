package Main;

import Stockage.StockageClient;
import Stockage.StockageFournisseur;
import Stockage.StockageProduit;
import Stockage.StockageVente;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner clavier = new Scanner(System.in);

        LocalDateTime ldtMaintenant = LocalDateTime.now();
        DateTimeFormatter formateur = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        String form = formateur.format(ldtMaintenant);

        //Menu
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                                                                                          ");
        System.out.println("                                                 ===== PHARMACIE =====                                    " + form);
        System.out.println("                                                ÉTUDIANT: SAMUEL AQUINO                                                   ");
        System.out.println("                                           TESTS AGILES 2020 - CESAR SCHOOL                                               ");
        System.out.println("                       Ce projet a été réalisé pour le cours de spécialisation en tests agiles.                           ");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }
}
