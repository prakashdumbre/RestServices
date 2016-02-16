function getData() {
var cId = $("#cId").val();
$.ajax({
  type: "GET",
  url: "http://localhost:8080/SpringCxfWebApp/services/companies/" + cId,
  success: function(data){
		var tableFormat =  "<table style=width:100 border=1>" +
		  "<tr>" +
			"<th>Comapy Id</th>" +
			"<th>Comapy Name</th> " +
			"<th>Address</th>" +
			"<th>Country</th>"+
			"<th>Telephone</th>" +
		  "</tr>" +
		  "<tr>" +
			"<td> " + data.companyId + " </td> " +
			"<td> " + data.name + " </td>" +
			"<td> " + data.address + " </td>" +
			"<td> " + data.country + " </td>" +
			"<td> " + data.phoneNumber + " </td>" +
		  "</tr>" +
		"</table> ";

		$("#displayData").html(tableFormat);
	}

});
}

function getAllData() {
$.ajax({
  type: "GET",
  url: "http://localhost:8080/SpringCxfWebApp/services/companies/",
  success: function(data){
		var tableFormat =  "<table style=width:100 border=1>" +
		  "<tr>" +
			"<th>Comapy Id</th>" +
			"<th>Comapy Name</th> " +
			"<th>Address</th>" +
			"<th>Country</th>"+
			"<th>Telephone</th>" +
			"<th>Owners</th>" +
		  "</tr>" ;
		  var row;
		  var rows="";
		  for (var index = 0; index < data.length; index++) {
			 row =  "<tr>" +
				"<td> " + data[index].companyId + " </td> " +
				"<td> " + data[index].name + " </td>" +
				"<td> " + data[index].address + " </td>" +
				"<td> " + data[index].country + " </td>" +
				"<td> " + data[index].phoneNumber + " </td>" +
			  "</tr>";
			  rows = rows + " " + row;
		  }
		var endTag = "</table> ";

		$("#displayData").html(tableFormat +" " + rows + " " + endTag);
	}

});
}