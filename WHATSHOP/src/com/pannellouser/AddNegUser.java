package com.pannellouser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.NegozioBean;
import com.bean.UserBean;


/**
 * Servlet implementation class AddNegUser
 */
@WebServlet("/AddNegUser")
public class AddNegUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNegUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernameSes = (String) request.getSession().getAttribute("nome");
		
		if(usernameSes!= null){
		
		NegozioBean connessione = new NegozioBean();
		AddNegUserModel add = new AddNegUserModel();
		UserBean user = new UserBean();
		
		String nomeNeg = (String) request.getParameter("nomeNeg");
		String emailNeg = (String) request.getParameter("emailNeg");
		String partitaIvaNeg = (String) request.getParameter("partitaIvaNeg");
		String capNeg = (String) request.getParameter("capNeg");
		String cittaNeg = (String) request.getParameter("cittaNeg");
		String indirizzoNeg = (String) request.getParameter("indirizzoNeg");
		
		
		
		int cap = Integer.parseInt(capNeg);
		
		add.addNeg(nomeNeg, emailNeg, partitaIvaNeg, cap, cittaNeg, indirizzoNeg);
		
		String username = (String) request.getSession().getAttribute("nome");
		
		int idUser = user.getIdUtente(username);
		
		connessione.addNegUser(idUser);
		

		response.sendRedirect("User?user="+username+"#userPanelNeg");

	}
	else {
		response.sendRedirect("index.jsp");
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
