package com.getdream.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取属性demo
public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream resource = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");

        //获取资源
        Properties properties = new Properties();
        properties.load(resource);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        resp.getWriter().println(username + ":" + password);

    }
}
