package controller;

import model.service.RentalType;
import model.service.Service;
import model.service.ServiceType;
import repository.service.*;
import repository.service.impl.RentalTypeRepositoryImpl;
import repository.service.impl.ServiceRepositoryImpl;
import repository.service.impl.ServiceTypeRepositoryImpl;
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
import java.util.Map;

@WebServlet(name = "ServiceControllerServlet", value = "/services")
public class ServiceController extends HttpServlet {
    private final ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    private final ServiceService serviceService = new ServiceServiceImpl();
    private final RentalTypeRepository rentalTypeRepository = new RentalTypeRepositoryImpl();

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
                        createService(request, response);
                        break;
//                    case "edit":
//                        editUser(request, response);
//                        break;
//                    case "delete":
//                        deleteCustomer(request, response);
//                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = null;
        String serviceCode = request.getParameter("serviceCode");
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.parseDouble(request.getParameter("cost"));
        Integer maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        RentalType rentalType = rentalTypeRepository.selectRentalType(Integer.parseInt(request.getParameter("rentalType")));
        ServiceType serviceType = serviceTypeRepository.selectServiceType(Integer.parseInt(request.getParameter("serviceType")));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        Double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        Integer numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(id, serviceCode, name, area, cost, maxPeople, rentalType, serviceType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
//        this.serviceService.insertService(service);
        Map<String, String> map = serviceService.insertService(service);
        if (map.isEmpty()) {
            List<RentalType> rentalTypes = rentalTypeRepository.selectAllRentalType();
            List<ServiceType> serviceTypes = serviceTypeRepository.selectAllServiceType();
            //all nek
            request.setAttribute("rentalTypes", rentalTypes);
            request.setAttribute("serviceTypes", serviceTypes);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create.jsp");
            requestDispatcher.forward(request, response);
        } else {
            List<RentalType> rentalTypes = rentalTypeRepository.selectAllRentalType();
            List<ServiceType> serviceTypes = serviceTypeRepository.selectAllServiceType();
            //all nek
            request.setAttribute("rentalTypes", rentalTypes);
            request.setAttribute("serviceTypes", serviceTypes);
            request.setAttribute("error", map);
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
        }

//        List<RentalType> rentalTypes = rentalTypeRepository.selectAllRentalType();
//        List<ServiceType> serviceTypes = serviceTypeRepository.selectAllServiceType();
//        //all nek
//        request.setAttribute("rentalTypes", rentalTypes);
//        request.setAttribute("serviceTypes", serviceTypes);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create.jsp");
//        requestDispatcher.forward(request, response);

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
            case "view":
                viewService(request, response);
//                case "search":
//                    search(request, response);
//                    break;
            default:
                listService(request, response);
                break;
        }
    }

    //        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalType> rentalTypes = rentalTypeRepository.selectAllRentalType();
        List<ServiceType> serviceTypes = serviceTypeRepository.selectAllServiceType();
        //all nek
        request.setAttribute("rentalTypes", rentalTypes);
        request.setAttribute("serviceTypes", serviceTypes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void viewService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.selectService(id);
        request.setAttribute("service", service);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/view.jsp");
        requestDispatcher.forward(request, response);

    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/list.jsp");
        requestDispatcher.forward(request, response);

    }
}
