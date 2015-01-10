<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Taloes</h2>
<table border="1" width="70%">
		<th>numero</th>
		<th>pago</th>
		<th>valor</th>
		<th>vencimento</th>
		<c:forEach var="c" items="${lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'EEEEEE' : 'CCCCCC' }">
				<td align="center">${c.numero}</td>
				<td align="center">${c.pago}</td>
				<td align="center">${c.valor }</td>
				<td align="center"><fmt:formatDate value="${c.data}" pattern="dd/MM/yyyy" /></td>
				
			</tr>
		</c:forEach>
	</table>
	
	<a href="/TrabalhoFinal/Busca?cpf=${cpf}&senha=${senha}&escolha=0">voltar as contas</a>

</body>
</html>