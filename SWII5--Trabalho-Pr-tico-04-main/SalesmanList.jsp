<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Salesman Management</title>
</head>
<body>
    <center>
        <h1>Salesman Management</h1>
        <h2>
            <a href="/gerenciador/newSalesman">Add New Salesman</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/gerenciador/listSalesmen">List All Salesmen</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Salesmen</h2></caption>
            <tr>
                <th>Name</th>
                <th>City</th>
                <th>Commission</th>
            </tr>
            <c:forEach var="salesman" items="${listSalesman}">
                <tr>
                    <td><c:out value="${salesman.name}" /></td>
                    <td><c:out value="${salesman.city}" /></td>
                    <td><c:out value="${salesman.commission}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <center>
        <form action="listCustomers" method="get">
            <input type="submit" value="Go to Customer Management" />
        </form>
        <form action="listOrders" method="get">
            <input type="submit" value="Go to Order Management" />
        </form>
    </center>
</body>
</html>
