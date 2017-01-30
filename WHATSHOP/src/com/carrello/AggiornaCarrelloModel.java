package com.carrello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class AggiornaCarrelloModel {
	
public boolean modCarrello(int qtProd, int userId , int idProd) {
		

		boolean bool = false;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			String sql = "UPDATE CARRELLO set quantita = ? where USER_id= ? and PRODOTTI_id=?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, qtProd);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, idProd);
			
			pstmt.executeUpdate();
			
			bool = true;
			pstmt.close();

			return bool;
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
