package com.wavemaker.filters;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
public class LogoutFilter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       /* HttpSession session=request.getSession(false);
        if(session!=null){
            session.invalidate();
        }*/
        Cookie ck=new Cookie("name","");
        ck.setMaxAge(0);
        response.addCookie(ck);
        response.getWriter().write("Logout Successfull");
    }
}
