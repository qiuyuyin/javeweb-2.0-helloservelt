package com.yili.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh","3");
        //refresh
        BufferedImage bufferedImage = new BufferedImage(50,20,BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setBackground(Color.BLUE);
        graphics2D.fillRect(0,0,50,20);
        graphics2D.setColor(Color.ORANGE);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.drawString(makenum(),0,20);

        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());
    }

    private String makenum(){
        Random random = new Random();
        String num =  random.nextInt(9999)+"";
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 4-num.length(); i++) {
            stringBuffer.append("0");
        }
        num = stringBuffer.toString() + num;
        return num;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
