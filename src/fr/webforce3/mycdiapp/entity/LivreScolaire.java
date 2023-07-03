package fr.webforce3.mycdiapp.entity;

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
	
	
	
}
