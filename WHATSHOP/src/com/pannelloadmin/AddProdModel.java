package com.pannelloadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class AddProdModel {
	
	public void addProd(String nome, double prezzo, boolean disponibilita, int quantita, String link, int categoria_id, int negozio_id, String descrizione)  {	
		

		String sql = null;	
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "INSERT into PRODOTTI(nome,prezzo,disponibilita,quantita,link,CATEGORIA_id,NEGOZIO_id,descrizione) value (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			pstmt.setDouble(2, prezzo);
			pstmt.setBoolean(3, disponibilita);
			pstmt.setInt(4, quantita);
			pstmt.setString(5, link);
			pstmt.setInt(6, categoria_id);
			pstmt.setInt(7, negozio_id);
			pstmt.setString(8, descrizione);
			
			pstmt.execute();
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
