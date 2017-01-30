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

function cancella(idProd){
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "DeleteProdotto", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			var x = JSON.parse(xhr.responseText);
			
			
		}
	}
	
	xhr.send("idProd="+idProd);
	
}