package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request,response);
                break;
            default:
                listProducts(request,response);
                break;
        }
    }
    private void showCreateProduct(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
        }
    }
    private void createProduct(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        int id = (int) (Math.random()*1000);

        Product product = new Product(id,name,price,description,brand);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message","new product was created");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void listProducts(HttpServletRequest request,HttpServletResponse response){
        List<Product>products = this.productService.findAll();
        System.out.println(products.size());
        request.setAttribute("products",products);
        RequestDispatcher dispatcher= request.getRequestDispatcher("product/list.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
