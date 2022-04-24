package controller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.employee.DivisionRepository;
import repository.employee.EducationDegreeRepository;
import repository.employee.PositionRepository;
import repository.employee.impl.DivisionRepositoryImpl;
import repository.employee.impl.EducationDegreeRepositoryImpl;
import repository.employee.impl.PositionRepositoryImpl;
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

@WebServlet(name = "EmployeeControllerServlet", value = "/employees")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    private final EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    private final PositionRepository positionRepository = new PositionRepositoryImpl();

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
                        createEmployee(request, response);
                        break;
//                    case "edit":
//                        editEmployee(request, response);
//                        break;
//                    case "delete":
//                        deleteEmployee(request, response);
//                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = null;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Position position = positionRepository.selectPosition(Integer.parseInt(request.getParameter("position")));
        EducationDegree educationDegree = educationDegreeRepository.selectEducationDegree(Integer.parseInt(getInitParameter("educationDegree")));
        Division division = divisionRepository.selectDivision(Integer.parseInt(request.getParameter("division")));
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division);
        employeeService.insertEmployee(employee);

        List<Position> positions = positionRepository.selectAllPosition();
        List<EducationDegree> educationDegrees = educationDegreeRepository.selectAllEducationDegree();
        List<Division> divisions = divisionRepository.selectAllDivision();
        request.setAttribute("positions",positions);
        request.setAttribute("educationDegrees",educationDegrees);
        request.setAttribute("divisions",divisions);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");
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

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positions = positionRepository.selectAllPosition();
        List<EducationDegree> educationDegrees = educationDegreeRepository.selectAllEducationDegree();
        List<Division> divisions = divisionRepository.selectAllDivision();
        request.setAttribute("positions",positions);
        request.setAttribute("educationDegrees",educationDegrees);
        request.setAttribute("divisions",divisions);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
