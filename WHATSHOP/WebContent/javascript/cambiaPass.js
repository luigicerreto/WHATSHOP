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


function cambiaPass(){
	
	var password = document.getElementById("password");
	var user = document.getElementById("username");
	
	
	if(password.value == "" || password.value.length < 8) {
		
		
			password.style.borderColor = "red";
			setTimeout("fineErr(password)", 2000); 
		}
	
	var xhr = getXmlHttpRequest();

	if(password.value != "" || password.value.length >= 8) {
		xhr.open('POST', "CambiaPass", true);

		xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

		xhr.onreadystatechange = function() {
	
	
			if(xhr.readyState == 4) {
				var ok = document.getElementById("alertOk");
				var err = document.getElementById("alertEr");
				var obj = JSON.parse(xhr.responseText);
				
				if(obj.stato== "ok"){ 
				
					
					ok.innerHTML = "Password Cambiata";
					ok.style.display = "block";
					setTimeout(disattivaOk, 3000);
					
				}else if(obj.stato=="err") {

					err.innerHTML = "Errore";
					err.style.display = "block";
					setTimeout(disattivaEr, 3000);
				}else if(obj.stato=="noLog") {
					
					err.innerHTML = "Effettua Login";
					err.style.display = "block";
					setTimeout(disattivaEr, 3000);
				}
				
			}
		}
	}



	xhr.send("password="+ password.value + "&username="+user.value);
	
	
}
function fineErr(input) {
	input.style.borderColor = "#ccc";
}
function disattivaOk(){
	var al = document.getElementById("alertOk");
	al.style.display="none";
}

function disattivaEr(){
	var al = document.getElementById("alertEr");
	al.style.display="none";
}