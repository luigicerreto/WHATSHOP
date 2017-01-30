package com.pannelloadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.NegozioBean;

/**
 * Servlet implementation class RimuoviNegozio
 */
@WebServlet("/RimuoviNegozio")
public class RimuoviNegozio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviNegozio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nomeNeg = request.getParameter("nomeNeg");
		String json;
		NegozioBean neg = new NegozioBean();
		
		int idNeg = neg.getIdNeg(nomeNeg);
		
		RimuoviNegozioModel rmNeg = new RimuoviNegozioModel();
		
		if(rmNeg.rimuoviNeg(idNeg)){
			json = "{\"stato\":\"ok\"}";
		}
		else{
			json = "{\"stato\":\"no\"}";
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
