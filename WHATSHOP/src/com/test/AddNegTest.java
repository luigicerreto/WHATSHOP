package com.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.connessione.Connessione;
import com.pannelloadmin.AddNegModel;

public class AddNegTest {
	
	private static AddNegModel neg;
	private static String nome;
	private static String email;
	private static String pIva;
	private static String citta;
	private static int cap;
	private static String indirizzo;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		neg = new AddNegModel();
		
		nome = "prova";
		email = "prova";
		pIva = "123";
		citta = "prova";
		cap = 123;
		indirizzo = "prova";
		
		neg.addNeg(nome, email, pIva, cap, citta, indirizzo);
		
		
		
		
		
	}



	@Test
	public void test() {
		
		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select nome,email,partita_iva,cap,citta,indirizzo FROM NEGOZIO_ONLINE where nome = ?";
		
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			assertEquals(rs.getString(1), nome);
			assertEquals(rs.getString(2), email);
			assertEquals(rs.getString(3), pIva);
			assertEquals(rs.getInt(4), cap);
			assertEquals(rs.getString(5), citta);
			assertEquals(rs.getString(6), indirizzo);


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
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "DELETE FROM NEGOZIO_ONLINE where nome = ?";
		
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			
			pstmt.executeUpdate();
			


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
