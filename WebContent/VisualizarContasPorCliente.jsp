<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Contas</h2>
<table border="1" width="70%">
		<th>numero</th>
		<th>cpf</th>
		<th>reclamacao</th>
		<th>taloes</th>
		<c:forEach var="c" items="${lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'EEEEEE' : 'CCCCCC' }">
				<td align="center">${c.idConta}</td>
				<td align="center">${c.cliente.cpf}</td>
				<td><a href="/TrabalhoFinal/VisualizarReclamacao?idConta=${c.idConta}">visualizar reclamacao</a></td>
				<td><a href="/TrabalhoFinal/VisualizarTaloes?idConta=${c.idConta}">visualizar taloes</a></td>
				
			</tr>
		</c:forEach>
	</table>
	
	<a href="login.jsp">Sair</a>

</body>
</html>