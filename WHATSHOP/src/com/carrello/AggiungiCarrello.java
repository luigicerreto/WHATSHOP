package com.carrello;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProdBean;
import com.bean.UserBean;
import com.connessione.Connessione;



/**
 * Servlet implementation class AggiungiCarrello
 */
@WebServlet("/AggiungiCarrello")
public class AggiungiCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = null;
		UserBean user = new UserBean();
		
		if(request.getSession().getAttribute("nome") != null) {
			
			AggiungiCarrelloModel connessione = new AggiungiCarrelloModel();
			ProdBean prod = new ProdBean();
			int idUtente = user.getIdUtente((String) request.getSession().getAttribute("nome"));
			String idProdotto = (String) request.getParameter("idProdotto");
			int idProdottoInt = Integer.parseInt(idProdotto);
			
			if(prod.verificaDisponibilita(idProdottoInt)){
				if(connessione.addCarrello(idUtente, idProdottoInt, 1)) {
				
					json = "{\"stato\":\"ok\"}";
				}
				else {
					json = "{\"stato\":\"no\"}";
				}
			
			}
			else {
				json = "{\"stato\":\"noDisp\"}";
			}
		}
			
		else if(request.getSession().getAttribute("nome") == null){
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
