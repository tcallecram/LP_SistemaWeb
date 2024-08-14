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
        <form action="insertOrder" method="post">
            <table border="1" cellpadding="5">
                <caption><h2>Add New Order</h2></caption>
                <tr>
                    <th>Purchase Amount: </th>
                    <td><input type="text" name="purchaseAmt" size="10" required /></td>
                </tr>
                <tr>
                    <th>Customer: </th>
                    <td>
                       <select name="customerId" required>
            <c:forEach var="customer" items="${listCustomer}">
                <option value="${customer.customerId}">
                    <c:out value="${customer.name}" />
                </option>
            </c:forEach>
        </select>
                    </td>
                    
                </tr>
                <tr>
                    <th>Salesman: </th>
                    <td>
                        <select name="salesmanId" required>
                            <c:forEach var="salesman" items="${listSalesman}">
                                <option value="${salesman.id}">
                                    <c:out value="${salesman.name}" />
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
