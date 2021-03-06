package com.yili.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;character=utf-8");

        HttpSession session = req.getSession();
        session.setAttribute("name","yili");

        String sessionId = session.getId();

        if(session.isNew()){
            resp.getWriter().write("success!!!!");
        }else {
            resp.getWriter().write("ID"+sessionId);
            resp.getWriter().write(session.getAttribute("name")+"");
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
