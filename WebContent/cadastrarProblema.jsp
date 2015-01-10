<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${msg }</h3>
<form name="cadastrar_problema" id="cad" method="POST" action="CadastrarProblema">
		<table>
			<tr>
			     <td>Codigo :<input type="text" name="codigo" value="" size="20" /></td><br>
				 <td>descrição : <input type="text" name="descricao" value="" size="40" /></td><br>
				<td><input type=submit value="Cadastrar"> <INPUT type="reset" value="Limpar"></td>
			</tr>
		</table>

	</form>
	<a href="/TrabalhoFinal/principal.jsp">Pagina principal</a>

</body>
</html>