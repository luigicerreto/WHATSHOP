<%@page import="com.sun.java.swing.plaf.windows.resources.windows, java.lang.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">

<%ArrayList<?> prodotto = new ArrayList<>();

prodotto = (ArrayList<?>) request.getAttribute("prodotto"); %>

<title>Whatshop | <%=prodotto.get(0) %></title>


<script src="javascript/aggiungiCarrello.js"></script>


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
    width: 20%;
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


String nomeCat = (String) request.getAttribute("categoria");
String nomeNeg = (String) request.getAttribute("negozio");
int idProd = (int) request.getAttribute("idProd");
int qt = (int) prodotto.get(3);
	
%>

<%@ include file="header.jsp" %> 

<div class="prodSel">


<center><p style="font-size: 25px;"><%=prodotto.get(0)%></p></center>
<p>
<img alt="<%=prodotto.get(0) %>" src="<%=prodotto.get(4)%>" height="200px" width="200px" style="border: 1px solid #dddddd; padding: 5px 5px 5px 5px; margin-left: 20px; display: inline;">


<div class="infoProd">


<p><label>Negozio: <%=nomeNeg %></label></p>
<p><label>Categoria: <%=nomeCat %></label></p>
<p><label>ID Prodotto: #<%=idProd %></label></p>
<p><label>Prezzo: € <%=prodotto.get(1)%></label></p>
<p><label>Displonibilità: <%if(qt>0){%>Disponibile<%}else{ %>Non Disponibile<%} %></label></p>
<p><label>Quantità: <%=prodotto.get(3)%></label></p>

</div>
<div style="margin-left: 3%; margin-top: 5%;">


<p>Descrizione:</p>
<p><%=prodotto.get(5) %></p>

<p>
<form action="javascript:aggiungi(<%=idProd%>)" method="get"><input type="submit" class="textProd" value="Aggiungi"></form>

</p>

</div>

</p>

</div>
<a class="prodottiNeg" href="javascript:history.back()">Torna Indietro</a>







</div>



<div class="alertOk" id="alertOk"></div>
<div class="alertEr" id="alertEr"></div>
<%@ include file="footer.jsp" %> 

</body>
</html>