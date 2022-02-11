package com.revature.servlet;

import com.revature.models.EmployeeReimbursement;
import com.revature.models.EmployeeUser;
import com.revature.models.Status;
import com.revature.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestMana {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);


        if(session == null){
            PrintWriter out = response.getWriter();
            out.write("<h1>Wrong page HOE<h1>");
            out.write("<a href='index.html'>Click here MF</a>");
        }else{
            int amount = Integer.parseInt(request.getParameter("amount"));
            String description = request.getParameter("description");
            String courseType = request.getParameter("courseType");
            String letterGrade = request.getParameter("letterGrade");


            EmployeeUser e = (EmployeeUser) session.getAttribute("employeeuser");
            EmployeeReimbursement reim = new EmployeeReimbursement(Status.PENDING, e, amount, description, courseType, letterGrade);

            ReimbursementService rs = new ReimbursementService();
            rs.create(reim);
            response.sendRedirect("manager.html");

        }


    }
}


