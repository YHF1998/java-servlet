package com.getdream.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8;");
        ServletContext context = this.getServletContext();
        String name = (String) context.getAttribute("name");
        //取初始化参数
        String name2 = (String) context.getInitParameter("user");
        resp.getWriter().println(name + name2);
    }
}
