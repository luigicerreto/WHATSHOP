package com.pannelloadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class RimuoviNegozioModel {
	
	public boolean rimuoviNeg(int idNeg) {
		
		String sql = null;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "DELETE FROM NEGOZIO_ONLINE where id_negozio = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, idNeg);
			
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
