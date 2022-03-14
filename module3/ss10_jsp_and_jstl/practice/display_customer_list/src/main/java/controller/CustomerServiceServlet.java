package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet(name = "CustomerServiceServlet", value = "/CustomerServiceServlet")
public class CustomerServiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer>customerList= new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","https://genk.mediacdn.vn/139269124445442048/2020/5/4/photo-1-1588541968324891829550.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://image.thanhnien.vn/1200x630/Uploaded/2022/tnabtw/2021_04_23/iron-man-endgame_wpno.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQt-_WJnnv4a7Ukmf5LxlkPxXQjdmWE6tBkn5K5jKhlSYiZKQj5uzoNOt1R044JWCyFFEE&usqp=CAU"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-23","Hà Tây","https://i0.wp.com/hipertextual.com/wp-content/uploads/2014/11/iron-man-the-avengers.jpg?fit=1600%2C1067&ssl=1"));
        customerList.add(new Customer("Nguyễn Đình Thi","1983-08-24","Hà Nội","https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/3ce3fda5-c041-4624-aa5a-d92265c04c8d/d5isdix-316998ff-5e85-4acf-b3ba-ff687b76afaf.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzNjZTNmZGE1LWMwNDEtNDYyNC1hYTVhLWQ5MjI2NWMwNGM4ZFwvZDVpc2RpeC0zMTY5OThmZi01ZTg1LTRhY2YtYjNiYS1mZjY4N2I3NmFmYWYuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.22edMVbXTdag-Mfo_dVvvb46TKB4Fbcs9NEacCscjSQ"));
        request.setAttribute("customers",customerList);
        request.getRequestDispatcher("customer_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
