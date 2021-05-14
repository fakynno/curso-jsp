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
	<h1>Index</h1>	
	
	<form action="cabecalho.jsp" method="post">
	
		<input type="text" id="nome" name="nome"/>
		<br/>
		<input type="text" id="ano" name="ano"/>
		<br/>
		<input type="text" id="sexo" name="sexo"/>
		<br/>
		<input type="submit" value="testar"/>
			
	</form>	
</body>
</html>