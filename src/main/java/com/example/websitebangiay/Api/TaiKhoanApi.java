package com.example.websitebangiay.Api;

import com.example.websitebangiay.Dto.NguoiDungDto;
import com.example.websitebangiay.Entity.DoiTuongTraVe;
import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Service.NguoiDungService;
import com.example.websitebangiay.Service.VaiTroService;
import com.example.websitebangiay.Utils.HttpUtils;
import com.example.websitebangiay.Utils.SessionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/taikhoan/*"})
public class TaiKhoanApi extends HttpServlet {
    @Inject
    private NguoiDungService nguoiDungService;

    @Inject
    private VaiTroService vaiTroService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String path = req.getPathInfo();
        if(path.endsWith("/all")) {
            mapper.writeValue(resp.getOutputStream(), nguoiDungService.getAll());
        }else {
            NguoiDung nguoiDung = nguoiDungService.getById(getId(req));
            mapper.writeValue(resp.getOutputStream(), nguoiDung);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NguoiDungDto nguoiDung = HttpUtils.of(req.getReader()).toEntity(NguoiDungDto.class);
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        if (nguoiDungService.nguoiDungTonTai(nguoiDung.getTenDangNhap())){
            doiTuongTraVe.setThongBao("Tên người dùng đã tồn tại!");
            doiTuongTraVe.setTrangThai("loi");
        }else{
            doiTuongTraVe.setThongBao("Thêm tài khoản thành công");
            doiTuongTraVe.setTrangThai("thanhcong");
            nguoiDungService.save(nguoiDung);
        }
        mapper.writeValue(resp.getOutputStream(), doiTuongTraVe);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NguoiDungDto nguoiDung = HttpUtils.of(req.getReader()).toEntity(NguoiDungDto.class);
        NguoiDung nd = nguoiDungService.update(nguoiDung);
        SessionUtils.putValue(req, "NGUOIDUNG", nd);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Long id = getId(req);
        nguoiDungService.deleteById(id);
    }
    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
