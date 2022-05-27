function changeFee(fee){
	let month = document.getElementById('rentMonth').value;
	document.getElementById('totalPrice').innerHTML = (fee * month).toLocaleString('en');
}