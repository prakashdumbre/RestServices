<html>
<script type="text/javascript">
var contextPath='<%=request.getContextPath()%>';
</script>
<head>
		<title>Update Company details</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script src="updatecompany.js"></script>
</head>
<body onload="getData()">
		<span style="color:blue" id="companyData"></span> <br><br>
		<input type="hidden" name="companyId" id="companyId">
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
		 <button onclick="updateData()">Update</button></td></tr>
		 </table>

</body>
</html>