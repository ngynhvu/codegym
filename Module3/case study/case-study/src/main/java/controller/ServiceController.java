package controller;

import model.Customer;
import model.Service;
import service.CustomerService;
import service.ServiceService;
import service.impl.CustomerServiceImpl;
import service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServiceController",urlPatterns = "/service")
public class ServiceController extends HttpServlet {
    private ServiceService service = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            doGet(request, response);
            return;
        }
        switch (action) {
            case "create":
                createNewService(request,response);
                break;
            case "update":
                break;
            default:
                doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            action = "list";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/furama-management/service/create.jsp").forward(request, response);
                break;
            case "update":

                break;
            case "delete":
                try {
                    deleteService(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "detail":

                break;
            case "find":
                break;
            case "list":
            default:
                showList(request,response);
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> services = null;
        try {
            services = service.findAll();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("services", services);
        request.getRequestDispatcher("/furama-management/service/list.jsp").forward(request, response);
    }
    private void createNewService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("service_id"));
        String name = request.getParameter("service_name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int people = Integer.parseInt(request.getParameter("people"));
        int rent = Integer.parseInt(request.getParameter("rent"));
        int serviceID = Integer.parseInt(request.getParameter("service"));
        String standard = request.getParameter("standard");
        String other = request.getParameter("des");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        String error = null;
            try {
                service.create(new Service(id,name,area,cost,people,rent,serviceID,standard,other,poolArea,floors));
            } catch (Exception e) {
                error = e.getMessage();
            }
        if (error == null) {
            response.sendRedirect("/service");
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/furama-management/service/create.jsp").forward(request, response);
        }

    }
    private void deleteService(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteById(id);

        List<Service> services = service.findAll();
        request.setAttribute("services", services);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/service/list.jsp");
        dispatcher.forward(request, response);
    }
}
