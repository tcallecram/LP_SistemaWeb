<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/novoProduto" var="linkServletNovoProduto"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario para novo produto</title>
</head>
<body>
	
		<form action="${linkServletNovoProduto }" method="post">
			
		Nome: <input type="text" name="nome"/>
		Descricao: <input type="text" name="descricao"/>
		Unidade de Compra: <input type="text" name="unidadeCompra"/>
		Quantidade Prevista no Mês: <input type="text" name="qtdePrevistoMes"/>
		Preco Maximo Comprado: <input type="text" name="precoMaxComprado"/>
		<input type="submit"/>
		</form>
</body>
</html>

