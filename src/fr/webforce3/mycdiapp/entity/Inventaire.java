package fr.webforce3.mycdiapp.entity;

import java.util.ArrayList;
import java.util.Scanner;

import fr.webforce3.mycdiapp.dao.LivreDAO;
import fr.webforce3.mycdiapp.exception.NotAvaiableException;

public class Inventaire {

	private static Inventaire instance;
	protected ArrayList<Produit> list;
    private Scanner sc = new Scanner(System.in);
    private LivreDAO livreDao;

	private Inventaire() {
		this.livreDao = new LivreDAO();
		this.list = this.generateList();
	}


	public static Inventaire getInstance() {
		if(instance == null) {
			instance = new Inventaire();
		}
		return instance;
	}
	
	public ArrayList<Produit> generateList(){
		ArrayList<Produit> list = new ArrayList<Produit>();
		/*
		list.add(new Livre("Harry potter", "jk rowling", "Poche"));
		list.add(new Livre("Harry potter 2", "jk rowling", "Poche"));
		list.add(new LivreScolaire("Les maths pour les CP", "Maths", "CP"));
		list.add(new LivreScolaire("Le francais pour les CP", "Francais", "CP"));
		list.add(new Manga("Dragon Ball", "akira toriyama", "Tome 1"));
		list.add(new Manga("Dragon Ball", "akira toriyama", "Tome 2"));
		list.add(new JeuDeSociete("Jumanji", "Edition Collector"));
		 */
		 
		list.addAll(livreDao.findAll());
		
		return list;
		
	}

	public ArrayList<Produit> getList() {
		return list;
	}

	public void setList(ArrayList<Produit> list) {
		this.list = list;
	}
	public void emprunterMenu() throws Exception {
        System.out.println("Quels produits voulez-vous emprunter ?");
        for (Produit produit : list) {
            if (produit.isAvailable()) {
                System.out.println(produit);
            }
        }
        String choice = sc.next();

        for (Produit produit : list) {
            if (choice.equals(produit.getId())) {
                if (!produit.isAvailable()) {
                    throw new NotAvaiableException();
                }
                System.out.println("Vous avez emprunté " + produit.getNom());
                produit.setAvailable(false);
                return;
            }
        }
        throw new Exception("Aucun produit trouvé");
    }

    public void rendreMenu() throws Exception {
        System.out.println("Quels produits voulez-vous rendre ?");
        for (Produit produit : list) {
            if (!produit.isAvailable()) {
                StringBuilder sb = new StringBuilder();
                sb.append("id : " + produit.getId());
                sb.append(" - nom : " + produit.getNom());
                System.out.println(sb.toString());
            }
        }
        String choice = sc.next();
        Produit produit = list.stream()
        		.filter(p -> p.getId().equals(choice) && !p.isAvailable())
        		.findFirst()
        		.orElseThrow(() -> new Exception("Aucun produit trouvé"));
        System.out.println("Vous avez rendu " + produit.getNom());
        produit.setAvailable(true);
    }

    public void afficherEmpruntes() {
        System.out.println("Produits empruntés :");
        for (Produit produit : list) {
            if (!produit.isAvailable()) {
                System.out.println("Nom : " + produit.getNom());
            }
        }
    }

    public void afficherDisponibles() {
        System.out.println("Produits disponibles :");
        for (Produit produit : list) {
            if (produit.isAvailable()) {
                System.out.println("Nom : " + produit.getNom());
            }
        }
    }
	
	public void addProduit() {
		Produit p = Produit.createProduit();
		this.list.add(p);
	}
	
	
	
}
