<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/alteraProduto" var="linkServletNovoProduto"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario para Alterar Produto</title>
</head>
<body>
	
	<form action="${linkServletNovoProduto }" method="post">
	
		Nome: <input type="text" name="nome" value="${produto.nome }"/>
		Descricao: <input type="text" name="descricao" value="${produto.descricao }"/>
		Unidade de Compra: <input type="text" name="unidadeCompra" value="${produto.unidadeCompra }"/>
		Quantidade Prevista no Mês: <input type="text" name="qtdePrevistoMes" value="${produto.qtdePrevistoMes }"/>
		Preco Maximo Comprado: <input type="text" name="precoMaxComprado" value="${produto.precoMaxComprado }"/>
		<input type="hidden" name="id" value="${produto.id }"/>
		<input type="submit"/>
	</form>

</body>
</html>