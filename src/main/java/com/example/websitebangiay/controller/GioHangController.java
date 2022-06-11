package com.example.websitebangiay.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/gio-hang", "/xac-nhan-don-hang"})
public class GioHangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/gio-hang")){
            path = "web/giohang";
        }else if (path.equals("/xac-nhan-don-hang")){
            path = "web/xacnhandonhang";
        }
        path = "/view/"+path+".jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
