<%@page import="com.sun.java.swing.plaf.windows.resources.windows, java.lang.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">
<%String username = (String) session.getAttribute("nome"); %>
<title>Whatshop | <%=username %></title>


<script src="javascript/cambiaPass.js"></script>
<script src="javascript/azioniAdmin.js"></script>


<style>
input[type=text].textProd {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    background: white;
    color: black;
}

input[type=password].textProd {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    background: white;
    color: black;
}

input[type=submit].textProd {
    width: 100%;
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


.

.mini-menu{display:none;}
.alertOk {display:none;}
.alertEr {display: none;}
</style>

</head>
<body>
<div class="corpo">


<%

ArrayList<?> user = new ArrayList<>();
ArrayList<?> categorie = new ArrayList<>();

categorie = (ArrayList<?>) request.getAttribute("categorie");


user = (ArrayList<?>) request.getAttribute("user");

ArrayList<?> prodotti = new ArrayList<>();
prodotti = (ArrayList<?>) request.getAttribute("prodotti");


String nomeNegUser = (String) request.getAttribute("nomeNegUser");
boolean esisteNeg = (boolean) request.getAttribute("esisteNeg");
	
%>

<%@ include file="header.jsp" %> 


<ul class="ul-admin">
  <li class="li-admin"><a href="#userPanel">Profilo Utente</a></li>
  <li class="li-admin"><a href="#userPanelNeg" >Amministra Negozio</a></li>
</ul>

<div class="tab">



	<div id="userPanel" class="select">	
	<form class="userPanelForm" action="javascript: cambiaPass()">

	<p><label for="username" id="usernameLabel">Username</label></p>
    <input type="text" id="username" name="username" class="textProd" readonly="readonly" value="<%=user.get(0)%>">
    
    <p><label for="Nome" id="nomeLabel">Nome</label></p>
    <input type="text" id="nome" name="nome" class="textProd" readonly="readonly" value="<%=user.get(4)%>">

    <p><label for="Cognome" id="cognomeLabel">Cognome</label></p>
    <input type="text" id="cognome" name="cognome" class="textProd" readonly="readonly" value="<%=user.get(3)%>">
    
    <p><label for="Citta" id="cittaLabel">Città</label></p>
    <input type="text" id="citta" name="citta" class="textProd" readonly="readonly" value="<%=user.get(7)%>">

    <p><label for="cap" id="capLabel">CAP</label></p>
    <input type="text" id="cap" name="cap" class="textProd" readonly="readonly" value="<%=user.get(6)%>">
	
	<p><label for="indirizzo" id="indirizzoLabel">Indirizzo</label></p>
    <input type="text" id="indirizzo" name="indirizzo" class="textProd" readonly="readonly" value="<%=user.get(8)%>">
    
    <%
    
    	String data = (String) user.get(5);
		String [] parts = data.split("-");
    
    %>
    
    <p><label for="data-nascita" id="dataLabel">Data di nascita (28/06/1995)</label></p>
    <input type="text" id="data-nascita" name="data-nascita" class="textProd" readonly="readonly" value="<%=parts[2]+"/"+parts[1]+"/"+parts[0]%>">

    <p><label for="email" id="emailLabel">Email</label></p>
    <input type="text" id="email" name="email" class="textProd" readonly="readonly" value="<%=user.get(2)%>">
    
    <p><label for="password" id="passLabel">Cambia Password (min 8 caratteri)</label></p>
    <input type="password" id="password" name="password" class="textProd">
  
    <input type="submit" value="Salva" class="textProd">
</form>

	</div>
	
	<div id="userPanelNeg" class="select">
	<% if(!esisteNeg) {%>
	<form class="addNegForm" action="AddNegUser" method="GET" >

	<h3>Aggiungi Negozio (Puoi creare un solo negozio)</h3>
	
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
    
    <input type="submit" class="textProd" value="Aggiungi">
    </form>

		<%}else{ %>
		
		<form class="addProdForm" action="AddProdUser" method="POST" enctype="multipart/form-data">

	<h3>Aggiungi Prodotto</h3>
	
	<p><label class="textProd" id="nomeProdLabel">Nome Prodotto</label></p>
    <input type="text" id="nomeProd" name="nomeProd" class="textProd">

   <p><label class="textProd"id="PrezzoLabel">Prezzo</label></p>
    <input type="text" id="prezzoProd" name="prezzoProd" class="textProd">
    
   <p> <label class="textProd" id="descProdLabel">Descrizione Prodotto</label></p>
    <input type="text" id="descProd" name="descProd" class="textProd">

   <p><label class="textProd" id="qtProdLabel">Quantita Prodotto</label></p>
    <input type="text" id="qtProd" name="qtProd" class="textProd">
       
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
	<input type="file" id="imgProd" name="imgProd" class="sel" accept="image/*" file-upload multiple>
  
    <input type="submit" value="Aggiungi" class="textProd">
    </form>
    
<form class="delProdForm" action="javascript: delProd()" method="POST">

	<h3>______________________________________________________</h3>
	<h3>Elimina Prodotto</h3>
	
 
    <p><label class="textProd" id="prodLabel">Prodotti</label></p>
    <select class="sel" id="selProd">
    <%for(int i=0; i<prodotti.size(); i=i+9){
    	
    		String prod = (String) prodotti.get(i+1);

    	
    %>
    
    <option id="opt" value="<%=prod%>"><%=prod%></option>
    
    <%}
    
    
    
    
    %>
</select>
<input type="submit" value="Rimuovi" class="textProd">
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
			<%} %>	


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