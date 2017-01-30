<%@page import="com.sun.java.swing.plaf.windows.resources.windows, java.lang.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="javascript/aggiungiCarrello.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">
<% String nomeNegozio = (String) request.getAttribute("nomeNeg"); %>
<title>Whatshop | <%=nomeNegozio %></title>



<style>
input[type=submit].aggiungiCarrello {
    width: 45%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 23px;
    margin: 8px 15px;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    text-align: center;
}

input[type=text].aggiungiCarrello {
    width: 34%;
    padding: 12px 10px;
    margin: 4px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-sizing: border-box;
    background: white;
    color: black;
    text-align: center;
}


input[type=submit].aggiungiCarrello:hover {
    background-color: #45a049;
}


</style>


<style>
.alertOk {display:none;}
.alertEr {display: none;}
</style>

</head>
<body>
<div class="corpo">

 
<%

ArrayList<?> prodotti = new ArrayList<>();

prodotti = (ArrayList<?>) request.getAttribute("prodotti");



%>
<%@ include file="header.jsp" %> 


		<div class="prodottiNeg" id="prodotti">
		
		<%
		
		for(int i = 0; i < prodotti.size(); i=i+9){
		
		int idProd = (int) prodotti.get(i);
		String nomeProd = (String) prodotti.get(i+1);
		double prezzoProd =(double) prodotti.get(i+2);
		boolean dispProd =(boolean) prodotti.get(i+3);
		int qtProd =(int) prodotti.get(i+4);
		String imgProd =(String) prodotti.get(i+5);
		int idCat =(int) prodotti.get(i+6);
		int idNeg =(int) prodotti.get(i+7);
		String descProd =(String) prodotti.get(i+8);
		
		%>
			
			<div class=”prodotto” style="display:inline-block; border: 1px solid windowframe; width: 220px; height: 430px; margin: 30px; border-radius: 3px 3px 3px 3px;">

				<center>
					<a href="Prod?id-prodotto=<%=idProd%>"><img src="<%=imgProd%>" class="img-prodotto" height="200px" width="200px" style="padding-top: 10px;"></a>
				</center>

				<center>
					<input id="id-prodotto" name="id-prodotto" value="<%=idProd%>" readonly="text" style="width: 40%; border-style: none; margin: 0; text-align: center; background-color: white; color: black;\">
				</center>

				<h3 class="nome-prodotto" style="margin-left: 5px; height: 30px;"><%=nomeProd%></h3>

				<p class="descrizione-prodotto"
					style="margin-left: 5px; overflow-y: scroll; height: 60px;"><%=descProd%></p>

				<div class="aggiungiCarrelloDiv">
					<form action="javascript:aggiungi(<%=idProd%>)" method="get"
						class="aggiungiCarrelloForm">
						<input type="submit" class="aggiungiCarrello" value="Aggiungi">
						<input type="text" id="quantita" name="quantita" readonly="text"
							class="aggiungiCarrello" value="€ <%=prezzoProd %>">
					</form>
				</div>
			</div>
			<%} %>
			
			
		</div>
		

<a class="prodottiNeg" href="javascript:history.back()">Torna Indietro</a>





</div>



<div class="alertOk" id="alertOk"></div>
<div class="alertEr" id="alertEr"></div>
<%@ include file="footer.jsp" %> 

</body>
</html>