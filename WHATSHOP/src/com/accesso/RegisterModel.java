package com.accesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class RegisterModel {
	
public void register(String nome, String cognome, String data, String citta, String indirizzo, int cap ,String email,  String username, String password) {
		

		String sql = null;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			sql = "insert into USERS(username,password,email,cognome,nome,data,cap,citta,indirizzo,admin) values (?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, cognome);
			pstmt.setString(5, nome);
			pstmt.setString(6, data);
			pstmt.setInt(7, cap);
			pstmt.setString(8, citta);
			pstmt.setString(9, indirizzo);
			pstmt.setBoolean(10, false);
			pstmt.executeUpdate();
			
			pstmt.close();
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
		

		
		
}

}
