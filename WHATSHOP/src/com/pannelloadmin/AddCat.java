package com.pannelloadmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddCat
 */
@WebServlet("/AddCat")
public class AddCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddCatModel connessione = new AddCatModel();
		
		String nomeCat = (String) request.getParameter("nomeCat");
		
		if(connessione.addCat(nomeCat) && nomeCat != null){
			request.setAttribute("msg", "ok");
			RequestDispatcher rd = request.getRequestDispatcher("Admin");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg", "error");
			RequestDispatcher rd = request.getRequestDispatcher("Admin");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
