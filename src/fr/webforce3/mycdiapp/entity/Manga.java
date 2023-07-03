package fr.webforce3.mycdiapp.entity;

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
	
	
	
}
