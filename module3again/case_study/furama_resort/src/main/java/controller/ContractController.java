package controller;

import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;
import service.contract.ContractService;
import service.contract.ContractServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.service.ServiceService;
import service.service.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractControllerServlet", value = "/contracts")
public class ContractController extends HttpServlet {
    private final ContractService contractService = new ContractServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final CustomerService customerService = new CustomerServiceImpl();
    private final ServiceService serviceService = new ServiceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            {
                switch (action) {
                    case "create":
                        createContract(request, response);
                        break;
//                    case "edit":
//                        editUser(request, response);
//                        break;
//                    case "delete":
//                        deleteContract(request, response);
//                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = null;
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Double deposit = Double.parseDouble(request.getParameter("deposit"));
        Double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Employee employee = employeeService.selectEmployee(Integer.parseInt(request.getParameter("employee")));
        Customer customer = customerService.selectCustomer(Integer.parseInt(request.getParameter("customer")));
        Service service = serviceService.selectService(Integer.parseInt(request.getParameter("service")));
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, employee, customer, service);
        this.contractService.insertContract(contract);

        List<Employee> employees = employeeService.selectAllEmployee();
        List<Customer> customers = customerService.selectAllCustomer();
        List<Service> services = serviceService.selectAllService();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/create.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "view":
//                    viewContract(request, response);
//                case "search":
//                    search(request, response);
//                    break;
            default:
                listContract(request, response);
                break;
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.selectAllEmployee();
        List<Customer> customers = customerService.selectAllCustomer();
        List<Service> services = serviceService.selectAllService();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> listContract = contractService.selectAllContract();
        request.setAttribute("listContract", listContract);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        requestDispatcher.forward(request, response);
    }

}
