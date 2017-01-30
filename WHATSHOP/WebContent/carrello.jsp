<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">

<title>Whatshop | Carrello</title>

<script src="javascript/importCarrello.js"></script>
<script src="javascript/aggiornaCarrello.js"></script>
<script src="javascript/deleteProdotto.js"></script>
<script src="javascript/checkout.js"></script>


<style>
input[type=submit].aggiorna {
    width: 30%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 11px;
    margin: 8px 15px;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    text-align: center;
}

input[type=text].textProd2 {
    width: 30%;
    padding: 12px 15px;
    margin: 4px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-sizing: border-box;
    background: white;
    color: black;
    text-align: center;
}


input[type=submit].aggiorna:hover {
    background-color: #45a049;
}

input[type=text].paga {
    width: 95%;
    padding: 12px 20px;
    margin: 9px 8px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    background: white;
    color: black;
}


.paga[type=submit].paga {
    width: 95%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 8px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit].paga:hover {
    background-color: #45a049;
}


</style>
<style>
.mini-menu{display:none;}
.loader{display:none;}
.alertOk {display:none;}
.alertEr {display: none;}
</style>

</head>
<body onload="getCarrello();">
<div class="corpo">


<div class="nav">
<div class="nav-login"> 


<%@ include file="header.jsp" %> 

<div class="listaCarrello" id="listaCarrello">

</div>

<div class="checkout" id="checkout">

<form action="">
<div class="totale"> <label id="totale"></label></div>
<div class="box">
	<a class="button" href="#popup1">Conferma Ordine</a>
</div></form>
</div>


<div id="popup1" class="overlay">
	<div class="popup">
		<h2 id="pagaText">Effettua Pagamento</h2>
		<a class="close" href="#">&times;</a>
		<div class="loader" id="loader"></div>
		<div class="content" id="content">
	<form class="PagaForm" action="javascript:pagamento()">

	<label for="NumeroCarta">Numero Carta (1111-2222-3333-4444)</label>
    <input type="text" id="nCarta" name="nCarta" class="paga">

    <label for="ScadenzaCarta">Scadenza Carta (28/06/1995)</label>
    <input type="text" id="scadenzaCarta" name="scadenzaCarta" class="paga">
    
    <label for="CVV2">CVV2 (123)</label>
    <input type="text" id="cvv2" name="cvv2" class="paga">
    
  
    <input type="submit" value="Paga" class="paga">
	</form>

		</div>
	</div>
</div>

</div>
<div class="alertOk" id="alertOk"></div>
<div class="alertEr" id="alertEr"></div>

<%@ include file="footer.jsp" %> 



</body>
</html>