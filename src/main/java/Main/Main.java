package Main;

import Client.Client;
import Fournisseur.Fournisseur;
import Produit.Cosmetique;
import Produit.Medicament;
import Produit.Produit;
import Stockage.StockageClient;
import Stockage.StockageFournisseur;
import Stockage.StockageProduit;
import Stockage.StockageVente;
import Vente.Vente;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
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

        String option = "";
        while (!option.equals("0")) {
            //MENU PRINCIPALE
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.print("                       [1-FAIRE UN ACHAT]");
            System.out.print(" [2-PRODUITS]");
            System.out.print(" [3-CLIENTS]");
            System.out.print(" [4-FOURNISSEURS]");
            System.out.print(" [5-VENTES]");
            System.out.println(" [0-SORTEZ]");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.print("                                                Entrez une des options: ");
            option = clavier.next();

            System.out.flush();


            switch (option) {
                //MENU ACHATER
                case "1":

                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("                                             ===== ACHETER UN PRODUIT =====                                 ");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("");

                    //Instance de vente
                    Vente v = new Vente();

                    //Instance de la liste de produits de vente
                    v.produits = new ArrayList<Produit>();

                    //Quantité totale d'articles vendus
                    //int qtdTotalDeItensVendidos = 0;

                    Client clientRecherher;

                    do {
                        //Le client que va acheter
                        String code;
                        System.out.print("Entrez le code client: ");
                        code = clavier.next();

                        //Cherche le client dans l'arraylist par code.
                        clientRecherher = stockageClients.rechercherClientParCode(code);

                    } while (clientRecherher == null);

                    System.out.println("Salut, " + clientRecherher.getNom());
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");


                    char laReponse;
                    //Le loop pour ajouter plus produits a lá vente
                    do {
                        Produit produitRechercher;
                        do {
                            //Informer le nom du produit
                            String nomProduit;
                            System.out.print("Nom produit: ");
                            nomProduit = clavier.next();

                            //Cherche le produit dans l'arraylist par nom.
                            produitRechercher = stockageProduits.rechercherProduitParNom(nomProduit);

                        } while (produitRechercher == null);


                        System.out.printf("Prix: $ %.2f", produitRechercher.getPrix());
                        System.out.println("");
                        System.out.printf("Rabais: $ %.2f", produitRechercher.rabaisMax());
                        System.out.println("");
                        System.out.println("Stock: " + produitRechercher.getStock() + " unité(s)");

                        boolean validationQuantite = false;
                        String validationQuatitePourInteger;

                        //Validation de la quantité au stock
                        do {
                            System.out.print("");

                            // Validation du stock = 0
                            if (produitRechercher.getStock() == 0) {
                                validationQuantite = true;
                                System.out.println("");
                                System.out.println("Stock insuffisant, veuillez informer un produit qui existe en stock!");
                                System.out.println("");
                            } else {

                                int qtd = 0;
                                boolean tipoInt;

                                // Valide si le type de la quantité déclarée est un int
                                do {
                                    System.out.print("Entrez la quantité souhaitée: ");
                                    validationQuatitePourInteger = clavier.next();

                                    try {
                                        qtd = Integer.parseInt(validationQuatitePourInteger);
                                        tipoInt = true;

                                    } catch (Exception e) {
                                        System.out.println("");
                                        System.out.println("Le type n'est pas valide, veuillez entrer un type valide!");
                                        System.out.println("");
                                        tipoInt = false;
                                    }
                                } while (!tipoInt);

                                // Valide la quantité et supprime le stock
                                validationQuantite = produitRechercher.retirerStock(qtd);

                                if (validationQuantite) {

                                    //Augmente la quantité totale de produits vendus
                                    v.setQuantite(qtd);

                                    //Calcule le prix de vente total
                                    v.setPrixTotal(produitRechercher.getPrix(), qtd, produitRechercher.rabaisMax());

                                    //Enregistrer le client de la vente
                                    v.setClient(clientRecherher);

                                    //Enregistrer le produit de la vente
                                    v.produits.add(produitRechercher);
                                }
                            }

                        } while (!validationQuantite);

                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("VALEUR PARTIELLE: $ %.2f", v.getPrixTotal());
                        System.out.println("");

                        //Loop pour continuer la vente
                        System.out.print("Souhaitez-vous ajouter plus de produits? - (oui/n)? ");
                        laReponse = clavier.next().charAt(0);
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                    } while (laReponse != 'n');

                    if (!(v.getQuantite() <= 0)) {
                        //Générateur de code randomique
                        Random generator = new Random();
                        int codVente;
                        codVente = generator.nextInt(999999999);

                        //Insérez le code de vente aléatoirement
                        v.setCode(codVente);

                        //Insérer la vente dans l'arraylist des ventes.
                        stockageVentes.enregistrerVente(v);

                        System.out.println("                                                 ===== FACTURE D'ACHAT =====                           ");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("");

                        System.out.println("Code de vente: " + v.getCode());
                        System.out.println("                                ");
                        System.out.println("Produit(s): ");
                        for (int x = 0; x < v.produits.size(); x++) {
                            System.out.println("  * " + v.produits.get(x).getDescription());
                        }
                        System.out.println("");
                        System.out.println("Quantité totale de produits: " + v.getQuantite());
                        System.out.printf("VALEUR TOTALE: $ %.2f", v.getPrixTotal());
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("                                                Votre achat a réussi!                       ");
                        System.out.println("                                                     A bientôt!                             ");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("");
                    } else {
                        System.out.println("");
                        System.out.println("                                          Votre achat n'a pas été effectué!");
                        System.out.println("");
                    }

                    break;

                //MENU PRODUITS
                case "2":

                    String optionProduit = "";
                    while (!optionProduit.equals("0")) {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("                              [1-PRODUIT PAR CODE]");
                        System.out.print(" [2-PRODUTIS PAR NOM]");
                        System.out.println(" [3-MEDICAMENTS]");
                        System.out.println("");
                        System.out.print("                           [4-COSMÉTIQUES]");
                        System.out.print(" [5-TOUS LES PRODUITS]");
                        System.out.println(" [6-AUGMENTEZ LA QUATITÉ D'ARTICLES EN STOCK]");
                        System.out.println("");
                        System.out.println("                                                  [0-MENU PRINCIPAL]");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.print("                                                Entrez une des options: ");
                        optionProduit = clavier.next();

                        switch (optionProduit) {
                            case "1":
                                Produit produitRechercherParCode;

                                //Répéter jusqu'à trouver le produit par code
                                do {
                                    String codeProduit;
                                    System.out.print("Code Produit: ");
                                    codeProduit = clavier.next();

                                    //Vérifier si il y a le produit recherché
                                    produitRechercherParCode = stockageProduits.rechercherProduitParCode(codeProduit);

                                } while (produitRechercherParCode == null);

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                             ===== PRODUIT PAR CODE =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                System.out.println("Code Produit: " + produitRechercherParCode.getCode());
                                System.out.println("Description: " + produitRechercherParCode.getDescription());
                                System.out.println("Stock: " + produitRechercherParCode.getStock() + " unité(s)");
                                System.out.println("Validite: Fab " + ld + " | Exp " + produitRechercherParCode.getValidite());
                                System.out.println("Fournisseur: " + produitRechercherParCode.getFournisseur().getNom());
                                System.out.printf("Prix Unitaire: $ %.2f", produitRechercherParCode.getPrix());
                                System.out.println("");
                                System.out.printf("Rabais: $ %.2f", produitRechercherParCode.rabaisMax());
                                System.out.println("");
                                System.out.println("");

                                break;
                            case "2":
                                Produit produitRechercherParNom;

                                //Répéter jusqu'à trouver le produit par nom
                                do {
                                    String nomProduit;
                                    System.out.print("Nom Produit: ");
                                    nomProduit = clavier.next();

                                    //Vérifier si il y a le produit recherché
                                    produitRechercherParNom = stockageProduits.rechercherProduitParNom(nomProduit);

                                } while (produitRechercherParNom == null);

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                             ===== PRODUIT PAR NOM =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                System.out.println("Code Produit: " + produitRechercherParNom.getCode());
                                System.out.println("Description: " + produitRechercherParNom.getDescription());
                                System.out.println("Stock: " + produitRechercherParNom.getStock() + " unidade(s)");
                                System.out.println("Validité: Fab " + ld + " | Exp " + produitRechercherParNom.getValidite());
                                System.out.println("Fournisseur: " + produitRechercherParNom.getFournisseur().getNom());
                                System.out.printf("Prix Unitaire: $ %.2f", produitRechercherParNom.getPrix());
                                System.out.println("");
                                System.out.printf("Rabis: $ %.2f", produitRechercherParNom.rabaisMax());
                                System.out.println("");
                                System.out.println("");
                                break;
                            case "3":

                                ArrayList<Produit> medicaments = stockageProduits.getTousLesProduits();

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                        ===== PRODUITS - MEDICAMENTS =====                             ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                for (int i = 0; i < medicaments.size(); i++) {
                                    Produit p = medicaments.get(i);

                                    if (p instanceof Medicament) {
                                        System.out.println("Code Produit: " + p.getCode());
                                        System.out.println("Description: " + p.getDescription());
                                        System.out.println("Stock: " + p.getStock() + " unité(s)");
                                        System.out.println("Validité: Fab " + ld + " | Exp " + p.getValidite());
                                        System.out.println("Fournisseur: " + p.getFournisseur().getNom());
                                        System.out.printf("Prix Unitaire: $ %.2f", p.getPrix());
                                        System.out.println("");
                                        System.out.printf("Rabais: $ %.2f", p.rabaisMax());
                                        System.out.println("");
                                        System.out.println("");
                                    }
                                }
                                break;
                            case "4":

                                ArrayList<Produit> cosmetiques = stockageProduits.getTousLesProduits();

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                         ===== PRODUITS - COSMÉTIQUES =====                                ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                for (int i = 0; i < cosmetiques.size(); i++) {
                                    Produit p = cosmetiques.get(i);

                                    if (p instanceof Cosmetique) {
                                        System.out.println("Code Produit: " + p.getCode());
                                        System.out.println("Description: " + p.getDescription());
                                        System.out.println("Stock: " + p.getStock() + " unité(s)");
                                        System.out.println("Validité: Fab " + ld + " | Exp " + p.getValidite());
                                        System.out.println("Fournisseur: " + p.getFournisseur().getNom());
                                        System.out.printf("Prix Unitaire: $ %.2f", p.getPrix());
                                        System.out.println("");
                                        System.out.printf("Rabais: R$ %.2f", p.rabaisMax());
                                        System.out.println("");
                                        System.out.println("");
                                    }
                                }

                                break;
                            case "5":

                                ArrayList<Produit> tousLesProduits = stockageProduits.getTousLesProduits();
                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                             =====TOUS LES PRODUITS =====                                                 ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");
                                System.out.println("Quantité totale de produits enregistrés: " + stockageProduits.quantiteProduitStockes());
                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                                for (int i = 0; i < tousLesProduits.size(); i++) {
                                    Produit p = tousLesProduits.get(i);
                                    System.out.println("Code produit: " + p.getCode());
                                    System.out.println("Description: " + p.getDescription());
                                    System.out.println("Stock: " + p.getStock() + " unité(s)");
                                    System.out.println("Validité: Fab " + ld + " | Exp " + p.getValidite());
                                    System.out.println("Fournisseur: " + p.getFournisseur().getNom());
                                    System.out.printf("Prix unitaire: $ %.2f", p.getPrix());
                                    System.out.println("");
                                    System.out.printf("Rabais: $ %.2f", p.rabaisMax());
                                    System.out.println("");
                                    System.out.println("");
                                }

                                break;
                            case "6":

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                         ===== AUGMENTER LE STOCK =====                                 ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                Produit produitRechercherAugmenterStock;

                                //Répéter jusqu'à trouver le produit par nom
                                do {
                                    String nomProduitRechercherStock;
                                    System.out.print("Nom produit: ");
                                    nomProduitRechercherStock = clavier.next();

                                    //Vérifier si il y a le produit recherché
                                    produitRechercherAugmenterStock = stockageProduits.rechercherProduitParNom(nomProduitRechercherStock);

                                } while (produitRechercherAugmenterStock == null);

                                System.out.println("");
                                System.out.println("Stock: " + produitRechercherAugmenterStock.getStock() + " unité(s)");
                                System.out.println("");
                                System.out.print("Est-ce que vous voudrais ajouter plus quantité dans le stock? - (1 - oui/ 2 - n)? ");
                                char respAddEstoque = clavier.next().charAt(0);

                                if (respAddEstoque == '1') {

                                    String quantiteAjouterStockString;
                                    int quantiteAjouterStock = 0;
                                    boolean typeIntAjouterStock;
                                    System.out.println("");
                                    do {
                                        System.out.print("Entrez la quantité que vous souhaitez ajouter: ");
                                        quantiteAjouterStockString = clavier.next();

                                        try {
                                            quantiteAjouterStock = Integer.parseInt(quantiteAjouterStockString);
                                            typeIntAjouterStock = true;

                                        } catch (Exception e) {
                                            System.out.println("");
                                            System.out.println("Le type n'est pas valide, veuillez entrer un type valide!");
                                            System.out.println("");
                                            typeIntAjouterStock = false;
                                        }
                                    } while (!typeIntAjouterStock);

                                    produitRechercherAugmenterStock.ajouterStock(quantiteAjouterStock);

                                    System.out.println("");
                                    System.out.println("Stock: " + produitRechercherAugmenterStock.getStock() + " unité(s)");
                                    System.out.println("");
                                    System.out.println("La quantité a été enregistrée!");
                                } else {
                                    System.out.println("");
                                    System.out.println("Aucune quantité n'a été enregistrée");
                                }

                                break;
                        }
                    }
                    break;
                //CLIENTS
                case "3":

                    String optionClient = "";
                    while (!optionClient.equals("0")) {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("                    [1-CLIENT PAR CODE]");
                        System.out.print(" [2-CLIENT PAR NOM]");
                        System.out.print(" [3-TOUS LES CLIENT]");
                        System.out.println(" [0-MENU PRINCIPAL]");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("                                               Entrez une des options: ");
                        optionClient = clavier.next();

                        switch (optionClient) {
                            case "1":
                                Client clientRechercherParCode;

                                //Répéter jusqu'à trouver le client par code
                                do {
                                    String codeClient;
                                    System.out.print("Code Client: ");
                                    codeClient = clavier.next();

                                    //Vérifier si il y a le client recherché
                                    clientRechercherParCode = stockageClients.rechercherClientParCode(codeClient);

                                } while (clientRechercherParCode == null);

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                             ===== CLIENT PAR CODE =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                System.out.println("Code: " + clientRechercherParCode.getCode());
                                System.out.println("Nom Client: " + clientRechercherParCode.getNom());
                                System.out.println("");
                                break;
                            case "2":
                                Client clientRechercherParNom;

                                //Répéter jusqu'à trouver le client par nom
                                do {
                                    String nom;
                                    System.out.print("Nom client: ");
                                    nom = clavier.next();

                                    //Vérifier si il y a le client recherché
                                    clientRechercherParNom = stockageClients.rechercherClientParNom(nom);

                                } while (clientRechercherParNom == null);

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                             ===== CLIENT PAR NOM =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                System.out.println("Code: " + clientRechercherParNom.getCode());
                                System.out.println("Nom Client: " + clientRechercherParNom.getNom());
                                System.out.println("");
                                break;
                            case "3":
                                ArrayList<Client> tousLesClients = stockageClients.getTousLesClients();

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                            ===== TOUS LES CLIENTS =====                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");
                                System.out.println("Quantité totale des clients enregistrés: " + stockageClients.quantiteClientStockes());
                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                                for (int i = 0; i < tousLesClients.size(); i++) {
                                    Client c = tousLesClients.get(i);

                                    System.out.println("Code: " + c.getCode());
                                    System.out.println("Nom client: " + c.getNom());
                                    System.out.println("");
                                }
                                break;
                        }
                    }

                    break;
                //FORNECEDORES
                case "4":
                    String optionFournisseur = "";
                    while (!optionFournisseur.equals("0")) {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("            [1-FOURNISSEUR PAR CODE]");
                        System.out.print(" [2-FOURNISSEUR PAR NOM]");
                        System.out.print(" [3-TOUS LES FOURNISSEURS]");
                        System.out.println(" [0-MENU PRINCIPAL]");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("                                               Entrez une des options: ");
                        optionFournisseur = clavier.next();

                        switch (optionFournisseur) {
                            case "1":

                                Fournisseur fournisseurRechercherParCode;

                                //Répéter jusqu'à trouver le fournisseur par code
                                do {
                                    String codFournisseur;
                                    System.out.print("Code Fournisseur: ");
                                    codFournisseur = clavier.next();

                                    //Vérifier si il y a le fournisseur recherché
                                    fournisseurRechercherParCode = stockageFournisseurs.rechercherFournisseurParCode(codFournisseur);

                                } while (fournisseurRechercherParCode == null);

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                            ===== FOURNISSEUR PAR CODE =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                System.out.println("Code: " + fournisseurRechercherParCode.getCode());
                                System.out.println("Nom Fournisseur: " + fournisseurRechercherParCode.getNom());
                                System.out.println("");

                                break;
                            case "2":

                                Fournisseur fournisseurRechercherParNom;

                                //Répéter jusqu'à trouver le fournisseur par nom
                                do {
                                    //PRODUTO A SER COMPRADO INFORMADO
                                    String nomFournisseur;
                                    System.out.print("Nom fournisseur: ");
                                    nomFournisseur = clavier.next();

                                    //Vérifier si il y a le fournisseur recherché
                                    fournisseurRechercherParNom = stockageFournisseurs.rechercherFournisseurParNom(nomFournisseur);

                                } while (fournisseurRechercherParNom == null);

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                           ===== FOURNISSEUR PAR NOM =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                System.out.println("Code: " + fournisseurRechercherParNom.getCode());
                                System.out.println("Nom Fournisseur: " + fournisseurRechercherParNom.getNom());
                                System.out.println("");

                                break;
                            case "3":
                                ArrayList<Fournisseur> tousLesFournisseurs = stockageFournisseurs.getTousLesFournisseurs();

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                           ===== TOUS LES FOURNISSEURS =====                                 ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");
                                System.out.println("Quantité totale des fournisseurs enregistrés: " + stockageFournisseurs.quantiteFournisseurStockes());
                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                                for (int i = 0; i < tousLesFournisseurs.size(); i++) {
                                    Fournisseur f = tousLesFournisseurs.get(i);

                                    System.out.println("Code: " + f.getCode());
                                    System.out.println("Nom fournisseur: " + f.getNom());
                                    System.out.println("");
                                }
                                break;
                        }
                    }
                    break;
                //VENDAS
                case "5":

                    String opcaoVenda = "";
                    while (!opcaoVenda.equals("0")) {
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("                [1-VENDA POR CÓDIGO]");
                        System.out.print(" [2-VENDA PELO NOME CLIENTE]");
                        System.out.print(" [3-TODAS AS VENDAS]");
                        System.out.println(" [0-MENU PRINCIPAL]");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                        System.out.print("                                               Digite uma das opções: ");
                        opcaoVenda = clavier.next();

                        switch (opcaoVenda) {
                            case "1":

                                ArrayList<Vente> todasAsVendasPCodigo = stockageVentes.getTousLesVentes();
                                Vente vendaProcuradoPorCodigo;

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                            ===== VENDA POR CÓDIGO =====                                                     ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");


                                int codVendaInt = 0;
                                boolean tipoCodVendaInt;

                                if (todasAsVendasPCodigo.isEmpty()) {
                                    System.out.println("");
                                    System.out.println("                                            Não existe vendas realizadas!");
                                    System.out.println("                                            Quantidade total de vendas: " + stockageVentes.quantiteVenteRealisees());
                                    System.out.println("");
                                } else {
                                    do {
                                        //PRODUTO A SER COMPRADO INFORMADO
                                        String codVendaS;
                                        System.out.print("Código da Venda: ");
                                        codVendaS = clavier.next();

                                        try {
                                            codVendaInt = Integer.parseInt(codVendaS);
                                            tipoCodVendaInt = true;

                                        } catch (Exception e) {
                                            System.out.println("");
                                            System.out.println("O tipo é inválido, informe um tipo válido!");
                                            System.out.println("");
                                            tipoCodVendaInt = false;
                                        }
                                    } while (!tipoCodVendaInt);

                                    //VERIFICA SE EXISTE A VENDA NO REPOSITÓRIO DO O CÓDIGO INFORMADO
                                    vendaProcuradoPorCodigo = stockageVentes.rechercherVenteParCode(codVendaInt);

                                    if (!(vendaProcuradoPorCodigo == null)) {
                                        System.out.println("");
                                        System.out.println("Nome do Cliente: " + vendaProcuradoPorCodigo.getClient().getNom());
                                        System.out.println("");
                                        System.out.println("Produto(s): ");
                                        for (int x = 0; x < vendaProcuradoPorCodigo.produits.size(); x++) {
                                            System.out.println(" * " + vendaProcuradoPorCodigo.produits.get(x).getDescription());
                                        }
                                        System.out.println("");
                                        System.out.println("Quantidade total de itens: " + vendaProcuradoPorCodigo.getQuantite());
                                        System.out.printf("VALOR TOTAL: R$ %.2f", +vendaProcuradoPorCodigo.getPrixTotal());
                                        System.out.println("");
                                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("");
                                    }
                                }

                                break;
                            case "2":
                                System.out.println("Falta implementar");
                                break;
                            case "3":
                                ArrayList<Vente> todasAsVendas = stockageVentes.getTousLesVentes();

                                System.out.println("");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("                                          ===== LISTAR TODAS AS VENDAS =====                                      ");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("");

                                if (todasAsVendas.isEmpty()) {
                                    System.out.println("                                            Não existe vendas realizadas!");
                                    System.out.println("                                            Quantidade total de vendas: " + stockageVentes.quantiteVenteRealisees());
                                    System.out.println("");
                                } else {
                                    System.out.println("Quantidade total de vendas: " + stockageVentes.quantiteVenteRealisees());
                                    System.out.println("");
                                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");

                                    for (int i = 0; i < todasAsVendas.size(); i++) {
                                        v = todasAsVendas.get(i);

                                        System.out.println("Código da venda: " + v.getCode());
                                        System.out.println("");
                                        System.out.println("Nome do Cliente: " + v.getClient().getNom());
                                        System.out.println("Produto(s): ");
                                        for (int x = 0; x < v.produits.size(); x++) {
                                            System.out.println(" * " + v.produits.get(x).getDescription());
                                        }
                                        System.out.println("");
                                        System.out.println("Quantidade total de itens: " + v.getQuantite());
                                        System.out.printf("VALOR TOTAL: R$ %.2f", +v.getPrixTotal());
                                        System.out.println("");
                                        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                    }
                                }
                                break;
                        }
                    }

                    break;
            }
        }

        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                           ===== Aplicação finalizada! =====                      ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }
}
