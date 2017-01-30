package com.pannelloadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoriaBean;

/**
 * Servlet implementation class RimuoviCategoria
 */
@WebServlet("/RimuoviCategoria")
public class RimuoviCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nomeCat = request.getParameter("nomeCat");
		
		String json;
		CategoriaBean categorie = new CategoriaBean();
		
		int idCat =  categorie.getIdCat(nomeCat);
		
		if(categorie.delCat(idCat)){
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
