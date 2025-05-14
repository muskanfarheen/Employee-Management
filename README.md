# 👨‍💼 Employee Management System

A simple **Employee Management System** web application built using **Java Servlets**, **JDBC**, and **MySQL**. This project allows users to **Create**, **Read**, **Update**, and **Delete (CRUD)** employee records.

---

## 🚀 Features

- ➕ Add New Employee
- 📋 View All Employees
- ✏️ Edit Employee Details
- ❌ Delete Employee
- 🔍 Search Employee by ID

---

## 🛠 Tech Stack

- Java (Servlets)
- JDBC
- MySQL
- HTML, CSS
- Apache Tomcat

---

## 🗂 Project Structure

```
EmployeeManagementSystem/
├── src/
│   ├── com.emp.dao/           # Database logic (JDBC)
│   ├── com.emp.model/         # Employee Model class
│   ├── com.emp.servlet/       # Servlet controllers
├── WebContent/
│   ├── add_employee.jsp
│   ├── view_employees.jsp
│   ├── edit_employee.jsp
│   ├── index.jsp
│   └── css/
│       └── style.css
├── lib/                       # JDBC Driver (mysql-connector.jar)
├── web.xml
└── README.md
```

---

## ⚙️ Database Setup

1. Create a MySQL database named `employee_db`
2. Create a table `employees` with the following structure:

```sql
CREATE TABLE employees (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100),
  department VARCHAR(100),
  salary DOUBLE
);
```

3. Update your DB connection in `DBUtil.java`:
```java
private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

## ▶️ How to Run

1. Import the project into **Eclipse** or your preferred IDE
2. Add the MySQL JDBC driver to the classpath
3. Deploy the project on **Apache Tomcat**
4. Access the app at: `http://localhost:8080/EmployeeManagementSystem/`

---

## 🙌 Author

**Muskan Farheen**  
[GitHub](https://github.com/)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE)
