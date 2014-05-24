<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page errorPage="../../errors/exception.jsp"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="it.unibo.tw.*"%>
<%
	Boolean loggedIn = (Boolean)session.getAttribute(LoginServlet.LOGIN_OK);
	if( loggedIn == null || !loggedIn ) {
		response.sendRedirect(request.getContextPath() + "/login?next=/blog/edit");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html>
<head>
	<meta name="author" content="Paolo Galeone">
   	<title>Edit page</title>
    <link type="text/css" href="<%= request.getContextPath() %>/styles/default.css" rel="stylesheet">
</head>

<body>
	<%@ include file="../../fragments/header.jsp" %>
	<div style="text-align:center">
		<a href="<%= request.getContextPath() %>/blog/view">View Blog</a>
	</div>
	<br />
	
	<jsp:useBean id="article" class="it.unibo.tw.blog.beans.Article" scope="application" />
	<%
		String req = request.getParameter("action");
		if( req!=null && req.equals("edit") ) {
			String art = request.getParameter("article");
			article.setArticle(art == null ? "" : art);
		}
	%>
	
	<form name="articleForm" action="<%= request.getContextPath() %>/blog/edit" method="post">
		Article text:<br/>
		<textarea name="article" rows="4" cols="20" ><%= article.getArticle() == null ? "" : article.getArticle() %></textarea><br />
		<input type="submit" name="action" value="edit"/><br />
	</form>	
	<br />
	<%@ include file="../../fragments/footer.jsp" %>
</body>
</html>