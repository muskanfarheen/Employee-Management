package com.emp.dao;

import com.emp.model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    // Get database connection
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //return DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "farheen@1786");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC", "root", "farheen@1786");

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error while getting database connection", e);
        }
    }

    // Add an employee to the database
    public void addEmployee(Employee e) {
        String sql = "INSERT INTO employees(name, email, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Get all employees from the database
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),	
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // Update an existing employee
    public void updateEmployee(Employee e) {
        String sql = "UPDATE employees SET name=?, email=?, department=?, salary=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());
            ps.setInt(5, e.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Get a single employee by ID
    public Employee getEmployee(int id) {
        Employee emp = null;
        String sql = "SELECT * FROM employees WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                    );
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return emp;
    }
}
