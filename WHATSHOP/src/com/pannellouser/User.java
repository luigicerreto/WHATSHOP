package com.pannellouser;

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
import com.bean.OrdineBean;
import com.bean.ProdBean;
import com.bean.UserBean;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usernameSes = (String) request.getSession().getAttribute("nome");
		String username = (String) request.getParameter("user");
		UserBean userBean = new UserBean();
		CategoriaBean cat = new CategoriaBean();
		
		
		if(usernameSes != null && username.equals(usernameSes)){
		
		
			
		
			NegozioBean connessione = new NegozioBean();
			OrdineBean ordine = new OrdineBean();
			ProdBean prod = new ProdBean();
		
			int idUser = userBean.getIdUtente(username);
			
		
			ArrayList user = new ArrayList();
		
			user = userBean.getUser(idUser);
			
			
			ArrayList categorie = new ArrayList();
			categorie = cat.selectCat();
			boolean esisteNeg = connessione.esisteNeg(idUser);
			
			if(esisteNeg){
				int idNeg = connessione.getIdNegUser(idUser);
				ArrayList prodotti = prod.importProdottiNegozio(idNeg);
				request.setAttribute("prodotti", prodotti);
				}
				
				
				
				
				
				request.setAttribute("esisteNeg", esisteNeg);
				request.setAttribute("categorie", categorie);
				request.setAttribute("user", user);

		
		
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			rd.forward(request, response);
			
			
		}
		else {
			response.sendRedirect("Home");
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
