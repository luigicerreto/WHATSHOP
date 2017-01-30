package com.home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.NegozioBean;
import com.bean.UserBean;


/**
 * Servlet implementation class Negozi
 */
@WebServlet("/Negozi")
public class Negozi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Negozi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean connessione = new UserBean();
		
		NegozioBean neg = new NegozioBean();
		ArrayList negozi = neg.getNegozi();
		ArrayList numeroProd = new ArrayList();
		ArrayList propNegId = new ArrayList();
		ArrayList propNegNome = new ArrayList();
		int num;
		
		for(int i=0; i< negozi.size(); i=i+7){
			num = neg.getNumProdNeg((int) negozi.get(i));
			numeroProd.add(num);
			int idUserNeg = neg.getPropretarioNeg((int) negozi.get(i));
			propNegId.add(idUserNeg);
		}
		
		for(int j=0; j< propNegId.size(); j++){
			String nome;
			if((int) propNegId.get(j) != 0){
				nome = connessione.getUsername((int) propNegId.get(j));
				
				propNegNome.add(nome);
			}
			if((int) propNegId.get(j) == 0){
				propNegNome.add("0");
			}
			
		}
		
		
		request.setAttribute("propNeg", propNegNome);
		request.setAttribute("negozi", negozi);
		request.setAttribute("numeroProd", numeroProd);
		
		RequestDispatcher rd = request.getRequestDispatcher("negozi.jsp");
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
