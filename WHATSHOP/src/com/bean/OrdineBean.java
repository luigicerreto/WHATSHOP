package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connessione.Connessione;

public class OrdineBean {
	
	public void creaOrdine(String data, int userId)  {	
		

		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "INSERT into ORDINE (data, USER_id) values (?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, data);
			pstmt.setInt(2, userId);
			
			pstmt.executeUpdate();
			
			pstmt.close();
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
	
	public ArrayList getOrdine() {
		

		String sql = null;
		ArrayList ordine = new ArrayList();
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "Select distinct ORDINE_id, USER_id from EFFETTUA_USERS ";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

			
			
			ResultSet rs = pstmt.executeQuery();
			

			
			while(rs.next()){
				
				
				ordine.add(rs.getInt(1));
				ordine.add(rs.getInt(2));
				
				

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
		
	return ordine;
	
	}
public ArrayList getOrdine(int idUser) {
		

		String sql = null;
		ArrayList ordine = new ArrayList();
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "Select distinct ORDINE_id from EFFETTUA_USERS where USER_ID = ? ";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

			pstmt.setInt(1, idUser);
			
			ResultSet rs = pstmt.executeQuery();
			

			
			while(rs.next()){
				
				
				ordine.add(rs.getInt(1));
				
				

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
		
	return ordine;
	
	}
	
	public ArrayList getTotale(ArrayList a) {
		
		String sql = null;
		ArrayList totale = new ArrayList();
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			
			sql = "Select totale from PAGAMENTO where ORDINE_id = ? and USER_id = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

			
			
			
			

			
			for(int i=0; i < a.size(); i=i+2){
				
				pstmt.setInt(1, (int) a.get(i));
				pstmt.setInt(2, (int) a.get(i+1));
				
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
				
				totale.add(rs.getDouble(1));
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
		return totale;
	}

}
