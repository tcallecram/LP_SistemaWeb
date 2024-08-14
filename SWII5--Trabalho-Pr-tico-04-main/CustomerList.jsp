<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management</title>
</head>
<body>
    <center>
        <h1>Customer Management</h1>
        <h2>
            <a href="/gerenciador/newCustomer">Add New Customer</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/gerenciador/listCustomers">List All Customers</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Customers</h2></caption>
            <tr>
                <th>Name</th>
                <th>City</th>
                <th>Grade</th>
            </tr>
            <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.city}" /></td>
                    <td><c:out value="${customer.grade}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <center>
        <form action="listSalesmen" method="get">
            <input type="submit" value="Go to Salesman Management" />
        </form>
        <form action="listOrders" method="get">
            <input type="submit" value="Go to Order Management" />
        </form>
    </center>
</body>
</html>
