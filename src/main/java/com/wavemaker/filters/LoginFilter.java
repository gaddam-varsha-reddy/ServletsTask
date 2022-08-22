package com.wavemaker.filters;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
public class LoginFilter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(username.equals("varsha") && password.equals("varsha")) {
            Cookie ck = new Cookie("name", username);
            response.addCookie(ck);
//            HttpSession session=request.getSession(false);
//            if(session!=null){
//                session.invalidate();
//            }
//            HttpSession newsession=request.getSession(true);
//            newsession.setMaxInactiveInterval(1*60);
            //newsession.setAttribute("username",username);
                response.getWriter().write("Login Successful!!");
                response.getWriter().write(" Welcome, " + username);
        }
        else{
            response.getWriter().write("Invalid login credentials");
        }
    }
}

