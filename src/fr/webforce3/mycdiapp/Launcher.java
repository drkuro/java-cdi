package fr.webforce3.mycdiapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import fr.webforce3.mycdiapp.entity.Inventaire;

public class Launcher {

	public static void main(String[] args){
		// Je récupère la liste de mon inventaire
		Inventaire cdi = Inventaire.getInstance();
		Scanner sc = new Scanner(System.in);

		try {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_lsib?" +
                "user=root&password=");
		System.err.println("Connected!");
      
        System.out.println("que recherchez vous ? ");
        String search = sc.next();
        
        
        PreparedStatement stmt = 
        		conn.prepareStatement("SELECT * FROM produits WHERE nom = ?");
        
        stmt.setString(1, search);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
        	System.out.println(rs.getInt(1));
        	System.out.println(rs.getString("nom"));
        }

        System.out.println("");
		} catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
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
		}
		sc.close();
	}

}
