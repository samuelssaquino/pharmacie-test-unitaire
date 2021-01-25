package Stockage;

import Client.Client;

import java.util.ArrayList;

//Cette classe stocke les clients dans l'arraylist
public class StockageClient {

    ArrayList<Client> clients = new ArrayList<Client>();

    //Cette méthode insère les clients dans l'arraylist
    public void enregistrerClient(Client c) {
        this.clients.add(c);
    }

    //Cette méthode renvoie le nombre de clients stockés.
    public int quantiteClientStockes() {
        return this.clients.size();
    }

    //Cette méthode renvoie tous les clients stockés.
    public ArrayList<Client> getTousLesClients() {
        return this.clients;
    }

    //Cette méthode recherche un client par son code.
    public Client rechercherClientParCode(String code) {

        Client clientRechercher = null;

        for (int i = 0; i < this.clients.size(); i++) {
            Client c = this.clients.get(i);

            if (c.getCode().equals(code)) {
                clientRechercher = c;
                break;
            }
        }

        if (clientRechercher == null) {
            System.out.println("");
            System.out.println("Le code client n'est pas enregistré dans le système.");
            System.out.println("Entrez un code valide!");
            System.out.println("");
        }

        return clientRechercher;
    }

    //Cette méthode recherche un client par son nom.
    public Client rechercherClientParNom(String nom) {
        Client clientRechercher = null;

        for (int i = 0; i < this.clients.size(); i++) {
            Client c = this.clients.get(i);

            if (c.getNom().equals(nom)) {
                clientRechercher = c;
                break;
            }
        }

        if (clientRechercher == null) {
            System.out.println("");
            System.out.println("Le nom du client n'est pas enregistré dans le système.");
            System.out.println("Entrez un nom valide!");
            System.out.println("");
        }

        return clientRechercher;
    }
}
