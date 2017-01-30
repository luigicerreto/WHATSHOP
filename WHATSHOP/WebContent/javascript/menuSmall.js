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




function sposta() {
	
	var xhr = getXmlHttpRequest();
	var miniMenu = document.getElementById("mini-menu");
	miniMenu.style.display= "block";
	
	
		
}

function chiudi() {
	var xhr = getXmlHttpRequest();
	var miniMenu = document.getElementById("mini-menu");
	miniMenu.style.display= "none";


}
