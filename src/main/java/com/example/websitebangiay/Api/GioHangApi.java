package com.example.websitebangiay.Api;

import com.example.websitebangiay.Entity.*;
import com.example.websitebangiay.Service.ChiMucGioHangService;
import com.example.websitebangiay.Service.GioHangService;
import com.example.websitebangiay.Service.SanPhamService;
import com.example.websitebangiay.Utils.SessionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "GioHangApi", urlPatterns = {"/api/giohang/*"})
public class GioHangApi extends HttpServlet {
    @Inject
    private GioHangService gioHangService;

    @Inject
    private SanPhamService sanPhamService;

    @Inject
    private ChiMucGioHangService chiMucGioHangService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NguoiDung nguoiDung = (NguoiDung) SessionUtils.getValue(req, "NGUOIDUNG");
        GioHang gioHang = gioHangService.timTheoNguoiDung(nguoiDung);
        mapper.writeValue(resp.getOutputStream(), chiMucGioHangService.timTheoGiohang(gioHang));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        SanPham sanPham = sanPhamService.timTheoId(getId(req));
        NguoiDung nguoiDung = (NguoiDung) SessionUtils.getValue(req, "NGUOIDUNG");
        if (nguoiDung == null){
            doiTuongTraVe.setTrangThai("chuadangnhap");
            doiTuongTraVe.setThongBao("Chưa đăng nhập");
        }else{
            GioHang gioHang = gioHangService.timTheoNguoiDung(nguoiDung);
            if (gioHang == null) {
                gioHang = new GioHang();
                gioHang.setNguoiDung(nguoiDung);
                gioHang = gioHangService.luuGioHang(gioHang);
            }
            ChiMucGioHang chiMucGioHang = chiMucGioHangService.timTheoSanPhamVaGioHang(sanPham, gioHang);
            if (chiMucGioHang == null) {
                chiMucGioHang = new ChiMucGioHang();
                chiMucGioHang.setGioHang(gioHang);
                chiMucGioHang.setSanPham(sanPham);
                chiMucGioHang.setSoLuong(1);
            }else{
                chiMucGioHang.setSoLuong(chiMucGioHang.getSoLuong()+1);
            }
            chiMucGioHangService.luuChiMuc(chiMucGioHang);
            doiTuongTraVe.setThongBao("Thêm thành công");
        }
        mapper.writeValue(resp.getOutputStream(), doiTuongTraVe);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            int soLuong = Integer.parseInt(req.getParameter("soLuong"));
            ChiMucGioHang chiMucGioHang = chiMucGioHangService.timTheoId(id);
            chiMucGioHang.setSoLuong(soLuong);
            chiMucGioHangService.luuChiMuc(chiMucGioHang);
            doiTuongTraVe.setTrangThai("ok");
        }catch (Exception e){
            doiTuongTraVe.setThongBao("Đã xảy ra lỗi!");
        }
        mapper.writeValue(resp.getOutputStream(), doiTuongTraVe);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        chiMucGioHangService.xoaTheoId(getId(req));
        doiTuongTraVe.setThongBao("Xóa thành công");
        mapper.writeValue(resp.getOutputStream(),doiTuongTraVe);
    }

    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
