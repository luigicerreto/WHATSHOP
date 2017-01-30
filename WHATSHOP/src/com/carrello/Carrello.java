package com.carrello;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CarrelloBean;
import com.bean.ProdBean;
import com.bean.UserBean;


/**
 * Servlet implementation class Carrello
 */
@WebServlet("/Carrello")
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserBean connessione = new UserBean();
		CarrelloBean car = new CarrelloBean();

		
		String username = (String) request.getSession().getAttribute("nome");
		String json;
		if(username != null) {
			int idUtente = connessione.getIdUtente(username);
		
			json = "{\"stato\":\"ok\",\"prodotti\":\""+getProdotti(car.getCarrello(idUtente))+"\",\"carrello\":\""+ getCarrelloForJson(car.getCarrello(idUtente)) + "\"}";
			response.getWriter().write(json);

		} else {
			json = "{\"stato\":\"err\"}";
			response.getWriter().write(json);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
public String getCarrelloForJson(ArrayList arr){
        
   
        
        StringBuffer sb = new StringBuffer();
        
        
        for(int i = 0; i < arr.size(); i++){
          sb.append(arr.get(i));
          sb.append("-");
        }
        
        
        return sb.toString();

      }
public String getProdotti(ArrayList arr) {
	
	int idProd=0;
	ProdBean prod = new ProdBean();
	StringBuffer sb = new StringBuffer();
	ArrayList prodotto = new ArrayList();

	for(int i=0; i<arr.size();i=i+2) {
		
		idProd =(int) arr.get(i);
		
		prodotto = prod.getProdotto(idProd);
		
		for(int j=0; j<prodotto.size(); j++){
			sb.append(prodotto.get(j));
			sb.append("-");
		}
		
		
	}
	
	return sb.toString();
	

}

}

