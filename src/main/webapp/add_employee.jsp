<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" href="css/form-style.css">
</head>
<body>
    <div class="container">
        <h2>Add Employee</h2>
        <form action="add" method="post">
            <label>Name:</label>
            <input type="text" name="name" required><br>
            <label>Email:</label>
            <input type="email" name="email" required><br>
            <label>Department:</label>
            <input type="text" name="department" required><br>
            <label>Salary:</label>
            <input type="number" name="salary" required><br>
            <input type="submit" value="Add Employee">
        </form>
        <a href="view_employee.jsp">Back to List</a>
    </div>
</body>
</html>
