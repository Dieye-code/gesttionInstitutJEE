$(document).ready(function() {
	libelle = $('#libelle');
	$('#form').submit(function(e) {
		var a = 0;
		if (libelle.val().trim() == "") {
			$('#form').addClass("was-validated")
			a = 1;
		}
		if (a == 1) {
			return false;
		}
		return true;
	})

})