package Fournisseur;

//Les fournisseurs fournissent des produits à la pharmacie
public class Fournisseur {

    // Attributs du fournisseur
    private String code;
    private String nom;

    // Constructeur du fournisseur
    public Fournisseur(String code, String nom){
        this.code = code;
        this.nom = nom;
    }

    //Getters et Setters du fournisseur
    public String getCode(){
        return code;
    }

    public String getNom(){
        return nom;
    }
}
