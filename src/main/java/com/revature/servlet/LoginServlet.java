package com.revature.servlet;

import com.revature.models.EmployeeUser;
import com.revature.models.Role;
import com.revature.repositories.EmployeeUserDAO;
import com.revature.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    LoginService LoginService = new LoginService();
    EmployeeUserDAO  employeeUserDAO = new EmployeeUserDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EmployeeUser e = LoginService.login(username, password);
        if(e !=null){
            if(e.getRole() == Role.EMPLOYEE){
                HttpSession session = request.getSession();
            }
            response.getWriter().write("Succesfully logged in");
        }else{
            response.setStatus(404);
        }



    }
}
