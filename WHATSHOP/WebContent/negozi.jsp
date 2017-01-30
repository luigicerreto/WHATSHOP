<%@page import="com.sun.java.swing.plaf.windows.resources.windows, java.lang.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">

<title>Whatshop | Negozi</title>





<style>
.alertOk {display:none;}
.alertEr {display: none;}
</style>

</head>
<body>
<div class="corpo">
		<%
		
		ArrayList<?> negozi = new ArrayList<>();
		negozi = (ArrayList<?>) request.getAttribute("negozi");
		
		ArrayList<?> numeroProd = new ArrayList<>();
		numeroProd = (ArrayList<?>) request.getAttribute("numeroProd");
		
		ArrayList<?> propNeg = new ArrayList<>();
		propNeg = (ArrayList<?>) request.getAttribute("propNeg");
		


	
%>

<%@ include file="header.jsp" %> 



<div class="listaNeg">
<%
int j=0;
String nomeProp;
for(int i=0; i<negozi.size(); i=i+7){ 
	
	if(propNeg.get(j).equals("0")){
		nomeProp = "easyShop";
	}
	else{
		nomeProp = (String)propNeg.get(j);
	}
%>
<div class="negozio" style="display:inline-block;">
<center><u><h2><a href="Negozio?userId=<%=negozi.get(i)%>"><%=negozi.get(i+1) %></a></h2></u></center>

<div class="infoNeg" style="padding-left: 2%;">
<p>Citta: <%=negozi.get(i+5) %></p>
<p>CAP: <%=negozi.get(i+4) %></p>
<p>Indirizzo: <%=negozi.get(i+6) %></p>
<p>P.Iva: <%=negozi.get(i+3) %></p>
<p>Email: <%=negozi.get(i+2) %></p>
<p>Prodotti in vendita: <%=numeroProd.get(j) %></p>
<p>Poprietario: <%=nomeProp %> </p>
</div>



</div>

<%
j++;
} %>
</div>





</div>



<div class="alertOk" id="alertOk"></div>
<div class="alertEr" id="alertEr"></div>
<%@ include file="footer.jsp" %> 

</body>
</html>