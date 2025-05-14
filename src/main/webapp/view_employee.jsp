<%@ page import="java.util.List" %>
<%@ page import="com.emp.model.Employee" %>
<%@ page import="com.emp.dao.EmployeeDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Employee Management System</h1>
        <div class="header-bar">
            <a href="add_employee.jsp" class="add-btn">Add Employee</a> <br>
            <input type="text" id="searchInput" placeholder="Search by name..." onkeyup="filterTable()">
        </div>

        <table id="employeeTable">
            <thead>
                <tr>
                    <th style="display:none;">ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    EmployeeDAO dao = new EmployeeDAO();
                    List<Employee> list = dao.getAllEmployees();
                    for (Employee emp : list) {
                %>
                <tr>
                    <td style="display:none;"><%= emp.getId() %></td>
                    <td><%= emp.getName() %></td>
                    <td><%= emp.getEmail() %></td>
                    <td><%= emp.getDepartment() %></td>
                    <td><%= emp.getSalary() %></td>
                    <td>
                        <a href="edit_employee.jsp?id=<%= emp.getId() %>" class="update-btn">Update</a>
                        <a href="delete?id=<%= emp.getId() %>" class="delete-btn">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <script>
        function filterTable() {
            var input = document.getElementById("searchInput");
            var filter = input.value.toLowerCase();
            var table = document.getElementById("employeeTable");
            var tr = table.getElementsByTagName("tr");

            for (var i = 1; i < tr.length; i++) {
                var td = tr[i].getElementsByTagName("td")[1]; // Name column
                if (td) {
                    var txtValue = td.textContent || td.innerText;
                    tr[i].style.display = txtValue.toLowerCase().indexOf(filter) > -1 ? "" : "none";
                }
            }
        }
    </script>
</body>
</html>
