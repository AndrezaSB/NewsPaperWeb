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

<body>
	<h3>Lista de Funções</h3>
	
	<table border="1">
		<tr>
			<td><b>Role</b></td>
			<td><b>Atualizar</b></td>
			<td><b>Excluir</b></td>
		</tr>
		<c:forEach var="role" items="${roles}">
			<tr>
				<c:choose>
					<c:when test="${not empty role.role}">
						<td>${role.role}</td>
					</c:when>
					<c:otherwise>
						<td><b>Não Cadastrado!</b></td>
					</c:otherwise>
				</c:choose>
				<td><a href="atualizarRole?id=${role.id}">Atualizar</a></td>
				<td><a href="removerRole?id=${role.id}">Excluir</a></td>	
			</tr>
		</c:forEach>
	</table>
	
</body>

</html>