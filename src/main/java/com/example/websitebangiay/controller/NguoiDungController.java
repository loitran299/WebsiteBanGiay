package com.example.websitebangiay.controller;

import com.example.websitebangiay.Service.Bus.NguoiDungServiceImpl;
import com.example.websitebangiay.Service.Bus.SanPhamServiceImpl;
import com.example.websitebangiay.Service.DanhMucService;
import com.example.websitebangiay.Service.NguoiDungService;
import com.example.websitebangiay.Service.NhanHieuService;
import com.example.websitebangiay.Service.SanPhamService;
import com.example.websitebangiay.Utils.SessionUtils;

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
    private DanhMucService danhMucService;

    @Inject
    private NhanHieuService nhanHieuService;

    @Inject
    private SanPhamService sanPhamService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/trang-chu")){
            path = "web/trangchu";
        }else if(path.equals("/dang-nhap")){
            path = "dangnhap";
        }else if (path.equals("/lien-he")){
            path = "web/lienhe";
        }else if(path.equals("/chi-tiet-san-pham")){
            Long id = Long.valueOf(req.getParameter("id"));
            req.setAttribute("sanPham", sanPhamService.timTheoId(id));
            path = "web/chitietsanpham";
        }else if(path.equals("/tim-san-pham")){
            path = "web/timsanpham";
        }else if (path.equals("/thong-tin-tai-khoan")){
            path = "web/thongtin";
        }else if (path.equals("/trang-san-pham")){
            Long id = null;
            try {
                id = Long.valueOf(req.getParameter("idDanhMuc"));
            }catch (Exception e){

            }
            if (id != null){
                req.setAttribute("idDanhMuc", id);
            }
            path = "web/sanpham";
        }else if (path.equals("/dang-xuat")){
            SessionUtils.removeValue(req, "NGUOIDUNG");
            resp.sendRedirect("/dang-nhap?dangxuat");
            return;
        }else if (path.equals("/dang-ky")){
            path = "dangky";
        }
        req.setAttribute("cacNhanHieu", nhanHieuService.getAll());
        req.setAttribute("cacDanhMuc", danhMucService.tatCaDanhMuc());
        path = "/view/"+path+".jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
