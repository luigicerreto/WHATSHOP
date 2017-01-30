<%@page import="com.sun.java.swing.plaf.windows.resources.windows, java.lang.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<link href="css/style.css" rel="stylesheet" type="text/css" title="default">
<title>Insert title here</title>
<script src="javascript/menuSmall.js"></script>
<script>

function controllaIns(nickname) {
	
	var username = document.login.loginUser.value;
	var password = document.login.loginPass.value;
	
	if(username == "" && password =="") {
		alert("Username e Password non inseriti");
		return false;
	}
	
	else if(username == "" || password == "") {
		
		alert("Username o Password non inseriti")
		return false;
	}
	else {
		
		return true;
		
	}
	
}

</script>
</head>
<style>
.mySlides {display:none;}
.alertOk {display:none;}
.alertEr {display: none;}
.mini-menu{display:none;}
</style>
<body>
	<div class="corpo">


		<div class="nav" id="nav">
			<div class="nav-login">


				<%

String nome = (String) session.getAttribute("nome");

if(nome == null) {
	
%>
				<form name="login" method="post" action="login">

					<input id="loginUser" name="loginUser" type="text"
						placeholder="Username"> <input id="loginPass"
						name="loginPass" type="password" placeholder="Password">
					<li style="list-style: none; display: inline;"><input
						id="loginEntra" onclick="return controllaIns(this)" type="submit"
						value="Entra"> /</li>
					<li style="list-style: none; display: inline;"><input
						id="registraUser" name="registraUser" value="Registrati"
						type="button" onClick="document.location.href='register.jsp'"></li>

				</form>

				<%}
else {
	
%>

				<form name="login" action="Esci" method="get">
					Ciao <u><a href="User?user=<%=nome%>#userPanel"><%=nome %></a></u>
					<input value="Esci" type="submit">
				</form>

				<%} %>

			</div>

			<div class="nav-contenuto" id="nav-contenuto">

				<div class="menu-small" onclick="javascript:sposta()">

					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</div>

				<ul class="logo">
					<a href="index.jsp">Whatshop</a>
				</ul>
				<div class="menu">
					<li><a href="index.jsp">HOME</a></li>
					<li><a href="Negozi">NEGOZI</a></li>
					<li><a href="#">CONTATTI</a></li>
					<li><a href="#">FAQ</a></li>
					<%

String admin = (String) session.getAttribute("admin");

if(admin == "1") {
	
%>
					<li><a href="admin.jsp#gestProd">ADMIN</a></li>

					<%}
%>
				</div>
				<div class="carrello">
					<a href="carrello.jsp"><img alt="carrello" src="img/cart.png"
						height="22px" width="22px" hspace="30"></a>

				</div>



			</div>

		</div>

		<a href="#"><div class="mini-menu" id="mini-menu">
				<p class="menu-close">
					<a href="#" onclick="javascript:chiudi()">X</a>
				</p>
				<p class="menu-text">
					<a href="index.jsp">HOME</a>
				</p>
				<p class="menu-text">
					<a href="Negozi">NEGOZI</a>
				</p>
				<p class="menu-text">
					<a href="#">CONTATTI</a>
				</p>
				<p class="menu-text">
					<a href="#">FAQ</a>
				</p>

				<%
if(admin == "1") {
	
%>
				<p class="menu-text">
					<a href="admin.jsp#gestProd">ADMIN</a>
				</p>
				<%}
%>

			</div></a>