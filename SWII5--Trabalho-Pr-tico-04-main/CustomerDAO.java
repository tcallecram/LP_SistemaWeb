package gerenciador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public CustomerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (customer_id, cust_name, city, grade, salesman_id) VALUES (0, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getCity());
        statement.setInt(3, customer.getGrade());
        statement.setInt(4, customer.getSalesmanId());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Customer> listAllCustomers() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("customer_id");
            String name = resultSet.getString("cust_name");
            String city = resultSet.getString("city");
            int grade = resultSet.getInt("grade");
            int salesmanId = resultSet.getInt("salesman_id");

            Customer customer = new Customer(name, city, grade, salesmanId);
            listCustomer.add(customer);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listCustomer;
    }

    // Similar methods for updateCustomer, deleteCustomer, getCustomer
}
