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
import com.pannelloadmin.AddCatModel;

public class AddCatTest {
	
	private static AddCatModel addCat;
	private static String nome;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		addCat = new AddCatModel();
		
		nome= "prova";
		
		addCat.addCat(nome);
		
		
		
	}



	@Test
	public void test() {
		
		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select tipo_categoria FROM CATEGORIE WHERE tipo_categoria = ?";
		
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			assertEquals(rs.getString(1), nome);


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
			
			sql = "DELETE FROM CATEGORIE WHERE tipo_categoria = ?";
		
			
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
