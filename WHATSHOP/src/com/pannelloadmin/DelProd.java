package com.pannelloadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProdBean;


/**
 * Servlet implementation class DelProd
 */
@WebServlet("/DelProd")
public class DelProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelProd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String json = null;
		
		DelProdModel connessione = new DelProdModel();
		ProdBean prod = new ProdBean();
		
		String nomeProd = request.getParameter("idProdotto");

		int idProd = prod.getIdProd(nomeProd);
		
		if(connessione.delProd(idProd)) {
			json = "{\"stato\":\"ok\"}";
		}
		else
			json = "{\"stato\":\"no\"}";
		
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
