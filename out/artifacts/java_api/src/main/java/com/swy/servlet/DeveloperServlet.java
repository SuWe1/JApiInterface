package com.swy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class DeveloperServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet初始化……");
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h2>hello swy , this message come from servlet</h2>");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet销毁！");
    }
}
