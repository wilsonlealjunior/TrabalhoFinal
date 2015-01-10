<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Reclamacao da conta com numero: ${recla.conta.idConta }</h3>
<br>Status: ${status }<br>
Descricao: ${recla.descricao }<br>
<a href="/TrabalhoFinal/VisualizarTipo?id=${recla.tipo.id}&idConta=${recla.conta.idConta}">tipo</a>
<a href="/TrabalhoFinal/Busca?cpf=${recla.conta.cliente.cpf}&senha=${recla.conta.cliente.senha}&escolha=0">voltar as contas</a>

</body>
</html>