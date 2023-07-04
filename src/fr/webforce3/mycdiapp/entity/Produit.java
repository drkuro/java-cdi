package fr.webforce3.mycdiapp.entity;

import java.util.Random;
import java.util.Scanner;

abstract public class Produit {

	protected String id;
	protected String nom;
	protected boolean available;
	
	public Produit(String nom) {
		super();
		this.nom = nom;
		this.id = generateId();
		this.available = true;
	}
	
	public String generateId() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public String getId() {
		return id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean isAvailable) {
		this.available = isAvailable;
	}
	
	@Override
    public String toString() {
        return "Produit " + getNom() + " (id " + getId() + ")";
    }

	public static Produit createProduit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel type de produit souhaitez-vous créer ?");
        System.out.println("1. Livre");
        System.out.println("2. Jeu de société");
        System.out.println("3. Livre scolaire");
        System.out.println("4. Manga");

        switch (scanner.nextInt()) {
            case 1:
                return Livre.create();
            case 2:
                return JeuDeSociete.create();
            case 3:
                return LivreScolaire.create();
            case 4:
                return Manga.create();
            default:
                System.out.println("Choix invalide. Création de produit annulée.");
                return null;
        }
    }
	
}
