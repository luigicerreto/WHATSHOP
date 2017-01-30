package com.pannelloadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class AddCatModel {
	
	public boolean addCat(String nomeCat) {
		
		
		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "insert into CATEGORIE(tipo_categoria) value (?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nomeCat);
			
			
			
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
