<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
       $("#nascimento").datepicker();
  </script>
  <h3>${msg }</h3>
<form name="gerar_talao" id="cad" method="POST" action="GerarTalao">
		<table>
			<tr>
			     <td>Numero da conta :<input type="text" name="numero" value="" size="20" /></td><br>
			     <td>Numero do talao :<input type="text" name="numerotalao" value="" size="20" /></td><br>
				 <td>valor : <input type="text" name="valor" value="" size="20" /></td><br>
				 <td>Vencimento : <input name="vencimento" id="vencimento"  onkeypress="" value= <fmt:formatDate value="${p.nascimento}" pattern="dd/MM/yyyy" />></input><br><br></td><br>
				<td><input type=submit value="Cadastrar"> <INPUT type="reset" value="Limpar"></td>
			</tr>
		</table>

	</form>
	<a href="/TrabalhoFinal/principal.jsp">Pagina principal</a>


</body>
</html>