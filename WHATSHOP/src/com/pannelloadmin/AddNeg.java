package com.pannelloadmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddNeg
 */
@WebServlet("/AddNeg")
public class AddNeg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNeg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddNegModel connessione = new AddNegModel();
		
		String nomeNeg = (String) request.getParameter("nomeNeg");
		String emailNeg = (String) request.getParameter("emailNeg");
		String partitaIvaNeg = (String) request.getParameter("partitaIvaNeg");
		String capNeg = (String) request.getParameter("capNeg");
		String cittaNeg = (String) request.getParameter("cittaNeg");
		String indirizzoNeg = (String) request.getParameter("indirizzoNeg");
		
		int cap = Integer.parseInt(capNeg);
		
		
		
		if(connessione.addNeg(nomeNeg, emailNeg, partitaIvaNeg, cap, cittaNeg, indirizzoNeg)){
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
