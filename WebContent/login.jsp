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
<h2>Login</h2>
<form name="login" id="cad" method="POST" action="Busca">
		<table>
			<tr>
			     <td>Cpf :<input type="text" name="cpf" value="" size="20" /></td><br>
				 <td>senha : <input type="password" name="senha" value="" size="20" /></td><br><br>
                 <td> <input type="radio" name="escolha" value="0" /> Cliente <br >
                  <input type="radio" name="escolha" value="1" />Funcionario<br ></td>
				<td><input type=submit value="entrar"> <INPUT type="reset" value="Limpar"></td>
			</tr>
		</table>

	</form>

</body>
</html>