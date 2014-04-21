$(function(){
	
	$("#mostrarMenu").click(function(){
		if ($("#menuHide").css('display') == 'none')
			$("#menuHide").slideDown();
		else
			$("#menuHide").slideUp();
			
		return false;
	});
	
});