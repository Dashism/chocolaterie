$(document).ready(function() {
	$("#choco").selectmenu({
		  select: function( event, ui ) {
			  console.log("Item sélectionné : ", ui);
			  var id = ui.item.element[0].id;
			  $.ajax({
				  url: "http://localhost:8080/chocolaterie/webservices/stock/" + id
			  }).done(function(choco) {
				 var nbStock = parseInt(choco.stock);
				 var stockinfoDiv = $("#stockinfo");
				 stockinfoDiv.empty();
				 if (nbStock > 0 ) {
					 // En stock
					 stockinfoDiv.append(
							 $("<span class=\"stock ok\">En stock !</span>"));
				 } else {
					 // Pas de stock
					 stockinfoDiv.append(
							 $("<span class=\"stock ko\">Pas de stock...</span>"));
				 }
			  });
		  }
	});
});