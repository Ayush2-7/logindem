<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<body>
    <h2>Welcome, ${username}!</h2>
    <p>You have successfully logged in using JDBC Type-4 Driver.</p>
    <a href="logout">Logout</a>
</body>
</html>