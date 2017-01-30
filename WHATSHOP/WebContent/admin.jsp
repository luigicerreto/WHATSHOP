<%@page import="com.sun.java.swing.plaf.windows.resources.windows, java.lang.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">

<title>Whatshop | Admin Panel</title>


<script src="javascript/azioniAdmin.js"></script>



<style>
input[type=text].textProd {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    background: white;
    color: black;
}


input[type=submit].textProd {
    width: 50%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit].textProd:hover {
    background-color: #45a049;
}

.sel {
	width: 50%;
}
.

.mini-menu{display:none;}
.alertOk {display:none;}
.alertEr {display: none;}
</style>

</head>
<body>
<div class="corpo">
<%
if(request.getSession().getAttribute("admin") != "1"){
	response.sendRedirect("index.jsp");
}

ArrayList<?> negozi = new ArrayList<>();
ArrayList<?> categorie = new ArrayList<>();
ArrayList<?> prodotti = new ArrayList<>();
ArrayList<?> utenti = new ArrayList<>();
ArrayList<?> ordini = new ArrayList<>();
ArrayList<?> totale = new ArrayList<>();

negozi = (ArrayList<?>) request.getAttribute("negozi");
categorie = (ArrayList<?>) request.getAttribute("categorie");
prodotti = (ArrayList<?>) request.getAttribute("prodotti");
utenti = (ArrayList<?>) request.getAttribute("utenti");
ordini = (ArrayList<?>) request.getAttribute("ordini");
totale = (ArrayList<?>) request.getAttribute("totale");

if(negozi == null || categorie == null || prodotti == null){
	response.sendRedirect("Admin");
	return;}

	
%>

<%@ include file="header.jsp" %> 



<ul class="ul-admin">
  <li class="li-admin"><a href="#gestProd">Gestione Prodotti</a></li>
  <li class="li-admin"><a href="#promAdmin" >Promuovi Admin</a></li>
  <li class="li-admin"><a href="#banUser">Banna Utente</a></li>
  <li class="li-admin"><a href="#ordini">Ordini</a></li>
  <li class="li-admin"><a href="#categorie">Categorie</a></li>
  <li class="li-admin"><a href="#negozi">Negozi</a></li>
</ul>


<div class="tab">

<div id="gestProd" class="select">

<form class="addProdForm" action="AddProd" method="POST" enctype="multipart/form-data">

	<h3>Aggiungi Prodotto</h3>
	
	<p><label class="textProd" id="nomeProdLabel">Nome Prodotto</label></p>
    <input type="text" id="nomeProd" name="nomeProd" class="textProd">

   <p><label class="textProd"id="PrezzoLabel">Prezzo</label></p>
    <input type="text" id="prezzoProd" name="prezzoProd" class="textProd">
    
   <p> <label class="textProd" id="descProdLabel">Descrizione Prodotto</label></p>
    <input type="text" id="descProd" name="descProd" class="textProd">

   <p><label class="textProd" id="qtProdLabel">Quantita Prodotto</label></p>
    <input type="text" id="qtProd" name="qtProd" class="textProd">
    
    <p><label class="textProd" id="nomeNeg">Negozio</label></p>
    <select class="sel" id="selNeg" name="selNeg">
    <%     

    for(int i=0; i< negozi.size(); i=i+7) {
		
    	int idNeg =(int) negozi.get(i);
		String nomeNeg =(String) negozi.get(i+1);
		String emailNeg =(String) negozi.get(i+2);
		String ivaNeg =(String) negozi.get(i+3);
		int capNeg =(int) negozi.get(i+4);
		String cittaNeg =(String) negozi.get(i+5);
		String indNeg =(String) negozi.get(i+6);
		
		
%>
<option id= "<%=idNeg%>" value="<%=nomeNeg%>"><%=nomeNeg%></option>
<%		
	}
 %>
 </select>   
    
    
    <p><label class="textProd" id="catNeg">Categorie</label></p>
    <select class="sel" id="selCat" name="selCat">
<%
	for(int k = 0; k < categorie.size(); k = k+2 ){
		
		String nomeCat = (String) categorie.get(k);
		int idCat = (int) categorie.get(k+1);
	
%>
	<option id="<%=idCat %>" value="<%=nomeCat%>"><%=nomeCat%></option>
	
<%	
	
	}
