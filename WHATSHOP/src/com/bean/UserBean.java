package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connessione.Connessione;

public class UserBean {
	
	public int getIdUtente(String username) {
		

		
		int id = 0;
		
		String sql = "SELECT id_user from USERS WHERE username = ?";
		
		PreparedStatement pstmt;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			id = (int) rs.getInt(1);
			pstmt.close();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Integer) null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public int effettuaUser(String data, int userId, int prodId)  {	
		

		String sql = null;
		String sql3 = null;
		int ordineId=0;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "SELECT id_ordine from ORDINE where data = '"+data+"' and USER_id = "+userId;
			
			PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement(sql);
			
			
			ResultSet rs = pstmt2.executeQuery();
			
			rs.next();
			
			ordineId = rs.getInt(1);
			
			sql3 = "INSERT into EFFETTUA_USERS value (?,?,?)";
			
			PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement(sql3);
			
			pstmt3.setInt(1, ordineId);
			pstmt3.setInt(2, userId);
			pstmt3.setInt(3, prodId);
			
			pstmt3.executeUpdate();
			pstmt2.close();
			pstmt3.close();
			con.close();
			return ordineId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Integer) null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
public ArrayList getUser() {
		
		String sql = null;
		String username = null;
		ArrayList users = new ArrayList();
		
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select username from USERS";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			
			ResultSet rs = pstmt.executeQuery();
			

			
			while(rs.next()){
				
				username = rs.getString(1);
				
				users.add(username);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
}

public String getUsername(int idUser) {
	

	String sql = null;
	String username = null;
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		
		sql = "Select username from USERS where id_user = ?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, idUser);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		username = rs.getString(1);
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return username;
	

}

public ArrayList getUser(int id) {
	

	String sql = null;
	ArrayList user = new ArrayList();
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		
		sql = "Select username,password,email,cognome,nome,data,cap,citta,indirizzo from USERS where id_user = ?";

		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			user.add(rs.getString(1));
			user.add(rs.getString(2));
			user.add(rs.getString(3));
			user.add(rs.getString(4));
			user.add(rs.getString(5));
			user.add(rs.getString(6));
			user.add(rs.getInt(7));
			user.add(rs.getString(8));
			user.add(rs.getString(9));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return user;
}

}
