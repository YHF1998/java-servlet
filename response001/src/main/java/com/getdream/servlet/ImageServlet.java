package com.getdream.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//图片验证码生成
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器3秒自动刷新
        resp.setHeader("refresh", "30");

        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();

        //设置图片的背景颜色
        graphics.setBackground(Color.WHITE);
        //填充
        graphics.fillRect(0, 0, 80, 20);

        //写入验证码

        String num = makeNum();
        //设置字体颜色
        graphics.setColor(Color.BLUE);
        //设置字体：默认字体 加粗，20px
        graphics.setFont(new Font(null, Font.BOLD, 20));
        //绘制
        graphics.drawString(num, 0, 20);

        //以图片形式打开
        resp.setContentType("image/jpeg");

        //告诉浏览器不缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        //把图片写入浏览器
        boolean write = ImageIO.write(image, "jpg", resp.getOutputStream());


    }


    private String makeNum() {
        Random random = new Random();
        //0-9999999 的随机数
        String num = random.nextInt(9999999) + "";

        //不够7位 补0
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");
            System.out.println(sb.toString());
        }

        //拼接
        num = sb.toString() + num;

        return num;
    }
}
