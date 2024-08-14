package gerenciador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/newOrder", "/insertOrder", "/listOrders"})
public class OrderControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;
    private CustomerDAO customerDAO;
    private SalesmanDAO salesmanDAO;

    public void init() {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/sys?serverTimezone=America/Sao_Paulo";
        String jdbcUsername = "root";
        String jdbcPassword = "root";

        orderDAO = new OrderDAO(jdbcURL, jdbcUsername, jdbcPassword);
        customerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
        salesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newOrder":
                    showNewOrderForm(request, response);
                    break;
                case "/insertOrder":
                    insertOrder(request, response);
                    break;
                case "/listOrders":
                    listOrders(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Customer> listCustomer = customerDAO.listAllCustomers();
        List<Salesman> listSalesman = salesmanDAO.listAllSalesmen();
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listSalesman", listSalesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        float purchaseAmt = Float.parseFloat(request.getParameter("purchaseAmt"));
        Date orderDate = new Date();
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

        Order newOrder = new Order(purchaseAmt, orderDate, customerId, salesmanId);
        orderDAO.insertOrder(newOrder);
        response.sendRedirect("listOrders");
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listOrder = orderDAO.listAllOrders();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList.jsp");
        dispatcher.forward(request, response);
    }
}
