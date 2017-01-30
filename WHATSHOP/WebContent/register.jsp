<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" title="default">

<title>Whatshop | Registrati</title>

<script src="javascript/slide.js"></script>
<script src="javascript/registerCheck.js"></script>



<style>
input[type=text].textReg {
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

input[type=password].textReg {
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

.textReg[type=submit].textReg {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit].textReg:hover {
    background-color: #45a049;
}

</style>
</head>
<style>
.mySlides {display:none;}
.alertOk {display:none;}
.alertEr {display: none;}
.mini-menu{display:none;}
</style>
<body onload="slideShow();">
<div class="corpo">


<%@ include file="header.jsp" %> 

<div class="slideshow"> 

<img src="img/banner.png" class="mySlides"  name="mySlides" style=" height: 400px; width: 100%;">
<img src="img/banner1.png" class="mySlides"  name="mySlides" style=" height: 400px; width: 100%;">


</div>

<div class="registerDiv">
<form class="registerForm" action="javascript:register()">

	<label for="nome" id="nomeLabel">Nome</label>
    <input type="text" id="nome" name="nome" class="textReg">

    <label for="Cognome" id="cognomeLabel">Cognome</label>
    <input type="text" id="cognome" name="cognome" class="textReg">
    
    <label for="Citta" id="cittaLabel">Città</label>
    <input type="text" id="citta" name="citta" class="textReg">

    <label for="cap" id="capLabel">CAP</label>
    <input type="text" id="cap" name="cap" class="textReg">
	
	<label for="indirizzo" id="indirizzoLabel">Indirizzo</label>
    <input type="text" id="indirizzo" name="indirizzo" class="textReg">
    
    <label for="data-nascita" id="dataLabel">Data di nascita (28/06/1995)</label>
    <input type="text" id="data-nascita" name="data-nascita" class="textReg">

    <label for="email" id="emailLabel">Email</label>
    <input type="text" id="email" name="email" class="textReg">

    <label for="username" id="userLabel">Username</label>
    <input type="text" id="username" name="username" class="textReg">
    
    <label for="password" id="passLabel">Password (min 8 caratteri)</label>
    <input type="password" id="password" name="password" class="textReg">
  
    <input type="submit" value="Registrati" class="textReg">
</form>
</div>








</div>


<%@ include file="footer.jsp" %> 

</body>
</html>