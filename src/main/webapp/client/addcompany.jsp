<html>
<head>
		<title>Add Compay details</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>

<script type="text/javascript">
var contextPath='<%=request.getContextPath()%>';
</script>

<script>
function addData() {
    var jsonObject = new Object();
	var jsonOwners = [];
	var owners = $( "#owners" ).val();
	console.log(owners);
	jsonObject.name = $( "#name" ).val();
	jsonObject.address = $( "#address" ).val();
	jsonObject.city = $( "#city" ).val();
	jsonObject.country = $( "#country" ).val();
	jsonObject.email = $( "#email" ).val();
	jsonObject.phoneNumber = $( "#phone" ).val();
	jsonObject.owners = owners;
		$.ajax({
		  type: "POST",
		  url: contextPath + "/services/companies",
		  contentType: "application/json",
		  data: JSON.stringify(jsonObject),
		  success: function(data){
			  var message = "Company created successfully with compnay id " + data.companyId;
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
</script>
		<span style="color:blue" id="companyData"></span> <br><br>
		 <table>
		 <tr><td> Company name: &nbsp;</td><td> <input type="text" name="name" id="name"></td></tr>
		  <tr><td>Address: &nbsp; </td><td><input type="text" name="address" id="address"></td></tr>
		  <tr><td>City:&nbsp;</td><td> <input type="text" name="city" id="city"></td></tr>
		  <tr><td>County:&nbsp;</td><td> <input type="text" name="country" id="country"></td></tr>
		  <tr><td>Email:&nbsp; </td><td> <input type="text" name="email" id="email"></td></tr>
		  <tr><td>Phone:&nbsp;</td><td>  <input type="text" name="phone" id="phone"></td></tr>
		  <tr><td>Owners:&nbsp;</td><td>
		  <select multiple="true" id="owners">
			  <option value="Volvo">Volvo</option>
			  <option value="Saab">Saab</option>
			  <option value="Opel">Opel</option>
			  <option value="Audi">Audi</option>
			</select></td></tr>
			<tr><td colspan="2" align="center"><br/>
		 <button onclick="addData()">submit</button></td></tr>
		 </table>

</body>
</html>