package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.carrello.Prodotto;
import com.connessione.Connessione;

public class ProdBean {
	
public boolean verificaDisponibilita(int idProdotto)  {	
		

		String sql = null;
		boolean bool = false;
		
		Connection con = null;
		

		
		try {
			con = Connessione.getConnessione();
			sql = "SELECT quantita FROM PRODOTTI WHERE id_prodotti = ?";
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, idProdotto);
			
			ResultSet rs = pstmt.executeQuery();
			

				rs.next();

				if(rs.getInt(1) > 0) {
					
					
					bool = true;

				}
				else {
					bool = false;
				}
				
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

public ArrayList getProdotto(int idProd) {
	
	ArrayList prodotto = new ArrayList<>();
	
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		
		String sql = "SELECT nome,prezzo,disponibilita,quantita,link,descrizione,CATEGORIA_id,NEGOZIO_id from PRODOTTI where id_prodotti = ?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		
		pstmt.setInt(1, idProd);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			prodotto.add(rs.getString(1));
			prodotto.add(rs.getDouble(2));
			prodotto.add(rs.getBoolean(3));
			prodotto.add(rs.getInt(4));
			prodotto.add(rs.getString(5));
			prodotto.add(rs.getString(6));
			prodotto.add(rs.getInt(7));
			prodotto.add(rs.getInt(8));
		}
		pstmt.close();
		return prodotto;
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

public void cancellaProdotto(int idProdotto)  {	
	
	
	String sql = null;
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		sql = "DELETE FROM CARRELLO WHERE PRODOTTI_id = ?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, idProdotto);
		
		pstmt.executeUpdate();
		
		pstmt.close();
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


public ArrayList<Prodotto> importProdottiNegozio(int negozioId) {
	
	ArrayList prodotti = new ArrayList();
	Connection con = null;
	
	
	try {
		con = Connessione.getConnessione();
		
		String sql = "SELECT * from PRODOTTI where NEGOZIO_id = ?";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, negozioId);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			prodotti.add(rs.getInt(1));
			prodotti.add(rs.getString(2));
			prodotti.add(rs.getDouble(3));
			prodotti.add(rs.getBoolean(4));
			prodotti.add(rs.getInt(5));
			prodotti.add(rs.getString(6));
			prodotti.add(rs.getInt(7));
			prodotti.add(rs.getInt(8));
			prodotti.add(rs.getString(9));
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
	return prodotti;
}

public ArrayList<Prodotto> importProdotti() {
	
	ArrayList prodotti = new ArrayList();
	Connection con = null;
	
	
	try {
		con = Connessione.getConnessione();
		
		String sql = "SELECT * from PRODOTTI";
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			prodotti.add(rs.getInt(1));
			prodotti.add(rs.getString(2));
			prodotti.add(rs.getDouble(3));
			prodotti.add(rs.getBoolean(4));
			prodotti.add(rs.getInt(5));
			prodotti.add(rs.getString(6));
			prodotti.add(rs.getInt(7));
			prodotti.add(rs.getInt(8));
			prodotti.add(rs.getString(9));
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
	
	return prodotti;
}

public int getIdProd(String nome) {
	

	String sql = null;
	int id = 0;
	Connection con = null;
	try {
		con = Connessione.getConnessione();
		sql = "Select id_prodotti from prodotti where nome = ?";
		
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

public boolean scalaQt(int qtAcq, int idProd){
	String sql = null;
	Connection con = null;
	
	try {
		con = Connessione.getConnessione();
		
		sql = "Select quantita from PRODOTTI where id_prodotti = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setInt(1, idProd);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		int qntProd = rs.getInt(1);

		
		if(qntProd >= qtAcq){
			
			sql = "UPDATE PRODOTTI SET quantita = ? where id_prodotti = ?";
			PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement(sql);
			int newQt = qntProd - qtAcq;
			pstmt2.setInt(1, newQt);
			pstmt2.setInt(2, idProd);
			
			pstmt2.executeUpdate();
			return true;
		}
		else{
			return false;
		}
		
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

public int getQt(int idProd){
	String sql = null;
	Connection con = null;
	int qntProd=0;

		try {
			con = Connessione.getConnessione();
			
			sql = "Select quantita from PRODOTTI where id_prodotti = ?";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setInt(1, idProd);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			qntProd = rs.getInt(1);
			
			
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
		
		return qntProd;
}

}
