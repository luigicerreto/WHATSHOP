package com.carrello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connessione.Connessione;

public class AggiungiCarrelloModel {
	
public boolean addCarrello(int idUser , int idProdotto, int qtProdotto) {
		
		Connection con = null;
		boolean x = false;

		
		try {
			con = Connessione.getConnessione();
			
			String sql = "INSERT into CARRELLO values (?,?,?)";
			String sql2 = "Select * from CARRELLO WHERE PRODOTTI_id = ? and USER_id = ?";
			
			PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement(sql2);
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt2.setInt(1, idProdotto);
			pstmt2.setInt(2, idUser);
			
			ResultSet rs = pstmt2.executeQuery();
			
			rs.next();
			
			
			
			if(rs.getRow() < 1) {
			
				pstmt.setInt(1, idUser);
				pstmt.setInt(2, idProdotto);
				pstmt.setInt(3, qtProdotto);
				pstmt.executeUpdate();
				x = true;
			}
			
			else {
				x = false;
			}
			pstmt2.close();
			pstmt.close();

			
			return x;
		
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
