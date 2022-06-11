package com.example.websitebangiay.controller;

import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Service.NguoiDungService;
import com.example.websitebangiay.Utils.SessionUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "KiemTraDangKy", value = "/xu-ly-dang-ky")
public class DanhKyController extends HttpServlet {
    @Inject
    private NguoiDungService nguoiDungService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("dangky")) {
            String tenDangNhap = req.getParameter("tenDangNhap");
            String email = req.getParameter("email");
            String matKhau = req.getParameter("matKhau");
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setTenDangNhap(tenDangNhap);
            nguoiDung.setEmail(email);
            nguoiDung.setMatKhau(matKhau);
            if (nguoiDungService.nguoiDungTonTai(tenDangNhap)){
                resp.sendRedirect(req.getContextPath()+"/dang-ky?nguoidungdatontai");
            }else{
                nguoiDungService.saveUser(nguoiDung);
                SessionUtils.putValue(req, "NGUOIDUNG", nguoiDung);
                resp.sendRedirect(req.getContextPath()+"/trang-chu");
            }
        }
    }
}
