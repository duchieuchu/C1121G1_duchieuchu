package controller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.employee.IDivisionRepository;
import repository.employee.IEducationDegreeRepository;
import repository.employee.IPositionRepository;
import repository.impl.DivisionRepository;
import repository.impl.EducationDegreeRepository;
import repository.impl.PositionRepository;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    private IDivisionRepository divisionRepository = new DivisionRepository();
    private IPositionRepository positionRepository = new PositionRepository();
    private IEmployeeService employeeService = new EmployeeService();

    public void init() {
        employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showAddEmployee(request, response);
                    break;
                case "edit":
//                    showEditEmployee(request, response);
                    break;
                case "delete":
//                    deleteEmployee(request, response);
                    break;
                case "search":
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showAddEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<EducationDegree> educationDegrees = educationDegreeRepository.selectAllEducationDegree();
        List<Position> positions = positionRepository.selectAllPosition();
        List<Division> divisions = divisionRepository.selectAllDivision();
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = employeeService.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
//                    editEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = (int) (Math.random() * 1000);
        EducationDegree e
    }
}
