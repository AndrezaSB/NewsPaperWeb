<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Global News</title>
</head>

<body>
	<form action="adicionarNoticia" method="POST" >
		<fieldset>
			<h3 align="center">Cadastrar Noticia</h3>	
			<table cellspacing="10" align="center">
				<tr>
					<td>Titulo: </td>
					<td>
						<input type="text" name="titulo" maxlength="50" size="50"/>
						<form:errors path="noticia.titulo" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>Subtitulo: </td>
					<td>
						<input type="text" name="subtitulo" maxlength="150" size="50"/>
						<form:errors path="noticia.subtitulo" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>Data: </td>
					<td>
						<input type="text" name="dataNoticia" maxlength="8" size="8"/>
						<form:errors path="noticia.dataNoticia" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>Texto: </td>
					<td>
						<textarea name="texto" rows="10" cols="50">Texto da notícia...</textarea>
					</td>	
				</tr>
				<tr>
						<select name="secao.id">
						<c:forEach var="secoes" items="${secoes}">
							<option value="${secoes.id}">${secoes.titulo}</option>
							
						</c:forEach>
						</select>
					
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Submeter" />
						<input type="reset" value="Limpar" />
					</td>
				</tr>
				
			</table>
		</fieldset>
	</form>
</body>

</html>