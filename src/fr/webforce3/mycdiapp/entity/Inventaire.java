package fr.webforce3.mycdiapp.entity;

import java.util.ArrayList;

public class Inventaire {

	private static Inventaire instance;
	protected ArrayList<Produit> list;

	private Inventaire() {
		this.list = this.generateList();
	}
	
	private Inventaire(ArrayList<Produit> list) {
		this.list = list;
	}
	
	public static Inventaire getInstance(ArrayList<Produit> list) {
		if(instance == null) {
			instance = new Inventaire(list);
		}
		return instance;
		
	}
	
	public static Inventaire getInstance() {
		if(instance == null) {
			instance = new Inventaire();
		}
		return instance;
	}
	
	public ArrayList<Produit> generateList(){
		ArrayList<Produit> list = new ArrayList<Produit>();
		list.add(new Livre("Harry potter", "jk rowling", "Poche"));
		list.add(new Livre("Harry potter 2", "jk rowling", "Poche"));
		list.add(new LivreScolaire("Les maths pour les CP", "Maths", "CP"));
		list.add(new LivreScolaire("Le francais pour les CP", "Francais", "CP"));
		list.add(new Manga("Dragon Ball", "akira toriyama", "Tome 1"));
		list.add(new Manga("Dragon Ball", "akira toriyama", "Tome 2"));
		list.add(new JeuDeSociete("Jumanji", "Edition Collector"));

		return list;
		
	}

	public ArrayList<Produit> getList() {
		return list;
	}

	public void setList(ArrayList<Produit> list) {
		this.list = list;
	}
	
	
	
	
}
