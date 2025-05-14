<%@ page import="com.emp.model.Employee, com.emp.dao.EmployeeDAO" %>
<%
    String idParam = request.getParameter("id");
    Employee emp = null;
    if (idParam != null) {
        int id = Integer.parseInt(idParam);
        emp = new EmployeeDAO().getEmployee(id);
    }
    if (emp == null) {
%>
        <h3 style="color:red;">Employee not found. <a href="view_employee.jsp">Back</a></h3>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="css/form-style.css">
</head>
<body>
    <div class="container">
        <h2>Edit Employee</h2>
        <form action="edit" method="post">
            <input type="hidden" name="id" value="<%= emp.getId() %>">
            <label>Name:</label>
            <input type="text" name="name" value="<%= emp.getName() %>" required><br>
            <label>Email:</label>
            <input type="email" name="email" value="<%= emp.getEmail() %>" required><br>
            <label>Department:</label>
            <input type="text" name="department" value="<%= emp.getDepartment() %>" required><br>
            <label>Salary:</label>
            <input type="number" name="salary" value="<%= emp.getSalary() %>" required><br>
            <input type="submit" value="Update Employee">
        </form>
        <a href="view_employee.jsp">Back to List</a>
    </div>
</body>
</html>
