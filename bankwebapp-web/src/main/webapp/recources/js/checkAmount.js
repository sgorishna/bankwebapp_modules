function checkAmount(evt) {

	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode == 46 && evt.srcElement.value.split('.').length > 1) {
		return false;
	}
	
	else if(evt.srcElement.value.charAt(0)=='0'  ){
		
		if(evt.srcElement.value.charAt(1)=='0' ){
			return false;
		
		} else{
			
			return true;
			}
		}
		
		
	
	else if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}