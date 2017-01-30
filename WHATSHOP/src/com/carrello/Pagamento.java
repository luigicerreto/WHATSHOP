package com.carrello;


import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CarrelloBean;
import com.bean.NegozioBean;
import com.bean.OrdineBean;
import com.bean.ProdBean;
import com.bean.UserBean;

/**
 * Servlet implementation class Pagamento
 */
@WebServlet("/Pagamento")
public class Pagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = (String) request.getSession().getAttribute("nome");
		String json;
		UserBean user = new UserBean();

		if(username != null) {

			
			CarrelloBean carr = new CarrelloBean();
			Calendar cal = Calendar.getInstance();
			int userId = user.getIdUtente(username);

			ArrayList carrello = new ArrayList();
			ArrayList<Integer> idNegProd = new ArrayList();

			carrello = carr.getCarrello(userId);

			idNegProd = getIdNegProd(carrello);

			negVeng(idNegProd);

			int gg = cal.get(Calendar.DATE);

			int mm = cal.get(Calendar.MONTH) + 1;

			int aa = cal.get(Calendar.YEAR);

			int ora=cal.get(Calendar.HOUR_OF_DAY);

			int minuti = cal.get(Calendar.MINUTE);

			int sec = cal.get(Calendar.SECOND);

			String dataCorrente = ""+aa+"-"+mm+"-"+gg+" "+ora+":"+minuti+":"+sec;
			String data = ""+aa+"-"+mm+"-"+gg;



			String prezzo = request.getParameter("prezzo");
			Double prezzoInt = Double.parseDouble(prezzo);

			String cvv2 = request.getParameter("cvv2");
			int cvv2Int = Integer.parseInt(cvv2);

			String[] scadenza = request.getParameter("scadenzaCarta").split("/");
			String scadenzaCarta = scadenza[2] +"-"+ scadenza[1]+"-" + scadenza[0];

			String[] numCarta = request.getParameter("nCarta").split("-");

			long nCarta = Long.parseLong(numCarta[0]+""+numCarta[1]+""+numCarta[2]+""+numCarta[3]);
			
			


			
			ProdBean connessione = new ProdBean();

			for(int i=0; i<carrello.size();i=i+2) {

				int idProd =(int) carrello.get(i);
				int qtAcq = (int) carrello.get(i+1);
				
				int qtProd = connessione.getQt(idProd);
				
				
				connessione.scalaQt(qtAcq, idProd);

			}
			
			creaOrdine(userId, dataCorrente);

			int ordineId = effettuaUser(dataCorrente, userId, idNegProd);
			Paga(prezzoInt, userId, ordineId, dataCorrente, cvv2Int, scadenzaCarta, nCarta);

			
			carr.svuotaCarrello(userId);
			
			
			json = "{\"stato\":\"ok\"}";
		
		}
		
		
		
		else {
			
			json = "{\"stato\":\"err\"}";
			
		}

		response.getWriter().write(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public ArrayList getIdNegProd(ArrayList arr) {

		int idProd=0;
		NegozioBean connessione2 = new NegozioBean();
		ArrayList<Integer> idNeg = new ArrayList<>();


		for(int i=0; i<arr.size();i=i+2) {

			idProd =(int) arr.get(i);
			idNeg.add(connessione2.getIdNegozio(idProd));
			idNeg.add(idProd);



		}

		return idNeg;


	}
	

	public void negVeng(ArrayList<Integer> arr) {

		NegozioBean connessione = new NegozioBean();

		for(int i=0; i< arr.size(); i=i+2){
			connessione.negVende(arr.get(i+1), arr.get(i));
		}

	}

	public void creaOrdine (int idUser, String data) {

		OrdineBean connessione = new OrdineBean();

		connessione.creaOrdine(data, idUser);

	}

	public int effettuaUser (String data, int userId, ArrayList<Integer> arr){

		UserBean connessione = new UserBean();
		int ordineId=0;
		for(int i=0; i< arr.size(); i=i+2){
			ordineId = connessione.effettuaUser(data, userId, arr.get(i+1));
		}
		return ordineId;
	}

	public boolean Paga(double prezzo, int userId, int ordineId, String data, int cvv2, String scadenzaCarta, long nCarta){

		PagamentoModel connessione = new PagamentoModel();


		return connessione.Paga(prezzo, userId, ordineId, data, cvv2, scadenzaCarta, nCarta);

	}

}