%>
    
    </select>
    
    <p><label class="textProd" id="immProdLabel">Immagine</label></p>
	<p><input type="file" id="imgProd" name="imgProd" class="sel" accept="image/*" file-upload multiple></p>
  
    <p><input type="submit" value="Aggiungi" class="textProd"></p>
</form>




<form class="delProdForm" action="javascript: delProd()" method="POST">

	<h3>______________________________________________________</h3>
	<h3>Elimina Prodotto</h3>
	
 
    <p><label class="textProd" id="prodLabel">Prodotti</label></p>
    <select class="sel" id="selProd">
<%
	for(int j = 0; j < prodotti.size(); j = j+9 ){
		
		int idProd = (int) prodotti.get(j);
		String nomeProd = (String) prodotti.get(j+1);
		double prezzoProd =(double) prodotti.get(j+2);
		boolean dispProd =(boolean) prodotti.get(j+3);
		int qtProd =(int) prodotti.get(j+4);
		String imgProd =(String) prodotti.get(j+5);
		int idCat =(int) prodotti.get(j+6);
		int idNeg =(int) prodotti.get(j+7);
		String descProd =(String) prodotti.get(j+8);
	
%>
	<option id ="opt" value="<%=nomeProd%>"><%=nomeProd%></option>
	
<%	
	
	}
%>
	</select>

  
    <p><input type="submit" value="Elimina" class="textProd"></p>
</form>
<form class="ModProdForm" action="javascript: modProd()" method="POST" >
	
	
	<h3>______________________________________________________</h3>
	<h3>Modifica Prodotto</h3>
	<p><label class="textProd" id="prodLabel">Prodotti</label></p>
	<select class="sel" id="selProdMod">
    <%for(int i=0; i<prodotti.size(); i=i+9){
    	
    		String prod = (String) prodotti.get(i+1);

    	
    %>
    
    <option id="opt" value="<%=prod%>"><%=prod%></option>
    
    <%}
    
    
    
    
    %>
</select>
	
	<p><label class="textProd" id="nomeNegLabel">Quantita</label></p>
    <input type="text" id="qtProdMod" name="qtProdMod" class="textProd">
    
    <p><label class="textProd" id="emailNegLabel">Prezzo</label></p>
    <input type="text" id="prezzoProdMod" name="prezzoProdMod" class="textProd">
		<input type="submit" value="Modifica" class="textProd">
		</form>


</div>


<div id="promAdmin" class="select">
  
  <form class="addAdmin" action="javascript: promAdmin()" method="POST">

	<h3>Promuovi Amministratore</h3>
	
 
    <p><label class="textProd" id="usersLabel">Utenti</label></p>
    <select class="sel" id="selUsers">
    <%for(int i=0; i<utenti.size(); i++){
    	
    		String user = (String) utenti.get(i);
    		
    		if(!user.equals(nome)) {
    	
    %>
    
    <option id="<%=user%>" value="<%=user%>"><%=user%></option>
    
    <%}
    } 
    
    
    
    
    %>
</select>



  
    <p><input type="submit" value="Promuovi" class="textProd"></p>
</form>

<form class="addAdmin" action="javascript: remAdmin()" method="POST">

	<h3>______________________________________________________</h3>
	<h3>Rimuovi Amministratore</h3>
	
 
    <p><label class="textProd" id="usersLabel">Utenti</label></p>
    <select class="sel" id="selUsersRem">
    <%for(int i=0; i<utenti.size(); i++){
    	
    		String user = (String) utenti.get(i);
    		
    		if(!user.equals(nome)) {
    	
    %>
    
    <option id="<%=user%>" value="<%=user%>"><%=user%></option>
    
    <%}
    } 
    
    
    
    
    %>
</select>
<input type="submit" value="Retrocedi" class="textProd">
</form>

</div>

<div id="banUser" class="select">
 
  <form class="banUser" action="javascript: delUser()" method="POST">

	<h3>Banna Utente</h3>
	
 
    <p><label class="textProd" id="usersLabel">Utenti</label></p>
    <select class="sel" id="selUsersBan">
    <%for(int i=0; i<utenti.size(); i++){
    	
    	String user = (String) utenti.get(i);
    	
    	if(!user.equals(nome)) {
    %>
    
    <option id="<%=user%>" value="<%=user%>"><%=user%></option>
    
    <%} 
    }
    
    
    
    %>
    
    
    </select>

  
   <p> <input type="submit" value="BANNA!" class="textProd"></p>
