package fr.webforce3.mycdiapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.webforce3.mycdiapp.connection.JDBCConnexion;
import fr.webforce3.mycdiapp.entity.Livre;

public class LivreDAO {

	private Connection conn;
	
	public LivreDAO() {
		Connection conn = JDBCConnexion.getConnexion();		
	}
	

	public ArrayList<Livre> findAll() {
		ArrayList<Livre> list = new ArrayList<Livre>();
	
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM livres");
	        ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Livre(rs.getString("nom"), rs.getString("auteur"), rs.getString("format")));
		        
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}
	
}
