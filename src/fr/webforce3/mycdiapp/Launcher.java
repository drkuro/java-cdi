package fr.webforce3.mycdiapp;

import java.util.Scanner;

import fr.webforce3.mycdiapp.entity.Inventaire;
import fr.webforce3.mycdiapp.utils.Scan;

public class Launcher {

	public static void main(String[] args) {
		// Je récupère la liste de mon inventaire
		Inventaire cdi = Inventaire.getInstance();

		Scanner sc = Scan.get();

		System.out.println("Bonjour, bienvenue sur notre CDI");

		boolean keep = true;
		while (keep) {

			System.out.println("Que puis-je faire pour vous ?");
			System.out.println("1- Emprunter");
			System.out.println("2- Rendre");
			System.out.println("3- Ajouter un nouvel élément à l'inventaire");
			System.out.println("4- Afficher les produits disponibles");
			System.out.println("5- Afficher les produits empruntés");
			System.out.println("0- Quitter");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				try {
					cdi.emprunterMenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				try {
					cdi.rendreMenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				cdi.addProduit();
				break;
			}
			case 4: {
				cdi.afficherDisponibles();
				break;
			}
			case 5: {
				cdi.afficherEmpruntes();
				break;
			}
			case 0:
				System.out.println("Merci, et à bientôt");
				keep = false;
				break;

			default:
				System.out.println("Je n'ai pas compris");
				break;
			}

			System.out.println("=============");
			System.out.println("Prochaine personne ");
			System.out.println("=============");

		}
		sc.close();
	}

}
