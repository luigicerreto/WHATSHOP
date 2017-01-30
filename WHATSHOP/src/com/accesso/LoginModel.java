package com.accesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connessione.Connessione;

public class LoginModel {
	
	public boolean login(String username, String password) {
		

		boolean bool;
		String sql = "SELECT username,password FROM USERS WHERE username = ? AND password = ?";
		Connection con = null;
		PreparedStatement pstmt;
		try {
			con = Connessione.getConnessione();
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			

				rs.next();
				
				if(rs.getRow()>0) {
					
					
					bool = true;

				}
				else {
					bool = false;
				}

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
