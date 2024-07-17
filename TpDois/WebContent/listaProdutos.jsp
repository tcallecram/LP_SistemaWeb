<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,gerenciador.Produto" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty produto}">
		Produto ${produto} cadastrado com sucesso!
	</c:if>
	
	Lista de produtos:
	
	<ul>
		
		<c:forEach items="${produtos}" var="produtos">
			
			<li>
				Produto: ${produto.nome } Descricao: ${produto.descricao }
				<a href="/gerenciador/mostraProduto?id=${produto.id }">edita</a>
				<a href="/gerenciador/removeProduto?id=${produto.id }">remove</a>
			</li>
		
		</c:forEach>
	</ul>
	
</body>
</html>