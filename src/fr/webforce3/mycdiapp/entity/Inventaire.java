package fr.webforce3.mycdiapp.entity;

import java.util.ArrayList;
import java.util.Scanner;

import fr.webforce3.mycdiapp.dao.LivreDAO;
import fr.webforce3.mycdiapp.utils.Scan;

public class Inventaire {

	private static Inventaire instance;
	private Scanner sc = Scan.get();
	private LivreDAO livreDao;

	private Inventaire() {
		this.livreDao = new LivreDAO();
	}

	public static Inventaire getInstance() {
		if (instance == null) {
			instance = new Inventaire();
		}
		return instance;
	}

	public void emprunterMenu() throws Exception {
		System.out.println("Quels produits voulez-vous emprunter ?");
		// la liste vien de la base de donnée
		ArrayList<Livre> list = livreDao.findAllByAvailable(true);
		for (Produit produit : list) {
			System.out.println(produit);
		}

		int choice = sc.nextInt();

		for (Produit produit : list) {
			if (choice == produit.getId()) {

				System.out.println("Vous avez emprunté " + produit.getNom());
				livreDao.updateLivre(produit.getId(), false);
				return;
			}
		}
		throw new Exception("Aucun produit trouvé");
	}

	public void rendreMenu() throws Exception {
		System.out.println("Quels produits voulez-vous rendre ?");
		// la liste vien de la base de donnée
		ArrayList<Livre> list = livreDao.findAllByAvailable(false);
		for (Produit produit : list) {
			System.out.println(produit);
		}

		int choice = sc.nextInt();

		for (Produit produit : list) {
			if (choice == produit.getId()) {

				System.out.println("Vous avez rendu " + produit.getNom());
				livreDao.updateLivre(produit.getId(), true);
				return;
			}
		}
		throw new Exception("Ce produit n'est pas a rendre");
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
		ArrayList<Livre> list = livreDao.findAllByAvailable(true);

		for (Produit produit : list) {
			System.out.println("Nom : " + produit.getNom());
		}
	}

	public void addProduit() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Quel type de produit souhaitez-vous créer ?");
		System.out.println("1. Livre");
		System.out.println("2. Jeu de société");
		System.out.println("3. Livre scolaire");
		System.out.println("4. Manga");

		int opt = scanner.nextInt();

		switch (opt) {
		case 1:
			livreDao.create();
			break;
		case 2:
			JeuDeSociete.create();
			break;
		case 3:
			LivreScolaire.create();
			break;
		case 4:
			Manga.create();
			break;
		default:
			System.out.println("Choix invalide. Création de produit annulée.");
		}

	}

}
