package com.carrello;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.bean.ProdBean;
import com.bean.UserBean;
import com.connessione.Connessione;

/**
 * Servlet implementation class AggiornaCarrello
 */
@WebServlet("/AggiornaCarrello")
public class AggiornaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiornaCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String qtProd = request.getParameter("qtProd");
		String userId =(String) request.getSession().getAttribute("nome");
		String idProd = request.getParameter("idProd");
		String json;
		UserBean user = new UserBean();
		ProdBean prod = new ProdBean();
		try{
			
			int qtIntProd = Integer.parseInt(qtProd);
			
			int idIntProd = Integer.parseInt(idProd);
			
			ArrayList prodotto = new ArrayList();
			
			prodotto = prod.getProdotto(idIntProd);
			
			int qtProdDisp = (int) prodotto.get(3);
			
			if (qtIntProd > 0 && qtProdDisp >= qtIntProd) {
			
				AggiornaCarrelloModel connessione = new AggiornaCarrelloModel();

				int userIntId = user.getIdUtente(userId);

				connessione.modCarrello(qtIntProd, userIntId, idIntProd);

				json = "{\"stato\":\"ok\"}";
			}
			
			else{
				json = "{\"stato\":\"err\"}";
			}
		
		}
		catch(NumberFormatException e) {
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

}
