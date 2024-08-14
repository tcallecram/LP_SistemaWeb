package gerenciador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/insertCustomer", "/listCustomers", "/newCustomer", "/deleteCustomer", "/editCustomer", "/updateCustomer"})
public class CustomerControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;
    
    private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/sys?serverTimezone=America/Sao_Paulo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    public void init() {
        customerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Redireciona para o método doGet para tratamento
    }


    private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
    	SalesmanDAO s = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	
        List<Salesman> listSalesman = s.listAllSalesmen();
        request.setAttribute("listSalesman", listSalesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
            case "/newCustomer":
                showNewCustomerForm(request, response);
                break;
            case "/insertCustomer":
                insertCustomer(request, response);
                break;
            case "/listCustomers":
            	listCustomers(request, response);
                break;
            // Outros casos...
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int grade = Integer.parseInt(request.getParameter("grade"));
        int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

        Customer newCustomer = new Customer(name, city, grade, salesmanId);
        customerDAO.insertCustomer(newCustomer);
        response.sendRedirect("listCustomers");
    }
    
    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDAO.listAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
        dispatcher.forward(request, response);
    }

}
