<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page errorPage="../../errors/exception.jsp"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="it.unibo.tw.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html>
<head>
	<meta name="author" content="Paolo Galeone">
   	<title>Blog!</title>
    <link type="text/css" href="<%= request.getContextPath() %>/styles/default.css" rel="stylesheet">
</head>

<body>
	<%@ include file="../../fragments/header.jsp" %>
	<div style="text-align:center">
		<a href="<%= request.getContextPath() %>/blog/edit">Edit Blog</a>
	</div>
	<br />
	
	<jsp:useBean id="article" class="it.unibo.tw.blog.beans.Article" scope="application" />
	<div id="article">
	<%= article.getArticle() == null ? "" : article.getArticle() %>
	</div>
	
	<form name="commentForm" action="<%= request.getContextPath() %>/blog/comments" method="post">
		Insert comment:<br />
		<textarea name="comment" rows="4" cols="20" ></textarea><br />
		<input type="submit" name="action" value="add"/> &nbsp;
		<input type="submit" name="action" value="view"/><br />
	</form>	
	<br />
	<%
		@SuppressWarnings("unchecked")
		Vector<String> comments = (Vector<String>)request.getAttribute("comments");
		if( comments != null ){
	%>
			Comments: 
			<ul>
	<%
			Iterator<String> it = comments.iterator();
			while( it.hasNext() ){
	%>
				<li><%= it.next() %></li>
	<%  	} %>
			</ul>
	<% } %>
	<br />
	<%@ include file="../../fragments/footer.jsp" %>
</body>
</html>