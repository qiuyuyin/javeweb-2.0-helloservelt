package com.yili.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            out.write("last_time_login:");
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("last_login_time")){
                    long l = Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    URLEncoder.encode("","utf-8");
                    URLDecoder.decode("","utf-8");
                    out.write(format.format(date));
                }
            }
        }else out.write("it is your first login");

        Cookie cookie = new Cookie("last_login_time",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);//set the max_age to reverse the cookies

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
