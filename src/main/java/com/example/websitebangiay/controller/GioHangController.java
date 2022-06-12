package com.example.websitebangiay.controller;

import com.example.websitebangiay.Entity.*;
import com.example.websitebangiay.Service.ChiMucGioHangService;
import com.example.websitebangiay.Service.ChiTietDonHangService;
import com.example.websitebangiay.Service.DonHangService;
import com.example.websitebangiay.Service.GioHangService;
import com.example.websitebangiay.Utils.SessionUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/gio-hang", "/xac-nhan-don-hang"})
public class GioHangController extends HttpServlet {
    @Inject
    private GioHangService gioHangService;

    @Inject
    private ChiMucGioHangService chiMucGioHangService;

    @Inject
    private DonHangService donHangService;

    @Inject
    private ChiTietDonHangService chiTietDonHangService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/gio-hang")){
            path = "web/giohang";
        }else if (path.equals("/xac-nhan-don-hang")){
            NguoiDung nguoiDung = (NguoiDung) SessionUtils.getValue(req, "NGUOIDUNG");
            GioHang gioHang = gioHangService.timTheoNguoiDung(nguoiDung);
            List<ChiMucGioHang> chiMucGioHangs = chiMucGioHangService.timTheoGiohang(gioHang);
            List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
            DonHang donHang = new DonHang();
            donHang.setNguoiDung(nguoiDung);
            donHang.setNgayDat(new Date());
            donHang.setTrangThai("chuahoanthanh");
            donHang = donHangService.luuDonHang(donHang);
            long tongGia = 0;
            for (ChiMucGioHang chiMuc : chiMucGioHangs){
                ChiTietDonHang chiTietDonHang = chiTietDonHangService.luuChiTietDonHang(chiMuc,donHang);
                chiTietDonHangs.add(chiTietDonHang);
                tongGia += chiTietDonHang.getDonGia();
                chiMucGioHangService.xoaChiMuc(chiMuc);
            }
            donHang.setTongGia(tongGia);
            donHang.setChiTiets(chiTietDonHangs);
            donHang = donHangService.updateDonHang(donHang);
            req.setAttribute("donHang",donHang);
            req.setAttribute("chiTiets",chiTietDonHangs);
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
