package com.getdream.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

//文件下载
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //InputStream inputStream = this.getServletContext().getResourceAsStream("");

        //获取文件的下载路径
        //String path = this.getServletContext().getRealPath("WEB-INF/classes/1.txt");
        String path = this.getServletContext().getRealPath("WEB-INF/classes/测试.txt");
        System.out.println("文件下载路径：" + path);

        //下载的文件名名称是什么 获取最后一个斜杠的位置 并切割，就能获取文件名
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        System.out.println("filename:" + fileName);

        //设置下载的响应头，让浏览器识别是下载资源
        resp.setContentType("application/octet-stream;charset=utf-8");
        //解决中文文件名乱码问题 URLEncoder.encode(fileName, "UTF-8")
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));


        //获取下载文件的输入流
        InputStream input = new FileInputStream(path);

        //创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];

        //获取output 对象
        ServletOutputStream output = resp.getOutputStream();
        while ((len = input.read(buffer)) > 0) {
            output.write(buffer, 0, len);
        }

        output.close();
        input.close();
    }
}
