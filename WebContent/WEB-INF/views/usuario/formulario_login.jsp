<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" >
	<title>Global News</title>
</head>

<body>
	<script src="bootstrap/js/bootstrap.js" ></script>
		<form class="well" action="usuarioLogin" method="POST">
		<fieldset>
			<h3 align="center">Login Global News</h3>	
			<table cellspacing="10" align="center">
				<tr>
					<td>Login: </td>
					<td>
						<input type="text" name="login" maxlength="20" class="span3" placeholder="Digite o seu login..."/>
						<form:errors path="usuario.login" cssStyle="color:red"/>
					</td>
				</tr>
				<tr>
					<td>Senha: </td>
					<td>
						<input type="password" name="senha" maxlength="20" class="span3" placeholder="Digite sua senha..."/>
						<form:errors path="usuario.senha" cssStyle="color:red"/>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input  class="btn btn-primary" type="submit" value="Submeter" />
						<input class="btn" type="reset" value="Limpar" />
					</td>
				</tr>
				
			</table>
		</fieldset>
	</form>
</body>

</html>