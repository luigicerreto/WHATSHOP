package com.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accesso.RegisterModel;
import com.connessione.Connessione;

public class RegisterTest {
	
	private static RegisterModel reg;
	private static String username;
	private static String nome;
	private static String cognome;
	private static String data;
	private static String citta;
	private static String indirizzo;
	private static String email;
	private static String password;
	private static int cap;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		reg  = new RegisterModel();
		
		reg.register("prova", "prova", "1900-01-01", "citta", "indirizzo", 81024, "email", "user", "password");
		
		username = "user";
	}

	

	@Test
	public void test() {
		
		Connection con = null;
		try {
		con = Connessione.getConnessione();
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("Select nome,cognome,data,cap,email,password,citta,indirizzo from USERS where username=?");
		
		pstmt.setString(1, "user");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			nome = rs.getString(1);
			cognome = rs.getString(2);
			data = rs.getString(3);
			cap = rs.getInt(4);
			email = rs.getString(5);
			password = rs.getString(6);
			citta = rs.getString(7);
			indirizzo = rs.getString(8);
			
		}
		
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
		
		assertEquals(username, "user");
		assertEquals(password, "password");
		assertEquals(nome, "prova");
		assertEquals(cognome, "prova");
		assertEquals(data, "1900-01-01");
		assertEquals(email, "email");
		assertEquals(citta, "citta");
		assertEquals(cap, 81024);
		assertEquals(indirizzo, "indirizzo");
		


	
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		Connection con = null;
		try {
		con = Connessione.getConnessione();
		
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("DELETE FROM USERS where username = ?");
		
		pstmt.setString(1, "user");
		
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
