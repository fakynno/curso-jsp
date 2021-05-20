<jsp:useBean id="calcula" class="beans.BeansCursoJsp" type="beans.BeansCursoJsp" scope="page"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Index</h1>	
	
	<c:out value="${'bem vindo ao JSTL'}"></c:out>
	
	<p/>
	<p/>
	<p/>
	
	<c:set var="numero" value="${100/2}"></c:set>	
	
	 <c:choose>
	   
	   <c:when test="${numero > 50}">
	   		<c:out value="${'Maior que 50'}"/>
	   </c:when>
	   
	   <c:when test="${numero < 50}">
	   		<c:out value="${'Menor que 50'}"/>
	   </c:when>
	
	   <c:otherwise>
	   	 <c:out value="${'Não encontrou valor correto'}"/>
	   	 <br/>
	   </c:otherwise>
	   	 
	 </c:choose>
	 
	 <c:forTokens items="Luigi-Macedo-Vasconcelos-de-Aquino" delims="-" var="nome">
	 	Nome : <c:out value="${nome}"/>
	 		<br/>	
	 </c:forTokens>
		
	
	<c:forEach var="inteiro" begin="1" end="${numero}">
		Item: ${inteiro}		
	</c:forEach>
	
	<p/>
	<p/>
	<p/>
	
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