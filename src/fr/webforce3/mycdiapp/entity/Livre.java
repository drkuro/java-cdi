package fr.webforce3.mycdiapp.entity;

public class Livre extends Produit {

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
	
}
