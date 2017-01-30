package com.pannellouser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class CambiaPassModel {
	
	public boolean cambiaPass(String password, int id) {
		
		
		String sql = null;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "UPDATE USERS SET password = ? where id_user = ?";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setInt(2, id);
			
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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
