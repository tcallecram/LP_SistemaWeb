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

@WebServlet(urlPatterns = {"/newSalesman", "/insertSalesman", "/listSalesmen"})
public class SalesmanControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SalesmanDAO salesmanDAO;

    public void init() {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/sys?serverTimezone=America/Sao_Paulo";
        String jdbcUsername = "root";
        String jdbcPassword = "root";

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
                case "/newSalesman":
                    showNewSalesmanForm(request, response);
                    break;
                case "/insertSalesman":
                    insertSalesman(request, response);
                    break;
                case "/listSalesmen":
                    listSalesmen(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewSalesmanForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        float commission = Float.parseFloat(request.getParameter("commission"));

        Salesman newSalesman = new Salesman(name, city, commission);
        salesmanDAO.insertSalesman(newSalesman);
        response.sendRedirect("listSalesmen");
    }

    private void listSalesmen(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Salesman> listSalesman = salesmanDAO.listAllSalesmen();
        request.setAttribute("listSalesman", listSalesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
        dispatcher.forward(request, response);
    }
}
