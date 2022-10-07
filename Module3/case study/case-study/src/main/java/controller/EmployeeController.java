package controller;

import model.Customer;
import model.Employee;
import service.CustomerService;
import service.EmployeeService;
import service.impl.CustomerServiceImpl;
import service.impl.EmployeeServiceImpl;

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

@WebServlet(name = "EmployeeController", urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService service = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            doGet(request, response);
            return;
        }
        switch (action) {
            case "create":
                createNewEmployee(request, response);
                break;
            case "update":
                try {
                    updateEmployee(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                doGet(request, response);
        }
    }

    private void createNewEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        String birthdayAsString = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));

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
                service.create(new Employee(id,name,birthday,id_card,salary,phone,email,address,position,education,division,"no"));
            } catch (Exception e) {
                error = e.getMessage();
            }
        }

        if (error == null) {
            response.sendRedirect("/employee");
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/furama-management/employee/create.jsp").forward(request, response);
        }
    }


    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthdayAsString = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        String error = null;
        try {
            birthday = format.parse(birthdayAsString);
        } catch (ParseException e) {
            error = "Birthday sai format";
        }
        Employee employee = new Employee(id,name,birthday,id_card,salary,phone,email,address,position,education,division,"no");
        service.update(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/employee/update.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            action = "list";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/furama-management/employee/create.jsp").forward(request, response);
                break;
            case "update":
                try {
                    showEditForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteEmployee(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "detail":
                try {
                    showDetailEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "find":
                break;
            case "list":
            default:
                showList(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = service.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/employee/update.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteById(id);
        List<Employee> employees = service.findAll();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDetailEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = service.findById(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-management/employee/detail.jsp");
        dispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = null;
        try {
            employees = service.findAll();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/furama-management/employee/list.jsp").forward(request, response);
    }
}