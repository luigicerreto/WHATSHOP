package com.pannellouser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;


/**
 * Servlet implementation class CambiaPass
 */
@WebServlet("/CambiaPass")
public class CambiaPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernameSes = (String) request.getSession().getAttribute("nome");
		String json;
		UserBean user = new UserBean();
		CambiaPassModel cambia = new CambiaPassModel();
		
			if(usernameSes != null){
				String password = request.getParameter("password");
				String username = request.getParameter("username");
				

		
				int idUser = user.getIdUtente(username);
		
				if(cambia.cambiaPass(password, idUser)){
					json = "{\"stato\":\"ok\"}";
				}
				else {
					json = "{\"stato\":\"err\"}";
				}
			}
			else{
				json = "{\"stato\":\"noLog\"}";
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
