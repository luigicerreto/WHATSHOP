package com.pannelloadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connessione.Connessione;

public class RemAdminModel {
	
public boolean remAdmin(int idUser) {
		
		
		String sql = null;
		boolean bool = false;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			sql = "UPDATE USERS SET admin = 0 where id_user = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, idUser);
			
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
