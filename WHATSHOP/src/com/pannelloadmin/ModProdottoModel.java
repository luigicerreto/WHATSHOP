package com.pannelloadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class ModProdottoModel {
	
	public boolean modProd(int idProd, int qtProd, double prezzoProd){
		
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			String sql = "UPDATE PRODOTTI SET prezzo = ? , quantita = ? where id_prodotti = ?";
			
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setDouble(1, prezzoProd);
			pstmt.setInt(2, qtProd);
			pstmt.setInt(3, idProd);

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
