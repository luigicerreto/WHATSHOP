package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connessione.Connessione;

public class CarrelloBean {
	
public ArrayList getCarrello(int userId) {
		
		ArrayList carrello = new ArrayList<>();
		Connection con=null;
		try {
			 con = Connessione.getConnessione();
			
			String sql = "Select  distinct PRODOTTI_id , quantita from CARRELLO where USER_id = ? ";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				carrello.add(rs.getInt(1));
				carrello.add(rs.getInt(2));
			}

			
			return carrello;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}

public void svuotaCarrello(int idUser)  {	
	

	String sql4 = null;

	Connection con = null;
	try {
		con = Connessione.getConnessione();
		
		sql4 = "DELETE FROM CARRELLO WHERE USER_id = ?";
		
		PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql4);
		
		pstmt4.setInt(1, idUser);

		
		pstmt4.executeUpdate();
		
		pstmt4.close();
		con.close();
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
