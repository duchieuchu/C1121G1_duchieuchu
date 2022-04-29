package controller;

import model.RentalType;
import model.Room;
import repository.room.RentalTypeRepository;
import repository.room.RentalTypeRepositoryImpl;
import service.RoomService;
import service.RoomServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RoomControllerServlet", value = "/rooms")
public class RoomControllerServlet extends HttpServlet {
    private final RoomService roomService = new RoomServiceImpl();
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
                        createRoom(request, response);
                        break;
//                    case "edit":
//                        editUser(request, response);
//                        break;
                    case "delete":
                        deleteRoom(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        roomService.delete(id);
        List<Room> listRoom = roomService.selectAllRoom();
        request.setAttribute("listRoom", listRoom);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/room/list.jsp");
        requestDispatcher.forward(request, response);

    }

    private void createRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = null;
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String checkIn = request.getParameter("checkIn");
        RentalType rentalType = rentalTypeRepository.selectRentalType(Integer.parseInt(request.getParameter("rentalType")));
        String otherInfo = request.getParameter("otherInfo");
        Room room = new Room(id, userName, phone, checkIn, rentalType, otherInfo);
        this.roomService.insertRoom(room);
        List<Room> listRoom = roomService.selectAllRoom();
        request.setAttribute("listRoom", listRoom);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/room/list.jsp");
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
//                case "view":
//                    viewContract(request, response);
                case "search":
                    search(request, response);
                    break;
            default:
                listRoom(request, response);
                break;
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Room> listRoom = roomService.finByName(name);
        request.setAttribute("listRoom", listRoom);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/room/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalType> rentalTypes = rentalTypeRepository.selectAllRentalType();
        request.setAttribute("rentalTypes", rentalTypes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/room/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> listRoom = roomService.selectAllRoom();
        request.setAttribute("listRoom", listRoom);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/room/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
