package com.test;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bean.OrdineBean;
import com.carrello.PagamentoModel;
import com.connessione.Connessione;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoTest {
	
	

	private static PagamentoModel pagamento;
	private static OrdineBean ordine;
	private static String data;
	private static String scadenza;
	private static double prezzo;
	private static int ordineId;
	private static int userId;
	private static int cvv;
	private static int nCarta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		pagamento = new PagamentoModel();
		ordine = new OrdineBean();
		
		data = "2017-12-12 11:11:00.0";
		nCarta = 0000-1111-2222-3333;
		scadenza = "1900-12-12";
		userId = 1;
		ordineId = 1;
		cvv=123;
		prezzo = 0;
		
		
		ordine.creaOrdine(scadenza, userId);
		pagamento.Paga(prezzo, userId, ordineId, data, cvv, scadenza, nCarta);
		
		
		
		
	}



	@Test
	public void test() {
		
		Connection con = null;
		
		try {
			con = Connessione.getConnessione();
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("Select data,cvv2,scadenza_carta,numero_carta,totale,ORDINE_id,USER_id FROM PAGAMENTO WHERE totale = ?");

			
			
			
			
			pstmt.setDouble(1, prezzo);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			assertEquals(rs.getString(1), data);
			assertEquals(rs.getInt(2), cvv);
			assertEquals(rs.getString(3), scadenza);
			assertEquals(rs.getInt(4), nCarta);
			assertEquals(rs.getInt(5), 0);
			assertEquals(rs.getInt(6), ordineId);
			assertEquals(rs.getInt(7), userId);
			
			
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
			
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("DELETE FROM PAGAMENTO WHERE totale = ?");
			
			pstmt.setDouble(1, prezzo);
		
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
