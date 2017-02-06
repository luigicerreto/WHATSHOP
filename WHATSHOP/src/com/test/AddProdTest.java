package com.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bean.CategoriaBean;
import com.bean.NegozioBean;
import com.bean.ProdBean;
import com.connessione.Connessione;
import com.pannelloadmin.AddCatModel;
import com.pannelloadmin.AddNegModel;
import com.pannelloadmin.AddProdModel;

public class AddProdTest {
	
	private static AddProdModel prod;
	private static AddNegModel neg;
	private static AddCatModel cat;
	private static NegozioBean negBean;
	private static CategoriaBean catBean;
	private static String nome;
	private static double prezzo;
	private static boolean disp;
	private static int quantita;
	private static String link;
	private static String descrizione;
	private static int idNeg;
	private static int idCat;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		prod = new AddProdModel();
		neg = new AddNegModel();
		cat = new AddCatModel();
		catBean = new CategoriaBean();
		negBean = new NegozioBean();
		
		
		neg.addNeg("prova", "email","piva", 123, "citta", "indirizzo");
		cat.addCat("cat");
		
		idNeg = negBean.getIdNeg("prova");
		idCat = catBean.getIdCat("cat");
		
		
		nome = "prod";
		prezzo = 0;
		disp = true;
		quantita = 0;
		link = "link";
		descrizione = "desc";
		
		prod.addProd(nome, prezzo, disp, quantita, link, idCat, idNeg, descrizione);
		
		
		
		
		
		
		
	}


	@Test
	public void test() {
		String sql = null;
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
			sql = "Select nome,prezzo,disponibilita,quantita,link,descrizione FROM PRODOTTI WHERE nome = ?";
		
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			assertEquals(rs.getString(1), nome);
			assertEquals(rs.getInt(2), 0);
			assertEquals(rs.getBoolean(3), disp);
			assertEquals(rs.getInt(4), quantita);
			assertEquals(rs.getString(5), link);
			assertEquals(rs.getString(6), descrizione);


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
		
		Connection con = null;
		try {
			con = Connessione.getConnessione();
			
		
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("DELETE FROM NEGOZIO_ONLINE where id_negozio = ?");
			PreparedStatement pstmt2 = (PreparedStatement) con.prepareStatement("DELETE FROM CATEGORIE where id_categoria = ?");
			PreparedStatement pstmt3 = (PreparedStatement) con.prepareStatement("DELETE FROM PRODOTTI where nome = ?");

			idNeg = negBean.getIdNeg("prova");
			idCat = catBean.getIdCat("cat");
			
			pstmt.setInt(1, idNeg);
			pstmt2.setInt(1, idCat);
			pstmt3.setString(1, nome);
			
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();



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
