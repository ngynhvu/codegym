package controller;

import bean.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {
    private ProductService service = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            doGet(request, response);
            return;
        }
        switch (action) {
            case "create":
                createNewProduct(request,response);
                break;
            case "update":
                try {
                    updateProduct(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null||action.trim().equals("")){
            action = "list";
        }
        switch (action){
            case "create":
                request.getRequestDispatcher("/WEB-INFO/views/product/create.jsp").forward(request,response);
                break;
            case "update":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "detail":
                viewProduct(request,response);
                break;
            case "list":
            default:
                showListProduct(request,response);

        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = this.service.findById(id);
        String error = null;
        RequestDispatcher dispatcher = null;
        if(product == null){
            error = "Product don't have";
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/WEB-INFO/views/product/update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = service.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INFO/views/product/list.jsp").forward(request,response);
    }
    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String dateAsString = request.getParameter("dateRelease");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String status = request.getParameter("status");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRelease = null;
        String error = null;
        try {
            dateRelease = format.parse(dateAsString);
        } catch (ParseException e) {
            error = "Date Release was wrong format";
        }

        if (error == null) {
            try {
                service.create(new Product(id, name, price, dateRelease, quantity,status));
            } catch (Exception e) {
                error = e.getMessage();
            }
        }

        if (error == null) {
            response.sendRedirect("/product");
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INFO/views/product/create.jsp").forward(request, response);
        }

    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String idProduct = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String dateAsString = request.getParameter("date");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String status = request.getParameter("status");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRelease = null;
        String error = null;
        try {
            dateRelease = format.parse(dateAsString);
        } catch (ParseException e) {
            error = "Date Release was wrong format";
        }
        Product product = this.service.findById(idProduct);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setNameProduct(name);
            product.setPrice(price);
            product.setDateRelease(dateRelease);
            product.setQuantity(quantity);
            product.setStatus(status);
            this.service.update(product);
            request.setAttribute("product", product);
            error = "product information was updated";
            request.setAttribute("error", error);
            dispatcher = request.getRequestDispatcher("/WEB-INFO/views/product/update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = this.service.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/WEB-INFO/views/product/detail.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = this.service.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/WEB-INFO/views/product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        Product product = this.service.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.service.deleteById(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
