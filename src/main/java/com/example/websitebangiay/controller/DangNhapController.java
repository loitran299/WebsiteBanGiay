package com.example.websitebangiay.controller;

import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Entity.VaiTro;
import com.example.websitebangiay.Service.NguoiDungService;
import com.example.websitebangiay.Service.VaiTroService;
import com.example.websitebangiay.Utils.SessionUtils;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

@WebServlet(
        name = "DangNhapController", value = "/kiem-tra-dang-nhap")
public class DangNhapController extends HttpServlet {
    @Inject
    private NguoiDungService nguoiDungService;

    @Inject
    private VaiTroService vaiTroService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("dangnhap")){
            String tenDangNhap = request.getParameter("tenDangNhap");
            String matKhau = request.getParameter("matKhau");
            NguoiDung nguoiDung = null;
            try {
                nguoiDung = nguoiDungService.findByTenDangNhap(tenDangNhap);
            }catch (Exception e){
                e.printStackTrace();
            }
            if (nguoiDung == null){
                System.out.println("nd null");
                response.sendRedirect(request.getContextPath()+"/dang-nhap?loi");
                return;
            }else {
                if (!Objects.equals(nguoiDung.getMatKhau(), matKhau)) {
                    System.out.println("sai mk");
                    response.sendRedirect(request.getContextPath() + "/dang-nhap?loi");
                    return;
                }else{
                    SessionUtils.putValue(request ,"NGUOIDUNG", nguoiDung);
                    if (nguoiDung.laAdmin()){
                        response.sendRedirect(request.getContextPath()+"/admin/trang-quan-tri");
                    }else{
                        response.sendRedirect(request.getContextPath()+"/trang-chu");
                    }
                }
            }
        }
    }
}
