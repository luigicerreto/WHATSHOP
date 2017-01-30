package com.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.accesso.LoginModel;
import com.accesso.RegisterModel;
import com.connessione.Connessione;

public class LoginTest {

	private static LoginModel test;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 test = new LoginModel();
		 RegisterModel registra = new RegisterModel();
		 registra.register("prova", "prova", "1900-01-01", "citta", "indirizzo", 81024, "email", "user", "password");
	}



	@Test
	public void test() {
		
		assertEquals(true, test.login("user", "password"));
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
