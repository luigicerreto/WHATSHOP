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

function getCarrello() {
	
	var xhr = getXmlHttpRequest();
	
	xhr.open('POST', "Carrello", true);
	
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

	xhr.onreadystatechange = function() {
		
		
		
		
		if(xhr.readyState == 4) {
			
			
			
			var x = JSON.parse(xhr.responseText);
			
			if(x.stato == "ok"){
				var arr = x.carrello;
				var arr2 = x.prodotti;
				
				var carrello = arr.split("-");
				var prodotti = arr2.split("-");
				
				
			
				var len = 0;
				var j;

				for (j in carrello) {
					if (carrello.hasOwnProperty(j)) {
						len++;
					}
				}
				
				if((len-1) > 0) {
			
					var divCarr = document.getElementById("listaCarrello");
					var prezzo = 0;
					
					for(var i=0; i< len-1; i=i+2) {
				
					
						var divCarr = document.getElementById("listaCarrello");
				
						var idProd = carrello[i];
						var qtProd = carrello[i+1];
					
						var nomeProd = prodotti[0];
						var prezzoProd = prodotti[1];
						var dispProd = prodotti[2];
						var qtMaxProd = prodotti[3];
						var immProd = prodotti[4];						
						var descProd = prodotti[5];
						var idCat = prodotti[6];
						var idNeg = prodotti[7];
					
						var totale = qtProd * prezzoProd;
						
						totale = parseFloat(totale).toFixed(2);
						
						
						prezzo = (qtProd * prezzoProd) + prezzo;
				
						var para = document.createElement("div");
						
				
						para.innerHTML = "<div class=\"divCarr\" id=\"divCarr\">" +
									"<a href=\"\" style=\"color: black;\"><div class=\"cancProd\" id=\"cancProd\" onclick=\"javascript:cancella("+idProd+")\">X</div></a>" +
									"<img src=\""+immProd+"\" height=\"150px\" width=\"150px\" style=\"margin-top: 0px; margin-left: 10px;\">" +
									"<div class=\"infoCarr\">" +
									"<li><h3>"+nomeProd+"</h1></li>" +
									"<li style=\"overflow-y: auto; height: 20px;\">"+descProd+"</li>" +
									"<form class=\"formCarr\" name=\"formCarr\" method=\"POST\" onsubmit=\" javascript:aggiorna("+idProd+")\">" +
									"<span><input type=\"text\" class=\"textProd2\" id=\"prezzoProd\" readonly=\"readonly\" value =\"€"+prezzoProd+"\" ></span>" +
									"<span><input type=\"text\" class=\"textProd2\" id=\""+idProd+"\" value =\""+qtProd+"\"></span>" +
									"<span><input type=\"submit\" class=\"aggiorna\" value=\"Aggiorna\"></span>" +
									"<span>Totale: <input type=\"text\" class=\"textProd2\" id=\"prezzoTot\" readonly=\"readonly\" value =\""+totale+"\" ></span> " +
									"</form>" +
									"</div>" +
									"</div>";
				
						divCarr.appendChild(para);
						
						
						
						prodotti.splice(0, 8);


						
					
					
					}
					prezzo = parseFloat(prezzo).toFixed(2);
					var totale =  document.getElementById("totale")
					
					totale.innerHTML = "Totale da pagare = <input type=\"text\" class=\"textProd2\" id=\"prezzo\" readonly=\"readonly\" value =\""+prezzo+"\" >";
					
				}else{
					var divCarr2 = document.getElementById("listaCarrello");
					var para2 = document.createElement("div");
					var checkout = document.getElementById("checkout");
					
					checkout.style.display = "none";
				
					para2.innerHTML = "<span>CARRELLO VUOTO</span>";
					
					divCarr2.style.marginLeft = "13%";
					
					divCarr2.appendChild(para2);
				}
				
			
			}
			
			else if(x.stato == "err") {
				
				window.location.href = 'register.jsp';
			}
			
		}
	}
	
	xhr.send();
	
}

