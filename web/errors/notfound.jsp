 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ page isErrorPage="true" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html>
<head>
	<meta name="author" content="Paolo Galeone">
	<title>404 - Not Found</title>
    <link type="text/css" href="<%= request.getContextPath() %>/styles/default.css" rel="stylesheet">
    <script type="application/javascript" src="<%= request.getContextPath() %>/scripts/errorPageHelpers.js"></script>
</head>
<body>
	<div style="text-align:center">
		<h1>The resource you requested was not found on this server.</h1>
		<button onclick="goBack()">Go back [ &#8592; ]</button>
	</div>
</body>
</html>