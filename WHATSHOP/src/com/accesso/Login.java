package com.accesso;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.bean.UserBean;


/**
 * Servlet implementation class Login
 */
@WebServlet(name = "/Login", urlPatterns={"/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		LoginModel connessione = new LoginModel();
		UserBean user = new UserBean();
		AdminBean admin = new AdminBean();
		
		String username = request.getParameter("loginUser");
		boolean bool = connessione.login(username, request.getParameter("loginPass"));
		
		if(bool){
			int id = user.getIdUtente(username);
			if(admin.verificaAdmin(id)) {
				request.getSession().setAttribute("admin", "1");
			}
			request.getSession().setAttribute("nome", username);	

			response.sendRedirect("index.jsp");
		}
		else{
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
