package fr.webforce3.mycdiapp.entity;
import java.util.Scanner;

public class Manga extends Produit {
    private String auteur;
    private String numero;

    public Manga(String nom, String auteur, String numero) {
        super(nom);
        this.auteur = auteur;
        this.numero = numero;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Manga [nom=" + getNom() + ", auteur=" + auteur + ", numero=" + numero + "]";
    }

    public static Manga create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du manga : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez l'auteur du manga : ");
        String auteur = scanner.nextLine();

        System.out.println("Entrez le numéro du manga : ");
        String numero = scanner.nextLine();

        scanner.close();

        return new Manga(nom, auteur, numero);
    }
}
