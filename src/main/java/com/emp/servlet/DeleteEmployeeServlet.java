package com.emp.servlet;

import java.io.IOException;

import com.emp.dao.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            EmployeeDAO dao = new EmployeeDAO();
            dao.deleteEmployee(id);

            response.sendRedirect("view_employee.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
