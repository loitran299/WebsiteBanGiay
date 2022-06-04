package com.example.websitebangiay.controller;

import com.example.websitebangiay.Service.Bus.NguoiDungServiceImpl;
import com.example.websitebangiay.Service.Bus.SanPhamServiceImpl;
import com.example.websitebangiay.Service.NguoiDungService;
import com.example.websitebangiay.Service.SanPhamService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {
                "/trang-chu",
                "/dang-nhap",
                "/lien-he",
                "/chi-tiet-san-pham",
                "/tim-san-pham",
                "/thong-tin-tai-khoan",
                "/trang-san-pham",
                "/dang-xuat",
                "/dang-ky"})
public class NguoiDungController extends HttpServlet {
    @Inject
    private NguoiDungService nguoiDungService;

    @Inject
    private SanPhamService sanPhamService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/trang-chu")){
            req.setAttribute("cacSanPham",sanPhamService.tatCaSanPham());
            path = "web/trangchu";
        }else if(path.equals("/dang-nhap")){
            path = "dangnhap";
        }else if (path.equals("/lien-he")){
            path = "web/lienhe";
        }else if(path.equals("/chi-tiet-san-pham")){
            path = "web/chitietsanpham";
        }else if(path.equals("/tim-san-pham")){
            path = "web/timsanpham";
        }else if (path.equals("/thong-tin-tai-khoan")){
            path = "web/thongtin";
        }else if (path.equals("/trang-san-pham")){
            path = "web/sanpham";
        }else if (path.equals("/dang-xuat")){
            resp.sendRedirect("/dang-nhap?dangxuat");
            return;
        }else if (path.equals("/dang-ky")){
            path = "dangky";
        }
        path = "/view/"+path+".jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

    }
}
