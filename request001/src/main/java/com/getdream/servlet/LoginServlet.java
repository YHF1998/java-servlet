package com.getdream.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//登录与转发
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        resp.setCharacterEncoding("utf-8");

        //获取请求参数
        String[] hobbys = req.getParameterValues("hobbys");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        //打印
        System.out.println(Arrays.toString(hobbys));
        System.out.println(name);
        System.out.println(password);

        //转发
        System.out.println(req.getContextPath());
        req.getRequestDispatcher("/success.jsp").forward(req, resp);

    }
}
