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
		<form action="usuarioLogin" method="POST" >
		<fieldset>
			<h3 align="center">Login Global News</h3>	
			<table cellspacing="10" align="center">
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
					<td>
						<label for="role">Tipo de Conta: </label>
					</td>
					<td align="left">
					    <select name="role"> 
					    <option value="leitor">Leitor</option> 
					    <option value="jornalista">Jornalista</option> 
					    <option value="editor">Editor</option> 
					    <option value="administrador">Administrador</option> 
					     </select>
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