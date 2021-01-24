package Client;

//Les client peuvent acheter produits
public class Client {

    // Attributs du client
    private String code;
    private String nom;

    // Constructeur du client
    public Client(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    //Getters et Setters du client
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}