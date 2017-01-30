/**
 * 	
 */

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


var idProdotto;
function aggiungi(idProdotto) {
	
	var xhr = getXmlHttpRequest();
	xhr.open('POST', "AggiungiCarrello", true);
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	
	xhr.onreadystatechange = function() {
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			if(obj.stato== "ok"){ 
			
				var al = document.getElementById("alertOk");
				al.innerHTML = "Oggetto aggiunto al carrello!"
				al.style.display = "block";
				setTimeout(disattivaOk, 2000);
				
			}
			else if(obj.stato=="noLog") {
				var al = document.getElementById("alertEr");
				al.innerHTML = "Effettua il Login"
				al.style.display = "block";
				setTimeout(disattivaEr, 3000);
			}
			
			else if(obj.stato=="no") {
				var al = document.getElementById("alertEr");
				al.innerHTML = "Prodotto gia presente"
				al.style.display = "block";
				setTimeout(disattivaEr, 3000);
			}
			
			else if(obj.stato=="noDisp") {
				var al = document.getElementById("alertEr");
				al.innerHTML = "Prodotto non disponibile"
				al.style.display = "block";
				setTimeout(disattivaEr, 3000);
			}
			
		}
	}
	
	xhr.send("idProdotto="+ idProdotto);
	
	

}

function disattivaOk(){
	var al = document.getElementById("alertOk");
	al.style.display="none";
}

function disattivaEr(){
	var al = document.getElementById("alertEr");
	al.style.display="none";
}

