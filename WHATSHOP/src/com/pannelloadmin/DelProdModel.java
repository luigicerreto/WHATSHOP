package com.pannelloadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class DelProdModel {
	
public boolean delProd(int idProd) {
		
		
		String sql = null;
		boolean bool = false;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			sql = "DELETE FROM prodotti where id_prodotti = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, idProd);
			
			bool = pstmt.execute();
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
		return bool;
		
}

}
