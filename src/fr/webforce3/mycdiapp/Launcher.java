package fr.webforce3.mycdiapp;

import java.util.Scanner;

import fr.webforce3.mycdiapp.entity.Inventaire;
import fr.webforce3.mycdiapp.entity.Produit;
import fr.webforce3.mycdiapp.exception.NotAvaiableException;

public class Launcher {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Je recupere la list de mon inventaire
		Inventaire cdi = Inventaire.getInstance();
		
		System.out.println("Bonjour, bienvenu sur notre CDI");
		System.out.println("Que puis-je pour vous ? ");
		System.out.println("1- Emprunter");
		System.out.println("2- Rendre");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		while(true) {
			switch (choice) {
			case 1: {
				emprunterMenu(cdi);
				break;
			}
			case 2: {
				
				break;
			}
			case 0:
				System.out.println("Merci, et a bientot");
				sc.close();
				return;
			
			default:
				System.out.println("Je n'ai pas compris");
				return;
			}
		}
	
	}

	private static void emprunterMenu(Inventaire cdi) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Quels produits voulez vous emprunter ? ");
		for (Produit produit : cdi.getList()) {
			if(produit.isAvailable()) {
				StringBuilder sb = new StringBuilder();
				sb.append("id : " + produit.getId());
				sb.append(" - nom : " + produit.getNom());
				System.out.println(sb.toString());
			}
		}
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();

		while(true) {
			for (Produit produit : cdi.getList()) {
				if(choice.equals(produit.getId())) {
					if(!produit.isAvailable()) {
						throw new NotAvaiableException();
					}
					System.out.println("Vous avez emprunter " + produit.getNom());
					produit.setAvailable(false);
					return;
				}
			}
			throw new Exception("No product found");
		}
		
		
		
	}

}
