package com.pannelloadmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.bean.CategoriaBean;
import com.bean.NegozioBean;
import com.bean.OrdineBean;
import com.bean.ProdBean;
import com.bean.UserBean;


/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ProdBean prod = new ProdBean();
		UserBean user = new UserBean();
		OrdineBean ord = new OrdineBean();
		NegozioBean neg = new NegozioBean();
		CategoriaBean cat = new CategoriaBean();
		
		ArrayList <Object> negozi = new ArrayList<Object>();
		ArrayList <Object>  ordini = new ArrayList <Object> ();
		
		ArrayList <Object>  categorie = new ArrayList<Object>();
		
		ArrayList <Object>  ordine = new ArrayList<Object>();
		ArrayList <Object> totale = new ArrayList<Object>();
		
		ArrayList<?> prodotti = prod.importProdotti();
		
		ArrayList<?> utenti = user.getUser();
		
		ordine = ord.getOrdine();
		totale = ord.getTotale(ordine);
		
		
		for(int i = 0; i<ordine.size(); i=i+2){
			
			ordini.add(ordine.get(i));
			
			int idUser = (int) ordine.get(i+1);
			
			
			String username = user.getUsername(idUser);
			
			ordini.add(username);
			
			
			
			
			
		}
		
		
		negozi = neg.selectNeg();
		categorie = cat.selectCat();
		
		
		
		request.setAttribute("prodotti", prodotti);
		request.setAttribute("negozi", negozi);
		request.setAttribute("categorie", categorie);
		request.setAttribute("utenti", utenti);
		request.setAttribute("ordini", ordini);
		request.setAttribute("totale", totale);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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
