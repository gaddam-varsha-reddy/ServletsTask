package com.demo.servlet;
import com.demo.implementations.JdbcUserManager;
import com.demo.interfaceManager.UserManager;
import com.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class UserServlet extends HttpServlet {
    private UserManager userManager = new JdbcUserManager();
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userManager.listUsers();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = objectMapper.readValue(request.getReader(), User.class);
        userManager.addUser(user);
    }
    @Override
    protected void doDelete(HttpServletRequest request,HttpServletResponse response) throws IOException{
       String username=objectMapper.readValue(request.getReader(),String.class);
        userManager.deleteUser(username);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user = objectMapper.readValue(request.getReader(), User.class);
        userManager.addUser(user);
    }
}
