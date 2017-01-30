package com.pannellouser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class AddNegUserModel {
	
	public boolean addNeg(String nome, String email, String partitaIva, int cap, String citta, String indirizzo) {
		
	
		String sql = null;
		boolean bool = true;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "insert into NEGOZIO_ONLINE(nome,email,partita_iva,cap,citta,indirizzo) value (?,?,?,?,?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			pstmt.setString(2, email);
			pstmt.setString(3, partitaIva);
			pstmt.setInt(4, cap);
			pstmt.setString(5, citta);
			pstmt.setString(6, indirizzo);
			

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
