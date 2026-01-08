package com.demo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve the current session, do not create a new one if it doesn't exist
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate(); // Clear all session data
        }
        
        // Redirect back to login page with a message
        // Note: Using sendRedirect is better for logout to clear the URL state
        response.sendRedirect("login.jsp?error=Logged out successfully");
    }
}