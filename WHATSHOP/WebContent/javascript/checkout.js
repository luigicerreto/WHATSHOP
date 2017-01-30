

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




function pagamento() {
	
	
var xhr = getXmlHttpRequest();

	var prezzo = document.getElementById("prezzo").value;
	var nCarta = document.getElementById("nCarta");
	var scadenzaCarta = document.getElementById("scadenzaCarta");
	var cvv2 = document.getElementById("cvv2");
	
	var nCarta_split = nCarta.value.split("-");
	var scadenzaCarta_split = scadenzaCarta.value.split("/");
	
	
	if(nCarta.value == "" || nCarta_split[0].length < 4 || nCarta_split[0].length > 4 || nCarta_split[1].length < 4 || nCarta_split[1].length > 4 || nCarta_split[2].length < 4 || nCarta_split[2].length > 4 || nCarta_split[3].length < 4 || nCarta_split[3].length > 4 || nCarta.value.slice(4,5) != "-" || nCarta.value.slice(9,10) != "-" || nCarta.value.slice(14,15) != "-" || nCarta.value.length != 19) {

		
		nCarta.style.borderColor = "red";
		setTimeout("fineErr(nCarta)", 2000);
	}
	
	if(scadenzaCarta.value == "" || scadenzaCarta_split[0] < 0 || scadenzaCarta_split[0] > 31 || scadenzaCarta_split[1] < 0 || scadenzaCarta_split[1] > 12 || scadenzaCarta.value.slice(2,3) != "/" || scadenzaCarta.value.slice(5,6) != "/" || scadenzaCarta.value.length != 10) {
		
		
		scadenzaCarta.style.borderColor = "red";
		setTimeout("fineErr(scadenzaCarta)", 2000);
	}
	
	if(cvv2.value == "" || cvv2.value.length != 3) {

		
		cvv2.style.borderColor = "red";
		setTimeout("fineErr(cvv2)", 2000);
	}
	
	
	if(nCarta.value != "" && scadenzaCarta.value != "" && cvv2.value != "" && nCarta_split[0].length == 4 && nCarta_split[1].length == 4 && nCarta_split[2].length == 4 && nCarta_split[3].length == 4 && nCarta.value.slice(4,5) == "-" && nCarta.value.slice(9,10) == "-" && nCarta.value.slice(14,15) == "-" && scadenzaCarta_split[0] > 0 && scadenzaCarta_split[0] <= 31 && scadenzaCarta_split[1] > 0 && scadenzaCarta_split[1] <= 12 && scadenzaCarta.value.slice(2,3) == "/" && scadenzaCarta.value.slice(5,6) == "/" && nCarta.value.length == 19 && scadenzaCarta.value.length == 10 && cvv2.value.length == 3){
	
		xhr.open('POST', "Pagamento", true);
	
		xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

		xhr.onreadystatechange = function() {
		
			if(xhr.readyState == 4) {
		
				var obj = JSON.parse(xhr.responseText);
			

			
			
			
				if(obj.stato =="ok") {
					
					var content = document.getElementById("content");
					
					content.style.display = "none";
			
					var pagaText = document.getElementById("pagaText");
					pagaText.style.display= "none";
					
					var loader = document.getElementById("loader");
					loader.style.display = "block";
					
					window.setTimeout("pagEff()", 3000);
				}
				else if(obj.stato =="err"){
					
					var al = document.getElementById("alertEr");
					al.innerHTML = "Effettua il Login"
					al.style.display = "block";
					setTimeout(disattivaEr, 3000);
				}
				else if(obj.stato =="noQt"){
					
					var al = document.getElementById("alertEr");
					al.innerHTML = "Non abbiamo tutta questa disponibilità"
					al.style.display = "block";
					setTimeout(disattivaEr, 3000);
				}
		
			}
		}


	xhr.send("prezzo="+ prezzo+"&nCarta="+ nCarta.value +"&scadenzaCarta="+ scadenzaCarta.value +"&cvv2="+ cvv2.value);
	}
	
}


function pagEff() {
	
	var loader = document.getElementById("loader");
	loader.style.display = "none";
	
	var pagaText = document.getElementById("pagaText");
	pagaText.style.display= "block";
	pagaText.innerHTML = "Pagamento Effettuato";
	
	window.setTimeout("redirect()", 2000);
	
}

function redirect(){
	location.href = "index.jsp";
}

function fineErr(input) {
	input.style.borderColor = "#ccc";
}

function disattivaEr(){
	var al = document.getElementById("alertEr");
	al.style.display="none";
	window.setTimeout("redirect()", 1000);
	
}



