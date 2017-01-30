package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connessione.Connessione;

public class NegozioBean {
	
	public int getIdNegozio(int idProd) {
		

		
		int idNeg;

		Connection con= null;
		try {
			con = Connessione.getConnessione();
			
			String sql = "SELECT NEGOZIO_id from PRODOTTI where id_prodotti = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			
			pstmt.setInt(1, idProd);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			idNeg = rs.getInt(1);
			
			pstmt.close();
			con.close();
			return idNeg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Integer) null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void negVende(int idProd, int idNeg)  {	
		

		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "INSERT into VENDE value (?,?)";
			
			PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt4.setInt(1, idProd);
			pstmt4.setInt(2, idNeg);
			
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
	
	public ArrayList selectNeg()  {	
		

		String sql4 = null;
		

		ArrayList negozi = new ArrayList();
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql4 = "SELECT * from NEGOZIO_ONLINE";
			
			PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql4);
			

			ResultSet rs = pstmt4.executeQuery();
			
			while(rs.next()){
				
				negozi.add(rs.getInt(1));
				negozi.add(rs.getString(2));
				negozi.add(rs.getString(3));
				negozi.add(rs.getString(4));
				negozi.add(rs.getInt(5));
				negozi.add(rs.getString(6));
				negozi.add(rs.getString(7));
				
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
		
		return negozi;
	}
	
	public String getNeg(int idNeg)  {	
		

		String sql = null;
		String nome = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select nome from NEGOZIO_ONLINE where id_negozio = ?";
			
			PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt4.setInt(1, idNeg);
			

			
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
	
	public ArrayList getNegozi()  {	
		

		String sql = null;
		
		
		ArrayList negozi = new ArrayList();
		Connection con = null;
	
		try {
			con = Connessione.getConnessione();
			sql = "SELECT * from NEGOZIO_ONLINE";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				negozi.add(rs.getInt(1));
				negozi.add(rs.getString(2));
				negozi.add(rs.getString(3));
				negozi.add(rs.getString(4));
				negozi.add(rs.getInt(5));
				negozi.add(rs.getString(6));
				negozi.add(rs.getString(7));
			
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
		return negozi;
		
	}
	
	public int getNumProdNeg(int idNeg)  {	
		

		String sql = null;
		int numeroProd = 0;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "SELECT COUNT(id_prodotti) FROM PRODOTTI where NEGOZIO_id= ?";
			
			PreparedStatement pstmt4 = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt4.setInt(1, idNeg);
			

			
			ResultSet rs = pstmt4.executeQuery();

			rs.next();
			
			numeroProd = (int) rs.getInt(1);
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
		return numeroProd;
		
	}
	
	public int getPropretarioNeg(int idNeg) {
		
	
		String sql = null;
		int id = 0;
		Connection con = null;

		try {
			con = Connessione.getConnessione();
			
			sql = "Select USER_id from NEGOZIO_USER where NEGOZIO_id = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, idNeg);
			
			
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
			else{
				id= 0;
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
		return id;
	}
	
	public int getIdNegUser(int id_user) {
		
	
		String sql = null;
		int idNeg = 0;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			sql = "Select NEGOZIO_id FROM NEGOZIO_USER where USER_id = ?";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, id_user);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			idNeg = rs.getInt(1);
			
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
		
		return idNeg;
	}
	
	public boolean addNegUser(int id_user) {
		

		String sql = null;
		String sql2 = null;
		int id_negozio = 0;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			sql = "Select id_negozio from NEGOZIO_ONLINE";
			sql2 = "insert into NEGOZIO_USER value (?,?)";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement(sql2);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				if(rs.isLast()){
					id_negozio = rs.getInt(1);
				}
				
			}
			
			pstmt2.setInt(1, id_negozio);
			pstmt2.setInt(2, id_user);
			pstmt2.executeUpdate();
			
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
	
public int getIdNeg(String nome) {
		
		
		String sql = null;
		int id = 0;
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			sql = "Select id_negozio from NEGOZIO_ONLINE where nome = ?";
			
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


public boolean esisteNeg(int id_user) {
	

	String sql = null;
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		sql = "Select * FROM NEGOZIO_USER where USER_id = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, id_user);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			return true;
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
	return false;
}
}
