package controller;

import model.employee.Employee;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeControllerServlet", value = "employees")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
            switch (action) {
//                case "create":
//                    showNewForm(request, response);
//                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "view":
//                    viewEmployee(request, response);
//                case "search":
//                    search(request, response);
//                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee>employeeList=employeeService.selectAllEmployee();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/employee/list.jsp");
        requestDispatcher.forward(request,response);
    }
}
