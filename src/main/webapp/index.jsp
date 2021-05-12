<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="pagina-include.html" %>

	<h1>Bem vindo ao curso de JSP!</h1>
	<% out.println("Introdução ao JSP!"); %>
	
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name="nome">
		<input type="submit" value="Enviar"/>	
	</form>
	
	<%
		session.setAttribute("curso", "curso de jsp");
	%>
	
	<br/>
	<%@ page import="java.util.Date" %>

	<%= "data de hoje: " + new Date() %>	
	
	<h2>INDEX</h2>
	<jsp:forward page="receber-nome.jsp"></jsp:forward>
	
</body>
</html>