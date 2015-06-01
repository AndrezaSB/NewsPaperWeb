<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Global News</title>
</head>

<body>
	<h3>Editar Seção</h3>
	
	<form action="inserirSecaoAlterada" method="POST">
	
		<table>
				<input type="hidden" name="id" value="${role.id}" />
			<tr>
				<td>Título: </td>
				<td>
					<input type="text" name="titulo" value="${secao.titulo}" maxlength="20" size="20"/>
					<form:errors path="secao.titulo" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<td>Descrição: </td>
				<td>
					<input type="text" name="descricao" value="${secao.descricao}" maxlength="100" size="100"/>
					<form:errors path="secao.descricao" cssStyle="color:red"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Alterar" /></td>
			</tr>
		</table>
	</form>
	
</body>

</html>