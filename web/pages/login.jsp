<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page errorPage="../errors/exception.jsp"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="it.unibo.tw.*"%>
<%
	Boolean loggedIn = (Boolean)session.getAttribute(LoginServlet.LOGIN_OK);
	if( loggedIn != null && loggedIn ) {
		response.sendRedirect(request.getContextPath() + LoginServlet.LOGIN_NEXT);
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html>
<head>
	<meta name="author" content="Paolo Galeone">
   	<title>Login Page</title>
    <link type="text/css" href="<%= request.getContextPath() %>/styles/default.css" rel="stylesheet">
</head>

<body>
	<%@ include file="../fragments/header.jsp" %>
	<h2>Please login:</h2>
	<%
		if(request.getParameter("failed") != null) {
	%>
		<div class="error">Please insert a valid username and password</div>
	<%
		}
	%>
	<div>
		<form id="loginfrm" method="post" action="<%= request.getContextPath() %>/login">
		<div>
			<label for="username">Username:</label> <input type="text" name="username" id="username">
			<label for="password">Password:</label> <input type="password" name="password" id="password">
			<input type="submit" value="send">
		</div>
		</form>
	</div>
	<%@ include file="../fragments/footer.jsp" %>
</body>
</html>