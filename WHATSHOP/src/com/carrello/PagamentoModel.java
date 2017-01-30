package com.carrello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class PagamentoModel {
	
	public boolean Paga(double prezzo, int userId, int ordineId, String data, int cvv2, String scadenzaCarta, long nCarta)  {	
		

		String sql = null;
		
		boolean bool = false;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "INSERT into PAGAMENTO(data,cvv2,scadenza_carta,numero_carta,totale,ORDINE_id,USER_id) value (?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, data);
			pstmt.setInt(2, cvv2);
			pstmt.setString(3, scadenzaCarta);
			pstmt.setLong(4, nCarta);
			pstmt.setDouble(5, prezzo);
			pstmt.setInt(6, ordineId);
			pstmt.setInt(7, userId);
			
			if(pstmt.executeUpdate() > 0) bool = true;
			else bool= false;
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
