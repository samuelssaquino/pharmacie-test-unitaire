package Stockage;

import Client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StockageClientTest {

    @DisplayName("Il devrait enregistrer un client et verifier le taille=1, code=0101, nom=Client1")
    @Test
    public void enregistrerClient_client1_getCodeGetNom() {

        Client client1 = new Client("0101", "Client1");
        StockageClient stockageClient = new StockageClient();

        stockageClient.enregistrerClient(client1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, stockageClient.clients.size()),
                () -> Assertions.assertEquals("0101", stockageClient.clients.get(0).getCode()),
                () -> Assertions.assertEquals("Client1", stockageClient.clients.get(0).getNom())

        );
    }

    @DisplayName("Il devrait enregistrer 5 client et verifier le taille=5")
    @Test
    public void quantiteClientStockes_5Client_taille5() {

        Client client1 = new Client("0101", "Client1");
        Client client2 = new Client("0202", "Client2");
        Client client3 = new Client("0303", "Client3");
        Client client4 = new Client("0404", "Client4");
        Client client5 = new Client("0505", "Client5");

        StockageClient stockageClient = new StockageClient();

        stockageClient.enregistrerClient(client1);
        stockageClient.enregistrerClient(client2);
        stockageClient.enregistrerClient(client3);
        stockageClient.enregistrerClient(client4);
        stockageClient.enregistrerClient(client5);

        int resultat = stockageClient.quantiteClientStockes();

        Assertions.assertEquals(5, resultat);

    }
}
