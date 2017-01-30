package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connessione.Connessione;

public class AdminBean {
	
	public boolean verificaAdmin(int id) {
		

		boolean bool;
		String sql = "SELECT * from USERS where id_user = ? and admin = 1";
		
		PreparedStatement pstmt;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			
			if(rs.getRow()>0) {
				
				bool = true;
			}
			else
				bool= false;
			
			pstmt.close();
			con.close();
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
