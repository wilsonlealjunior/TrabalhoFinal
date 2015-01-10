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

<h2>Taloes</h2>
<table border="1" width="70%">
		<th>Resolvido</th>
		<th>Descricao</th>
		<th>tipo</th>
		<c:forEach var="r" items="${lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'EEEEEE' : 'CCCCCC' }">
				<td align="center">${r.status}</td>
				<td align="center">${r.descricao}</td>
				<td><a href="/TrabalhoFinal/VisualizarTipo?id=${r.tipo.id}&idConta=${r.conta.idConta}">tipo</a></td>
				
			</tr>
		</c:forEach>
	</table>
	
	<a href="/TrabalhoFinal/principal.jsp">voltar as contas</a>

</body>
</html>