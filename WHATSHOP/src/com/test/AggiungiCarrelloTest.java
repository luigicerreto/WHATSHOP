package com.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.carrello.AggiungiCarrelloModel;
import com.connessione.Connessione;

public class AggiungiCarrelloTest {
	
	private static AggiungiCarrelloModel test;
	
	private static int idUser = 1;
	private static int idProd = 1;
	private static int qt = 1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		test = new AggiungiCarrelloModel();
		
		
		
		test.addCarrello(idUser, idProd, qt);
	}



	@Test
	public void test() {
		Connection con = null;
		try {
		con = Connessione.getConnessione();
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("Select * from CARRELLO where USER_id = ? and PRODOTTI_id = ? and quantita = ?");
		
		pstmt.setInt(1, idUser);
		pstmt.setInt(2, idProd);
		pstmt.setInt(3, qt);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		assertEquals(rs.getInt(1), idUser);
		assertEquals(rs.getInt(1), idProd);
		assertEquals(rs.getInt(1), qt);

		
		}catch (SQLException e) {
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
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Connection con = null;
		try {
		con = Connessione.getConnessione();
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("DELETE FROM CARRELLO where USER_id= ?");
	
		pstmt.setInt(1, idUser);
		
		pstmt.executeUpdate();

		
		}catch (SQLException e) {
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
