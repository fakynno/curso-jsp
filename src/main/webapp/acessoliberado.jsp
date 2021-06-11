<jsp:useBean id="calcula" class="beans.BeansCursoJsp" type="beans.BeansCursoJsp" scope="page"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="*" name="calcula"/>
	
	<h3>Seja bem vindo ao sistema em jsp</h3>
	
	<a href="cadastroUsuario.jsp">Cadastro de usuários</a> 	
	
</body>
</html>