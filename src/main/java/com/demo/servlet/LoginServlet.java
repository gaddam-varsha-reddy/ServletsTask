package com.demo.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(username.equals("varsha") && password.equals("varsha")){
            HttpSession session=request.getSession(false);
            if(session!=null){
                session.invalidate();
            }
            HttpSession newsession=request.getSession(true);
            newsession.setMaxInactiveInterval(1*60);
            response.getWriter().write("Login Successful!!");
            response.getWriter().write(" Welcome, "+username);
            //newsession.setAttribute("username",username);
        }
        else{
            response.getWriter().write("Invalid login credentials");
        }
    }
}

