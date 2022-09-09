import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float price = Float.parseFloat(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("percent"));
        double amount = price*percent*0.01;
        PrintWriter writer =response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Discount Amount: " + amount + "</h1>");
        writer.println("<h1>Discount Price: " + (amount+price) + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
