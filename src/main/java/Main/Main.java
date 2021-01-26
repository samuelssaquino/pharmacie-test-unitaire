package Main;

import Client.Client;
import Fournisseur.Fournisseur;
import Produit.Cosmetique;
import Produit.Medicament;
import Stockage.StockageClient;
import Stockage.StockageFournisseur;
import Stockage.StockageProduit;
import Stockage.StockageVente;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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

        //Initialisation des référentiels
        StockageProduit stockageProduits = new StockageProduit();
        StockageClient stockageClients = new StockageClient();
        StockageFournisseur stockageFournisseurs = new StockageFournisseur();
        StockageVente stockageVentes = new StockageVente();

        //Initialisation date d'expiration des produits
        Period unAn = Period.ofYears(1);
        Period deuxAns = Period.ofYears(2);
        Period troisAns = Period.ofYears(3);
        Period quatreAns = Period.ofYears(4);

        //Date d'aujourd'hui
        LocalDate ld = LocalDate.now();

        //Chaque produit a une date d'expiration
        LocalDate validiteTylenol = ld.plus(unAn);
        LocalDate validiteVitamineC = ld.plus(deuxAns);
        LocalDate validiteHeadShoulders = ld.plus(troisAns);
        LocalDate validiteColgate = ld.plus(quatreAns);

        //Enregistrer les utilisateurs avec le constructeur
        Client client1 = new Client("489.236.030-99", "Jose");
        Client client2 = new Client("564.590.960-74", "Maria");
        Client client3 = new Client("890.573.330-15", "Pedro");
        Client client4 = new Client("936.871.980-22", "Ana");
        Client client5 = new Client("686.467.440-19", "Carlos");
        Client client6 = new Client("763.663.030-37", "Bia");

        //Enregistrer les fournisseurs avec le constructeur
        Fournisseur fournisseur1 = new Fournisseur("001", "Aché");
        Fournisseur fournisseur2 = new Fournisseur("002", "Medic");
        Fournisseur fournisseur3 = new Fournisseur("003", "Dislab");
        Fournisseur fournisseur4 = new Fournisseur("004", "Merck");

        //Enregistrer les produits avec le constructeur
        Medicament medicament1 = new Medicament("001", "Tylenol", 100, validiteTylenol, 5.52, fournisseur1);
        Medicament medicament2 = new Medicament("002", "Vitamine_C", 100, validiteVitamineC, 7.50, fournisseur2);
        Cosmetique cosmetique1 = new Cosmetique("003", "HeadSholders", 100, validiteHeadShoulders, 22.79, fournisseur3);
        Cosmetique cosmetique2 = new Cosmetique("004", "Colgate", 100, validiteColgate, 68.99, fournisseur4);

        //Enregistrer les produits dans l'arraylist
        stockageProduits.enregistrerProduit(medicament1);
        stockageProduits.enregistrerProduit(medicament2);
        stockageProduits.enregistrerProduit(cosmetique1);
        stockageProduits.enregistrerProduit(cosmetique2);

        //Enregistrer les fournisseurs dans l'arraylist
        stockageFournisseurs.enregistrerFournisseur(fournisseur1);
        stockageFournisseurs.enregistrerFournisseur(fournisseur2);
        stockageFournisseurs.enregistrerFournisseur(fournisseur3);
        stockageFournisseurs.enregistrerFournisseur(fournisseur4);

        //Enregistrer les clients dans l'arraylist
        stockageClients.enregistrerClient(client1);
        stockageClients.enregistrerClient(client2);
        stockageClients.enregistrerClient(client3);
        stockageClients.enregistrerClient(client4);
        stockageClients.enregistrerClient(client5);
        stockageClients.enregistrerClient(client6);
    }
}
