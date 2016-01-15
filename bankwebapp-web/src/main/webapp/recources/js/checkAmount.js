function checkAmount(evt) {

	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode == 46 && evt.srcElement.value.split('.').length > 1) {
		return false;
	}
	

		
	
	else if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}