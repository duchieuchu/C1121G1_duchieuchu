package controller;

import model.HocSinh;
import model.Sach;
import model.TheMuonSach;
import repository.HocSinhRepository;
import repository.IHocSinhRepository;
import repository.ITheMuonSachRepository;
import repository.TheMuonSachRepository;
import service.ISachService;
import service.SachServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SachServlet", value = "/sach")
public class SachServlet extends HttpServlet {
    private ISachService sachService = new SachServiceImpl();
    private IHocSinhRepository hocSinhRepository = new HocSinhRepository();
    private ITheMuonSachRepository theMuonSachRepository = new TheMuonSachRepository();

    public void init() {
        sachService = new SachServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    muonSach(request, response);
                    break;
                case "delete":
//                    deleteSach(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void muonSach(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = (int) (Math.random() * 1000);
        TheMuonSach maMuonSach = theMuonSachRepository.selectTheMuonSach(Integer.parseInt("maMuonSach"));
        String tenSach = request.getParameter("tenSach");
        HocSinh tenHocSinh = hocSinhRepository.selectHocSinh(Integer.parseInt(request.getParameter("tenHocSinh")));
        TheMuonSach ngayMuon = theMuonSachRepository.selectTheMuonSach(Integer.parseInt(request.getParameter("ngayMuon")));
        TheMuonSach ngayTra = theMuonSachRepository.selectTheMuonSach(Integer.parseInt(request.getParameter("NgayTra")));
        Sach sach = new Sach(id, maMuonSach, tenSach, tenHocSinh, ngayMuon, ngayTra);
        sachService.insertBook(sach);

        RequestDispatcher dispatcher = request.getRequestDispatcher("muonSach/create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "muon":
                    showMuonSach(request, response);
                    break;
                case "edit":
//                    showEditProduct(request, response);
                    break;
                case "listMuonSach":
                    listMuonSach(request, response);
                    break;
                default:
                    listSach(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listMuonSach(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Sach> sachMuonList = sachService.selectAllBook();
        request.setAttribute("sachMuonList", sachMuonList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("muonSach/danhSach.jsp");
        dispatcher.forward(request, response);
    }

    private void showMuonSach(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Sach sach = sachService.selectBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("muonSach/tao.jsp");
        dispatcher.forward(request, response);
    }

    private void listSach(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Sach> sachList = sachService.selectAllBook();
        request.setAttribute("sachList", sachList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("sach/danhSach.jsp");
        dispatcher.forward(request, response);
    }
}
