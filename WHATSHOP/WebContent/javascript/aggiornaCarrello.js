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

function aggiorna(idProd){
	
	var qtProd = document.getElementById(idProd);
	
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "AggiornaCarrello", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var obj = JSON.parse(xhr.responseText);
			if(obj.stato== "ok"){ 
			
				var al = document.getElementById("alertOk");
				al.innerHTML = "Quantita aggiornata"
				al.style.display = "block";
				setTimeout(disattivaOk, 2000);
				
			}
			else if(obj.stato=="err"){
				var al = document.getElementById("alertEr");
				al.innerHTML = "Non abbiamo questa disponibilità"
				al.style.display = "block";
				setTimeout(disattivaOk, 2000);
				
			}
			
			
			
		}
	}
	
	xhr.send("qtProd="+qtProd.value+"&idProd="+idProd);
	
}

function disattivaOk(){
	var al = document.getElementById("alertOk");
	al.style.display="none";
}

function disattivaEr(){
	var al = document.getElementById("alertEr");
	al.style.display="none";
}
