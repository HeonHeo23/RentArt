function showPassword(){
	let elem = document.getElementById("password");
	let value = elem.getAttribute("type");
	if(value == ("password")){
		elem.setAttribute("type","text");
	} else {
		elem.setAttribute("type","password");
	}
	
	let elem2 = document.getElementById("button");
	let value2 = elem2.innerHTML;
	
	if(value2 == "가리기"){
		elem2.innerHTML = "보이기";
	} else {
		elem2.innerHTML = "가리기";
	}
}