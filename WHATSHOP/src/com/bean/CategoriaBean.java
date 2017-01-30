package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connessione.Connessione;

public class CategoriaBean {

	public ArrayList selectCat()  {	
		

		String sql4 = null;
		

		ArrayList categorie = new ArrayList();
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql4 = "SELECT * from CATEGORIE";
			
			PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql4);
			

			ResultSet rs = pstmt4.executeQuery();
			
			while(rs.next()){
				
				categorie.add(rs.getString(1));
				categorie.add(rs.getInt(2));

				
			}
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
		
		return categorie;
		
	}
	
	public String getCat(int idCat)  {	
		

		String sql = null;
		String nome = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select tipo_categoria from CATEGORIE where id_categoria = ?";
			
			PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt4.setInt(1, idCat);

			
			ResultSet rs = pstmt4.executeQuery();

			rs.next();
			
			nome = rs.getString(1);
			
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
		return nome;
		
		
	}
	
public int getIdCat(String nome) {
		
	
		String sql = null;
		int id = 0;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select id_categoria from categorie where tipo_categoria = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			id = rs.getInt(1);
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
		return id;
		
}

public boolean delCat(int idCat){
	
	String sql = null;
	
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		
		sql = "DELETE from CATEGORIE where id_categoria = ?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, idCat);
		
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
