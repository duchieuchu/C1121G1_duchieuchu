package servlet;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
//        PrintWriter writer = response.getWriter();
        float result = Calculator.calculator(firstOperand,secondOperand,operator);
        request.setAttribute("kq",result);
        request.setAttribute("n1",firstOperand);
        request.setAttribute("n2",secondOperand);
        request.setAttribute("op",operator);
        request.getRequestDispatcher("answer.jsp").forward(request,response);
//        writer.println(firstOperand+" "+operator+" "+secondOperand+" = "+result);
//        writer.println("<html>");
//        writer.println("<h1>Result:<h1>");
//        try {
//
//        }catch (Exception e){
//            writer.println("Error: " + e.getMessage());
//        }
//        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
