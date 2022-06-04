package com.example.websitebangiay.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {
                "/admin/trang-quan-tri",
                "/admin/thong-tin-tai-khoan",
                "/admin/nhan-hieu",
                "/admin/danh-muc",
                "/admin/san-pham",
                "/admin/don-hang",
                "/admin/lien-he",
                "/admin/quan-ly-tai-khoan"})
public class QuanTriController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/admin/trang-quan-tri")){
            path = "admin/trangquantri";
        }else if(path.equals("/admin/thong-tin-tai-khoan")){
            path = "admin/thongtin";
        }else if (path.equals("/admin/nhan-hieu")){
            path = "admin/nhanhieu";
        }else if(path.equals("/admin/danh-muc")){
            path = "admin/danhmuc";
        }else if(path.equals("/admin/san-pham")){
            path = "admin/sanpham";
        }else if (path.equals("/admin/don-hang")){
            path = "admin/donhang";
        }else if (path.equals("/admin/lien-he")){
            path = "admin/lienhe";
        }else if (path.equals("/admin/quan-ly-tai-khoan")){
            path = "admin/taikhoan";
        }

        path = "/view/"+path+".jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }
}
