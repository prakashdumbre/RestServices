function getData() {
var cId = $("#cId").val();
$.ajax({
  type: "GET",
  url: "http://localhost:8080/SpringCxfWebApp/services/companies/" + cId,
  success: function(data){

	  var htmlFormat = "Comapy Id : " + data.companyId + "<br>" +
	  "Comapy Name : " + data.name + "<br>" +
	  "Comapy Address : " + data.address + "<br>" +
	  "Comapy Country : " + data.country +  "<br>" +
	  "Comapy phoneNumber : " + data.phoneNumber + "<br>" ;

	  $("#displayData").html(htmlFormat);
	}

});
}