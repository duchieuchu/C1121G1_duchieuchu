package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.customer.CustomerTypeRepository;
import repository.customer.impl.CustomerTypeRepositoryImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerController extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();
    private final CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            {
                switch (action) {
                    case "create":
                        createUser(request, response);
                        break;
//                    case "edit":
//                        editUser(request, response);
//                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
         Integer id =null;
         CustomerType customerType=customerTypeRepository.selectCustomerType(Integer.parseInt(request.getParameter("customerType")));
        //select name by id nek
         String name =request.getParameter("name");
         String birthday=request.getParameter("birthday");
         Integer gender=Integer.parseInt(request.getParameter("gender"));
         String idCard=request.getParameter("idCard");
         String phone =request.getParameter("phone");
         String email =request.getParameter("email");
         String address =request.getParameter("address");
         Customer customer = new Customer(id,customerType,name,birthday,gender,idCard,phone,email,address);
         this.customerService.insertCustomer(customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
//                case "delete":
//                    deleteCustomer(request, response);
//                    break;
//                case "view":
//                    viewCustomer(request, response);
//                case "search":
//                    search(request, response);
//                    break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = customerTypeRepository.selectAllCustomerType();
        //select all type nek
        request.setAttribute("customerTypes",customerTypes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
