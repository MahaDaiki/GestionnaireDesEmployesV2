package controllers;

import models.Admin;
import models.Candidate;
import models.Employee;
import models.Recruiter;
import services.serviceImplementations.AuthenticationServiceImpl;
import services.serviceInterfaces.AuthenticationServiceInt;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationServlet extends HttpServlet {

    private AuthenticationServiceInt authenticationService;

    @Override
    public void init() throws ServletException {
        authenticationService = new AuthenticationServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "login":
                handleLogin(request, response);
                break;
            case "logout":
                handleLogout(request, response);
                break;
            default:
                request.setAttribute("message", "Unknown action");
                request.getRequestDispatcher("views/login.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "login":
                request.getRequestDispatcher("views/login.jsp").forward(request, response);
                break;
            case "logout":
                handleLogout(request, response);
                break;
            case "dashboardadmin":
                handleAdminDashboard(request, response);
                break;
            case "dashboardemployee":
                handleEmployeeDashboard(request, response);
                break;
            case "dashboardrecruiter":
                handleRecruiterDashboard(request, response);
                break;
            case "dashboardcandidate":
                handleCandidateDashboard(request, response);
                break;
            default:
                request.setAttribute("message", "Unknown action");
                request.getRequestDispatcher("views/login.jsp").forward(request, response);
                break;
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = authenticationService.loginAsAdmin(email, password);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", admin);
            session.setAttribute("role", "ADMIN");
            response.sendRedirect("/auth/dashboardadmin");
            return;
        }

        // Check for Employee login
        Employee employee = authenticationService.loginAsEmployee(email, password);
        if (employee != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", employee);
            session.setAttribute("role", "EMPLOYEE");
            response.sendRedirect("/auth/dashboardemployee");
            return;
        }

        // Check for Recruiter login
        Recruiter recruiter = authenticationService.loginAsRecruiter(email, password);
        if (recruiter != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", recruiter);
            session.setAttribute("role", "RECRUITER");
            response.sendRedirect("/auth/dashboardrecruiter");
            return;
        }

        // Check for Candidate login
        Candidate candidate = authenticationService.loginAsCandidate(email, password);
        if (candidate != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", candidate);
            session.setAttribute("role", "CANDIDATE");
            response.sendRedirect("/auth/dashboardcandidate");
            return;
        }

        request.setAttribute("message", "Invalid credentials");
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        request.setAttribute("message", "You have been logged out successfully.");
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

    private void handleAdminDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null && "ADMIN".equals(session.getAttribute("role"))) {
            request.getRequestDispatcher("views/admindashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Access Denied. Admins only.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    private void handleEmployeeDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null && "EMPLOYEE".equals(session.getAttribute("role"))) {
            request.getRequestDispatcher("views/employeedashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Access Denied. Employees only.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    private void handleRecruiterDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null && "RECRUITER".equals(session.getAttribute("role"))) {
            request.getRequestDispatcher("views/recruiterdashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Access Denied. Recruiters only.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    private void handleCandidateDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null && "CANDIDATE".equals(session.getAttribute("role"))) {
            request.getRequestDispatcher("views/candidatedashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Access Denied. Candidates only.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
