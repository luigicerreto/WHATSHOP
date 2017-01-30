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


function register() {
	
	var nome = document.getElementById("nome");
	var cognome = document.getElementById("cognome");
	var citta = document.getElementById("citta");
	var cap = document.getElementById("cap");
	var indirizzo = document.getElementById("indirizzo");
	var data_nascita = document.getElementById("data-nascita");
	var email = document.getElementById("email");
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	
	var data_nascita_split = data_nascita.value.split('/');
	
	
	if(nome.value == "") {
		
		
		nome.style.borderColor = "red";
		setTimeout("fineErr(nome)", 2000); 
	}
	
	if(cognome.value == "") {
		
		
		cognome.style.borderColor = "red";
		setTimeout("fineErr(cognome)", 2000); 
	}
	
	if(citta.value == "") {
		
		
		citta.style.borderColor = "red";
		setTimeout("fineErr(citta)", 2000); 
	}
	
	if(cap.value == "" || cap.value.length != 5) {
		
		
		cap.style.borderColor = "red";
		setTimeout("fineErr(cap)", 2000); 
	}
	
	if(indirizzo.value == "" || indirizzo.value.length < 5) {
		
		
		indirizzo.style.borderColor = "red";
		setTimeout("fineErr(indirizzo)", 2000); 
	}
	
	if(data_nascita.value == "" || data_nascita.value.length != 10 || data_nascita_split[0] < 0 || data_nascita_split[0] > 31 || data_nascita_split[1] < 0 || data_nascita_split[1] > 12 || data_nascita.value.slice(2,3) != "/" || data_nascita.value.slice(5,6) != "/") {
		
		
		data_nascita.style.borderColor = "red";
		setTimeout("fineErr(document.getElementById(\"data-nascita\"))", 2000); 
	}
	
	if(email.value == "" || email.value.indexOf("@") == -1 || email.value.length <= 8) {
		
		
		email.style.borderColor = "red";
		setTimeout("fineErr(email)", 2000); 
	}
	
	if(username.value == "" || username.value.length < 5) {
		
		
		username.style.borderColor = "red";
		setTimeout("fineErr(username)", 2000); 
	}
	
	if(password.value == "" || password.value.length < 8) {
		
		
		password.style.borderColor = "red";
		setTimeout("fineErr(password)", 2000); 
	}
	
	
	
	if(nome.value != "" && cognome.value != "" && citta.value != "" && cap.value != "" && cap.value.length == 5 && indirizzo.value != "" && indirizzo.value.length >= 5 && data_nascita.value != "" && data_nascita.value.length == 10 && data_nascita_split[0] >= 0 && data_nascita_split[0] <= 31 && data_nascita_split[1] > 0 && data_nascita_split[1] <= 12 && data_nascita.value.slice(2,3) == "/" && data_nascita.value.slice(5,6) == "/" && email.value != "" && email.value.indexOf("@") > -1 && email.value.length > 8 && username.value != "" && username.value.length >= 5 && password.value != "" && password.value.length >= 8) {
		
	
		var xhr = getXmlHttpRequest();

	
		xhr.open('POST', "Register", true);
	
		xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	
		xhr.onreadystatechange = function() {
		
		
		if(xhr.readyState == 4) {
			
			
			location.href = 'index.jsp';
		}
		}
	
	
	
	xhr.send("nome="+ nome.value +"&cognome="+ cognome.value+"&citta="+ citta.value+"&cap="+ cap.value+"&indirizzo="+ indirizzo.value+"&data-nascita="+ data_nascita.value+"&email="+ email.value+"&username="+ username.value+"&password="+ password.value);
	
	}
}

function fineErr(input) {
	input.style.borderColor = "#ccc";
}