package fr.webforce3.mycdiapp.entity;
import java.util.Scanner;

public class LivreScolaire extends Produit {
    private String matiere;
    private String classe;

    public LivreScolaire(String nom, String matiere, String classe) {
        super(nom);
        this.matiere = matiere;
        this.classe = classe;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "LivreScolaire [nom=" + getNom() + ", matiere=" + matiere + ", classe=" + classe + "]";
    }

    public static LivreScolaire create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du livre scolaire : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez la matière du livre scolaire : ");
        String matiere = scanner.nextLine();

        System.out.println("Entrez la classe du livre scolaire : ");
        String classe = scanner.nextLine();

        scanner.close();

        return new LivreScolaire(nom, matiere, classe);
    }
}
