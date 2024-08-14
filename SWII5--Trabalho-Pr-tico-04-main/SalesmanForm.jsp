<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <form action="insertSalesman" method="post">
            <table border="1" cellpadding="5">
                <caption><h2>Add New Salesman</h2></caption>
                <tr>
                    <th>Name: </th>
                    <td><input type="text" name="name" size="45" required /></td>
                </tr>
                <tr>
                    <th>City: </th>
                    <td><input type="text" name="city" size="45" required /></td>
                </tr>
                <tr>
                    <th>Commission: </th>
                    <td><input type="text" name="commission" size="5" required /></td>
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
