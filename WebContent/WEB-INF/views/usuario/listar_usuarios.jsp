<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Global News</title>
</head>
		<h3>Lista de Usuários</h3>
	
	<table border="1">
		<tr>
			<td><b>Login</b></td>
			<td><b>Nome Completo</b></td>
			<td><b>Email</b></td>
			<td><b>Jornalista</b></td>
			<td><b>Atualizar</b></td>
			<td><b>Excluir</b></td>
		</tr>
		<c:forEach var="usuario" items="${usuarios}">
			<tr>
				<c:choose>
					<c:when test="${not empty usuario.login}">
						<td>${usuario.login}</td>
					</c:when>
					<c:otherwise>
						<td><b>Não Cadastrado!</b></td>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${not empty usuario.nome}">
						<td>${usuario.nome}</td>
					</c:when>
					<c:otherwise>
						<td><b>Não Cadastrado!</b></td>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${not empty usuario.email}">
						<td>${usuario.email}</td>
					</c:when>
					<c:otherwise>
						<td><b>Não Cadastrado!</b></td>
					</c:otherwise>
				</c:choose>
				<!-- falta implementar o contratarJornalista -->
				<td><a href="contratarJornalista?id=${usuario.id}">Contratar</a>
				<td><a href="atualizarUsuario?id=${usuario.id}">Atualizar</a></td>
				<td><a href="removerUsuario?id=${usuario.id}">Excluir</a></td>	
			</tr>
		</c:forEach>
	</table>
</body>

</html>