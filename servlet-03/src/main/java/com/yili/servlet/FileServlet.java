package com.yili.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String context = "/WEB-INF/classes/ont.png";
        ServletContext sc = this.getServletContext();
        String realpath =  sc.getRealPath("/");
        System.out.println("root:"+realpath);

        String filename = context.substring(context.lastIndexOf("/")+1);


        InputStream inputStream = sc.getResourceAsStream(context);

        resp.setHeader("Content-Type", "application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));

        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        while ((len=inputStream.read(buffer))>0){
            servletOutputStream.write(buffer,0,len);
        }
        inputStream.close();
        servletOutputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
