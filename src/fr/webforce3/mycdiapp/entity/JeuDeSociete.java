package fr.webforce3.mycdiapp.entity;
import java.util.Scanner;

public class JeuDeSociete extends Produit {
    private String type;

    public JeuDeSociete(String nom, String type) {
        super(nom);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JeuDeSociete [nom=" + getNom() + ", type=" + type + "]";
    }

    public static JeuDeSociete create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom du jeu de société : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez le type du jeu de société : ");
        String type = scanner.nextLine();

        scanner.close();

        return new JeuDeSociete(nom, type);
    }
}
