package fr.webforce3.mycdiapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import fr.webforce3.mycdiapp.connection.JDBCConnexion;
import fr.webforce3.mycdiapp.entity.Livre;
import fr.webforce3.mycdiapp.utils.Scan;

public class LivreDAO {

	private Connection conn;

	public LivreDAO() {
		conn = JDBCConnexion.getConnexion();
	}

	public ArrayList<Livre> findAll() {
		ArrayList<Livre> list = new ArrayList<Livre>();

		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM livres");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Livre(rs.getString("nom"), rs.getString("auteur"), rs.getString("format")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Livre> findAllByAvailable(boolean available) {
		ArrayList<Livre> list = new ArrayList<Livre>();

		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM livres WHERE available = ?");
			stmt.setBoolean(1, available);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Livre(rs.getInt("id"), rs.getString("nom"), rs.getString("auteur"),
						rs.getString("format")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateLivre(int id, boolean available) {
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE livres SET available = ? WHERE id = ?");
			stmt.setBoolean(1, available);
			stmt.setInt(2, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean create() {
		Scanner scanner = Scan.get();

		System.out.println("Entrez le nom du livre : ");
		String nom = scanner.next();

		System.out.println("Entrez l'auteur du livre : ");
		String auteur = scanner.next();

		System.out.println("Entrez le format du livre : ");
		String format = scanner.next();

		try {
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO livres (nom, auteur, format, available) VALUES(?, ?, ?, ?)");
			stmt.setString(1, nom);
			stmt.setString(2, auteur);
			stmt.setString(3, format);
			stmt.setBoolean(4, true);
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
