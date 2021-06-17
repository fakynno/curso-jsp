<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>

<link rel="stylesheet" href="resources/css/cadastro.css">

</head>
<body>
	<center><h1>Cadastro de usu�rio</h1></center>
	<ul class="form-style-1">
		<li>
			<form action="salvarUsuario" method="post">
				<table>
					<tr>
						<td>C�digo:</td>
						<td><input type="text" id="id" readonly="readonly" name="id"
							value="${user.id}" class="field-long"></td>
					</tr>

					<tr>
						<td>Login:</td>
						<td><input type="text" id="login" name="login"
							value="${user.login}"></td>
					</tr>

					<tr>
						<td>Senha:</td>
						<td><input type="password" id="senha" name="senha"
							value="${user.senha}"></td>
					</tr>
					<tr>
						<td></td>
						<td align="center"><input type="submit" value="Salvar">
						</td>
					</tr>
				</table>
			</form>
		</li>
	</ul>
	<table class="st-table">
	<caption>Usu�rios cadastrados</caption>

		<c:forEach items="${usuarios}" var="user">
			<tr>
				<td style="width: 150px"><c:out value="${user.id}"></c:out>
				<td style="width: 150px"><c:out value="${user.login}"></c:out>
				<td><c:out value="${user.senha}"></c:out>
				<td><a href="salvarUsuario?acao=delete&user=${user.login}">Excluir</a></td>
				<td><a href="salvarUsuario?acao=editar&user=${user.login}">Editar</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>