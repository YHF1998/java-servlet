package com.getdream.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//请求转发demo
public class RequestDispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        resp.setCharacterEncoding("utf-8");
        //把请求转发到/s2/hello url还是当前url，但内容是hello的内容了
        RequestDispatcher dispatcher = context.getRequestDispatcher("/hello");
        dispatcher.forward(req, resp);

    }
}
