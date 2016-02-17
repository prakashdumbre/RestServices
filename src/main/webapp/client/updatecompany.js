function getData() {
	console.log(contextPath);
	var cId = $("#companyId", window.opener.document).val();
	$.ajax({
	  type: "GET",
	  url: "http://localhost:8080/SpringCxfWebApp/services/companies/" + cId,
	  success: function(data){
			$( "#name").val(data.name);
			$( "#address").val(data.address);
			$( "#city").val(data.city);
			$( "#country").val(data.country);
			$( "#email").val(data.email);
			$( "#phone").val(data.phoneNumber);
			$( "#owners").val(data.owners);
			$( "#companyId").val(cId);
		}
	});
}

function updateData() {
	var cId = $("#companyId").val();
    var jsonObject = new Object();
	var jsonOwners = [];
	var owners = $( "#owners" ).val();
	jsonObject.name = $( "#name" ).val();
	jsonObject.address = $( "#address" ).val();
	jsonObject.city = $( "#city" ).val();
	jsonObject.country = $( "#country" ).val();
	jsonObject.email = $( "#email" ).val();
	jsonObject.phoneNumber = $( "#phone" ).val();
	jsonObject.owners = owners;
		$.ajax({
		  type: "POST",
		  url: "http://localhost:8080/SpringCxfWebApp/services/companies/" + cId + "/update",
		  contentType: "application/json",
		  data: JSON.stringify(jsonObject),
		  success: function(data){
			  var message = "Company updated successfully with compnay id " + data.companyId;
			  $("#companyData").html(message);
			  resetData();
		  },
		 failure: function (response) {
            }
		});
}

function resetData() {
	$( "#owners" ).val("");
	$( "#name" ).val("");
	$( "#address" ).val("");
	$( "#city" ).val("");
	$( "#country" ).val("");
	$( "#email" ).val("");
	$( "#phone" ).val("");
	$( "#owners" ).val("");
}