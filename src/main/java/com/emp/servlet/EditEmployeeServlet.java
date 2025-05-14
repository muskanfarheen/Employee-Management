package com.emp.servlet;

import java.io.IOException;

import com.emp.dao.EmployeeDAO;
import com.emp.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditEmployeeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee e = new Employee(id, name, email, department, salary);
            EmployeeDAO dao = new EmployeeDAO();
            dao.updateEmployee(e);

            response.sendRedirect("view_employee.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
