<!doctype html>
<script language="javascript" type="text/javascript">

function addData(url) {
	newwindow=window.open(url,'name','height=500,width=450');
	if (window.focus) {newwindow.focus()}
	return false;
}
var contextPath = '<%=request.getContextPath()%>';
</script>
<html>
	<head>
		<title>Hello AngularJS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    	<script src= "/SpringCxfWebApp/client/findcompanydetails.js"></script>
	</head>

	<body>
		<button type="button" onclick="addData(contextPath + '/client/addcompany.jsp')">Add Company</button> <br><br>

		<button type="button" onclick="addData(contextPath + '/client/updatecompany.jsp')">Update Company</button>
			<input type="text" id="companyId" placeholder="Company Id"/>&nbsp; <br><br>

		<button type="button" onclick="getData()">Get Company details</button> &nbsp;
			<input type="text" id="cId" placeholder="Company Id"/>&nbsp; <br><br>

		<button type="button" onclick="getAllData()">Get All Company details</button> &nbsp;

		<br><br>
		<div id="displayData">
	</body>
</html>