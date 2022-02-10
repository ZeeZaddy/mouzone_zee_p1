package com.revature.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestForm extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false);


        if(session == null){
            PrintWriter out = response.getWriter();
            out.write("<h1>Wrong page HOE<h1>");
            out.write("<a href='index.html'>Click here MF</a>");
        }else{
            double amount = Double.parseDouble(request.getParameter("amount"));
            String description = request.getParameter("description");

        }


    }
}
