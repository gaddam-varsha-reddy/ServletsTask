package com.wavemaker.controller;
import com.wavemaker.manager.UserManager;
import com.wavemaker.manager.UserManagerFactory;
import com.wavemaker.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.wavemaker.constants.PersistentType.MemoryType.JDBC;

public class UserServlet extends HttpServlet {
    private UserManagerFactory userManagerFactory =new UserManagerFactory();
   private UserManager userManager= userManagerFactory.chooseMethod(JDBC);
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
       User user=objectMapper.readValue(request.getReader(),User.class);
        userManager.deleteUser(user.getName());
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user = objectMapper.readValue(request.getReader(), User.class);
        userManager.addUser(user);
    }
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        doGet(req, resp);
    }

}
