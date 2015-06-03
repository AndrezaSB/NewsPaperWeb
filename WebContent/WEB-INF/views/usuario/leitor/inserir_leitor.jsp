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
	<form action="adicionarLeitor" method="POST" >
		<fieldset>
			<h3 align="center">Cadastro Global News</h3>	
			<table cellspacing="10" align="center">
				<tr>
					<td>Nome Completo: </td>
					<td>
						<input type="text" name="nome" maxlength="50"/>
						<form:errors path="usuario.nome" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>Login: </td>
					<td>
						<input type="text" name="login" maxlength="20"/>
						<form:errors path="usuario.login" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>Senha: </td>
					<td>
						<input type="password" name="senha" maxlength="20"/>
						<form:errors path="usuario.senha" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>E-mail: </td>
					<td>
						<input type="text" name="email" maxlength="50"/>
						<form:errors path="usuario.email" cssStyle="color:red"/>
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