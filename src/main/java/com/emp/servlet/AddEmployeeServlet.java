package com.emp.servlet;

import java.io.IOException;

import com.emp.dao.EmployeeDAO;
import com.emp.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class AddEmployeeServlet extends HttpServlet   {

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	 {
	        try {
	            String name = request.getParameter("name");
	            String email = request.getParameter("email");
	            String department = request.getParameter("department");
	            double salary = Double.parseDouble(request.getParameter("salary"));

	            Employee e = new Employee();
	            e.setName(name);
	            e.setEmail(email);
	            e.setDepartment(department);
	            e.setSalary(salary);

	            EmployeeDAO dao = new EmployeeDAO();
	            dao.addEmployee(e);

	            response.sendRedirect("view_employee.jsp");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
}
