package com.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoriaBean;
import com.bean.NegozioBean;
import com.bean.ProdBean;


/**
 * Servlet implementation class Prod
 */
@WebServlet(name = "/Prod", urlPatterns={"/Prod"})
public class Prod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		ProdBean connessione = new ProdBean();
		NegozioBean neg = new NegozioBean();
		CategoriaBean cat = new CategoriaBean();
		
		String idProd = request.getParameter("id-prodotto");
		
		int idProdInt = Integer.parseInt(idProd);
		
		ArrayList prodotto = connessione.getProdotto(idProdInt);
		
		int idCat = (int) prodotto.get(6);
		int idNeg = (int) prodotto.get(7);
		
		
		String nomeCat = cat.getCat(idCat);
		String nomeNeg = neg.getNeg(idNeg);
		
		request.setAttribute("prodotto", prodotto);
		request.setAttribute("categoria", nomeCat);
		request.setAttribute("negozio", nomeNeg);
		request.setAttribute("idProd", idProdInt);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("prod.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
