package com.pannelloadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;


/**
 * Servlet implementation class RemAdmin
 */
@WebServlet("/RemAdmin")
public class RemAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RemAdminModel connessione = new RemAdminModel();
		String json = null;
		String username = request.getParameter("idUser");
		UserBean user = new UserBean();
		
		
		int idUser = user.getIdUtente(username);
		
		if(connessione.remAdmin(idUser)){
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
