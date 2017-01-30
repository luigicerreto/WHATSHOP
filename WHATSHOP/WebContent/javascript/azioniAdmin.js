function getXmlHttpRequest() {
	var xhr= false;
	var activeXoptions = new Array("Microsoft.XmlHttp", "MSXML4.XmlHttp", "MSXML3.XmlHttp", "MSXML2.XmlHttp", "MSXML.XmlHttp");
	
	try {
		xhr = new XMLHttpRequest();
	} catch(e) {
		
	}
	
	if(!xhr) {
		var created = false;
		for ( var i = 0; i< activeXoptions.length && !created; i++ ) {
			try {
				xhr = new ActiveXobject(activeXoptions[i]); 
				created = true;
			} catch(e) {
				
			}
		}
	}
	return xhr;
}



function delProd() {

	var x = document.getElementById("selProd");
    var i = x.selectedIndex;
    var idProd = x.options[i].text;
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "DelProd", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("idProdotto="+ idProd);
	
}

function promAdmin() {

	var x = document.getElementById("selUsers");
    var i = x.selectedIndex;
    var idUser = x.options[i].text;
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "PromoAdmin", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("idUser="+ idUser);
	
}

function remAdmin() {

	var x = document.getElementById("selUsersRem");
    var i = x.selectedIndex;
    var idUser = x.options[i].text;
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "RemAdmin", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("idUser="+ idUser);
	
}

function delUser() {

	var x = document.getElementById("selUsersBan");
    var i = x.selectedIndex;
    var idUser = x.options[i].text;
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "BanUser", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("idUserBan="+ idUser);
	
}

function modProd() {

	var x = document.getElementById("selProdMod");
    var i = x.selectedIndex;
    var idProd = x.options[i].text;
    var qtProd = document.getElementById("qtProdMod");
    var prezzoProd = document.getElementById("prezzoProdMod");
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "ModProdotto", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("idProdotto="+ idProd +"&qtProdMod="+qtProd.value+"&prezzoProdMod="+prezzoProd.value);
	
}

function delCat() {

	var x = document.getElementById("selCatDel");
    var i = x.selectedIndex;
    var nomeCat = x.options[i].text;
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "RimuoviCategoria", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("nomeCat="+ nomeCat);
	
}

function delNeg() {

	var x = document.getElementById("selDelNeg");
    var i = x.selectedIndex;
    var nomeNeg = x.options[i].text;
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "RimuoviNegozio", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			
			
			if(obj.stato = "ok"){
				location.reload();
			}
			else
				alert("Si sono verificati degli errori");
			
			
			
		}
	}
	
	xhr.send("nomeNeg="+ nomeNeg);
	
}