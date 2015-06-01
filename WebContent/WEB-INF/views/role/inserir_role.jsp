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
	<form action="adicionarRole" method="POST" >
		<fieldset>
			<h3 align="center">Cadastrar Função</h3>	
			<table cellspacing="10" align="center">
				<tr>
					<td>Nome Função: </td>
					<td>
						<input type="text" name="role" maxlength="20" size="20"/>
						<form:errors path="role.role" cssStyle="color:red"/>
					</td>
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