</form>

</div>

<div id="ordini" class="select">

<table>
  <tr>
    <th>USERNAME</th>
    <th>ID ORDINE</th>
    <th>TOTALE</th>
  </tr>
  <% int j=0; %>
  <%for(int i=0; i< ordini.size(); i=i+2){%>

  <tr>
    <td><%=ordini.get(i+1) %></td>
    <td><%= ordini.get(i) %></td> 
    <td><%=totale.get(j) %> €</td>
     <% 
     j++;
     }%>
  </tr>
</table>


</div>

<div id="categorie" class="select">
	<form class="addCatForm" action="AddCat" method="GET" >

	<h3>Aggiungi Categoria</h3>
	
	<p><label class="textProd" id="nomeCatLabel">Nome Categoria</label></p>
    <input type="text" id="nomeCat" name="nomeCat" class="textProd">
    
    <p><input type="submit" class="textProd" value="Aggiungi"></p>
    
    
    
    </form>
 
  <form class="banUser" action="javascript: delCat()" method="POST">
  
	<h3>______________________________________________________</h3>
	<h3>Rimuovi Categoria</h3>
	
 
    <p><label class="textProd" id="usersLabel">Categorie</label></p>
    <select class="sel" id="selCatDel">
    <%for(int i=0; i<categorie.size(); i=i+2){
    	
    	String categorieStr = (String) categorie.get(i);
    	
    %>
    
    <option id="<%=categorieStr%>" value="<%=categorieStr%>"><%=categorieStr%></option>
    
    <%
    }
    
    
    
    %>
    
    
    </select>

  
   <p> <input type="submit" value="Rimuovi" class="textProd"></p>
</form>
</div>

<div id="negozi" class="select">
	<form class="addNegForm" action="AddNeg" method="GET" >

	<h3>Aggiungi Negozio</h3>
	
	<p><label class="textProd" id="nomeNegLabel">Nome Negozio</label></p>
    <input type="text" id="nomeNeg" name="nomeNeg" class="textProd">
    
    <p><label class="textProd" id="emailNegLabel">Email Negozio</label></p>
    <input type="text" id="emailNeg" name="emailNeg" class="textProd">
    
    <p><label class="textProd" id="partitaIvaNegLabel">Partita Iva Negozio</label></p>
    <input type="text" id="partitaIvaNeg" name="partitaIvaNeg" class="textProd">
    
    <p><label class="textProd" id="capNegLabel">CAP Negozio</label></p>
    <input type="text" id="capNeg" name="capNeg" class="textProd">
    
    <p><label class="textProd" id="cittaNegLabel">Citta Negozio</label></p>
    <input type="text" id="cittaNeg" name="cittaNeg" class="textProd">
    
    <p><label class="textProd" id="indirizzoNegLabel">Indirizzo Negozio</label></p>
    <input type="text" id="indirizzoNeg" name="indirizzoNeg" class="textProd">
    
    <p><input type="submit" class="textProd" value="Aggiungi"></p>
    </form>
    
    <form class="banUser" action="javascript: delNeg()" method="POST">
  
	<h3>______________________________________________________</h3>
	<h3>Rimuovi Negozio</h3>
	
 
    <p><label class="textProd" id="usersLabel">Negozi</label></p>
    <select class="sel" id="selDelNeg">
    <%for(int i=0; i<negozi.size(); i=i+7){
    	
    	String negozioStr = (String) negozi.get(i+1);
    	
    %>
    
    <option id="<%=negozioStr%>" value="<%=negozioStr%>"><%=negozioStr%></option>
    
    <%
    }
    
    
    
    %>
    
    
    </select>

  
   <p> <input type="submit" value="Rimuovi" class="textProd"></p>
</form>
</div>
</div>

</div>
<%

String msg = (String) request.getAttribute("msg");

if(msg == "error"){
%>
<p class="err-admin">Si sono riscontrati degli errori !</p>
<%
}
else if(msg == "ok"){
%>
<p class="ok-admin">Azione effettuata correttamente !</p>
<%
} %>



</div>



<div class="alertOk" id="alertOk"></div>
<div class="alertEr" id="alertEr"></div>
<%@ include file="footer.jsp" %> 

</body>
</html>