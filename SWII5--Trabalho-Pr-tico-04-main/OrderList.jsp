<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order Management</title>
</head>
<body>
    <center>
        <h1>Order Management</h1>
        <h2>
            <a href="/gerenciador/newOrder">Add New Order</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/gerenciador/listOrders">List All Orders</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Orders</h2></caption>
            <tr>
                <th>Order No</th>
                <th>Purchase Amount</th>
                <th>Order Date</th>
                <th>Customer Name</th>
                <th>Salesman Name</th>
            </tr>
            <c:forEach var="order" items="${listOrder}">
                <tr>
                    <td><c:out value="${order.orderNo}" /></td>
                    <td><c:out value="${order.purchaseAmt}" /></td>
                    <td><c:out value="${order.orderDate}" /></td>
                    <td><c:out value="${order.customerName}" /></td>
                    <td><c:out value="${order.salesmanName}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
        <br/>
    <center>
        <form action="listCustomers" method="get">
            <input type="submit" value="Go to Customer Management" />
        </form>
        <br/>
        <form action="listSalesmen" method="get">
            <input type="submit" value="Go to Salesman Management" />
        </form>
    </center>
</body>
</html>
