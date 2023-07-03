package fr.webforce3.mycdiapp.entity;

import java.util.Random;

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
	
	
}
