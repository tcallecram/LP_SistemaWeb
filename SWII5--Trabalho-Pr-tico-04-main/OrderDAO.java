package gerenciador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?)";
        connect();

        System.out.println("SQL Query: " + sql);
        System.out.println("Parameters: " + order.getPurchaseAmt() + ", " + order.getOrderDate() + ", " + order.getCustomerId() + ", " + order.getSalesmanId());

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, order.getPurchaseAmt());
        statement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
        statement.setInt(3, order.getCustomerId());
        statement.setInt(4, order.getSalesmanId());

        boolean rowInserted = statement.executeUpdate() > 0;
        System.out.println("Row Inserted: " + rowInserted);

        statement.close();
        disconnect();
        return rowInserted;
    }



    public List<Order> listAllOrders() throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT o.ord_no, o.purch_amt, o.ord_date, c.cust_name, s.name AS salesman_name " +
                     "FROM orders o " +
                     "JOIN customer c ON o.customer_id = c.customer_id " +
                     "JOIN salesman s ON o.salesman_id = s.salesman_id";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int orderNo = resultSet.getInt("ord_no");
            float purchaseAmt = resultSet.getFloat("purch_amt");
            Date orderDate = resultSet.getDate("ord_date");
            String customerName = resultSet.getString("cust_name");
            String salesmanName = resultSet.getString("salesman_name");

            Order order = new Order(orderNo, purchaseAmt, orderDate, customerName, salesmanName);
            listOrder.add(order);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrder;
    }
}
