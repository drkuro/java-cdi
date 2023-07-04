package fr.webforce3.mycdiapp.entity;
import java.util.Scanner;

public class Livre extends Produit  {
    private String auteur;
    private String format;

    public Livre(String nom, String auteur, String format) {
        super(nom);
        this.auteur = auteur;
        this.format = format;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("id : " + this.getId());
        sb.append(" - nom : " + this.getNom());
        return sb.toString();
    	}

    public static Livre create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du livre : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez l'auteur du livre : ");
        String auteur = scanner.nextLine();

        System.out.println("Entrez le format du livre : ");
        String format = scanner.nextLine();

        scanner.close();
        
        return new Livre(nom, auteur, format);
    }
    
    
}
