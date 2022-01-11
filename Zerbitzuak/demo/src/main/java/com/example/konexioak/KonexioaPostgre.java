package com.example.konexioak;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.example.konexioak.model.Puntuazioa;
import com.example.konexioak.model.User;

public class KonexioaPostgre extends Thread{
 
	public Connection connect() {
		Connection conn = null;
		try {
			String url = "jdbc:postgresql://192.168.65.187/naaahi";
			Properties props = new Properties();
			props.setProperty("user", "odoo15");
			props.setProperty("password", "Admin123");
			conn = DriverManager.getConnection(url, props);
			
			System.out.println("Postgres-era konektatuta");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return conn;
	}

	public ArrayList<User> selectUser() {
		ArrayList<User> users = new ArrayList<>();

		String sql = "SELECT * FROM app_users";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				User m = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"),
						rs.getString("password"));
				users.add(m);
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return users;

	}
	
	public ArrayList<Puntuazioa> selectPuntuazioa() {
		ArrayList<Puntuazioa> puntuazioak = new ArrayList<>();

		String sql = "SELECT * FROM ranking_juego_puntuazioa";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Puntuazioa m = new Puntuazioa(rs.getInt("jokalari_id"), rs.getString("jokalari"), rs.getInt("puntuazioa"));
				puntuazioak.add(m);
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return puntuazioak;

	}
	
	public int insertPuntuazioa(Puntuazioa p) {
	       String sql = "INSERT INTO ranking_juego_puntuazioa(jokalari_id,jokalari,puntuazioa,data,create_uid,create_date,write_uid,write_date ) VALUES(?,?,?,NOW(),2,NOW(),2,NOW())";
	       try (Connection conn = connect();
	           PreparedStatement ptmt = conn.prepareStatement(sql)) {
	           
	    	   ptmt.setInt(1, p.getJokalariId());
	    	   ptmt.setString(2, p.getJokalari());
	    	   ptmt.setInt(3, p.getPuntuazioa());
	           ptmt.executeUpdate();
	           return 1;
	       } catch (SQLException e) {
	           JOptionPane.showMessageDialog(null,e.getMessage());
	           return 0;
	       }
	}

}
