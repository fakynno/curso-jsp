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
	
	<form action="LoginServlet" method="post">
	
	  <div>
		Login: 
		<input type="text" id="login" name="login"/>
		<br/>
		Senha:
		<input type="text" id="senha" name="senha"/>
		<br/>
		<input type="submit" value="Fazer login"/>	  
	  </div>
			
	</form>	
</body>
</html>