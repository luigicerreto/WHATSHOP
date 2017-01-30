package com.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.NegozioBean;
import com.bean.ProdBean;


/**
 * Servlet implementation class Negozio
 */
@WebServlet("/Negozio")
public class Negozio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Negozio() {
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
		
		String idNeg = request.getParameter("userId");
		
		
		
		int idNegInt = Integer.parseInt(idNeg);
		
		String nomeNeg = neg.getNeg(idNegInt);
		
		ArrayList prodotti = new ArrayList();
		
		prodotti = connessione.importProdottiNegozio(idNegInt);
		
		request.setAttribute("prodotti", prodotti);
		request.setAttribute("nomeNeg", nomeNeg);
		
		RequestDispatcher rd = request.getRequestDispatcher("negozio.jsp");
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
