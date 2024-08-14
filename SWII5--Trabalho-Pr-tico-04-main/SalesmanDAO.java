package gerenciador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class SalesmanDAO {
	
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public SalesmanDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public List<Salesman> listAllSalesmen() throws SQLException {
	    List<Salesman> listSalesman = new ArrayList<>();

	    String sql = "SELECT * FROM salesman";

	    connect();

	    Statement statement = jdbcConnection.createStatement();
	    ResultSet resultSet = statement.executeQuery(sql);

	    while (resultSet.next()) {
	        int id = resultSet.getInt("salesman_id");
	        String name = resultSet.getString("name");
	        String city = resultSet.getString("city");
	        float commission = resultSet.getFloat("commission");

	        Salesman salesman = new Salesman(id, name, city, commission);
	        listSalesman.add(salesman);
	    }

	    resultSet.close();
	    statement.close();

	    disconnect();

	    return listSalesman;
	}

	 public boolean insertSalesman(Salesman salesman) throws SQLException {
	        String sql = "INSERT INTO salesman (name, city, commission) VALUES (?, ?, ?)";
	        connect();

	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, salesman.getName());
	        statement.setString(2, salesman.getCity());
	        statement.setFloat(3, salesman.getCommission());

	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowInserted;
	    }
}
