package controller;

import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeService;

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

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    private CustomerService service = new CustomerServiceImpl();
    private CustomerTypeService typeService = new CustomerTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            doGet(request, response);
            return;
        }
        switch (action) {
            case "create":
                createNewCustomer(request, response);
                break;
            case "update":
                try {
                    updateCustomer(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                showTypeList(request, response);
                request.getRequestDispatcher("/furama-management/customer/create.jsp").forward(request, response);
                break;
            case "update":
                showTypeList(request, response);
                try {
                    showEditForm(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteCustomer(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "detail":
            case "list":
            default:
                showList(request, response);
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = null;
        try {
            customers = service.findAll();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/furama-management/customer/list.jsp").forward(request, response);
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthdayAsString = request.getParameter("birthday");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        String error = null;
        try {
            birthday = format.parse(birthdayAsString);
        } catch (ParseException e) {
            error = "Birthday sai format";
        }

        if (error == null) {
            try {
                service.create(new Customer(id,type_id,name,birthday,gender,id_card,phone,email,address));
            } catch (Exception e) {
                error = e.getMessage();
            }
        }

        if (error == null) {
            response.sendRedirect("/customer");
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/furama-management/customer/create.jsp").forward(request, response);
        }

    }
    private void showTypeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = null;
        try {
            customerTypes = typeService.findAll();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("customerTypes", customerTypes);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = service.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/customer/update.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);

    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthdayAsString = request.getParameter("birthday");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        String error = null;
        try {
            birthday = format.parse(birthdayAsString);
        } catch (ParseException e) {
            error = "Birthday sai format";
        }
        Customer customer = new Customer(id,type_id,name,birthday,gender,id_card,phone,email,address);
        service.update(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/customer/update.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteById(id);

        List<Customer> customers = service.findAll();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
