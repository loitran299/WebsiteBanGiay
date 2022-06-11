package com.example.websitebangiay.Api;

import com.example.websitebangiay.Entity.DanhMuc;
import com.example.websitebangiay.Entity.DoiTuongTraVe;
import com.example.websitebangiay.Service.DanhMucService;
import com.example.websitebangiay.Utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/danhmuc/*"})
public class DanhMucApi extends HttpServlet {
    @Inject
    private DanhMucService danhMucService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(), danhMucService.tatCaDanhMuc());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        DanhMuc danhMuc = HttpUtils.of(req.getReader()).toEntity(DanhMuc.class);
        if(danhMucService.danhMucTonTai(danhMuc)) {
            doiTuongTraVe.setThongBao("Danh mục đã tồn tại!");
        }else {
            danhMucService.luuDanhMuc(danhMuc);
            doiTuongTraVe.setThongBao("Thêm thành công");
        }
        mapper.writeValue(resp.getOutputStream(), doiTuongTraVe);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        Long id = getId(req);
        danhMucService.xoaTheoId(id);
        doiTuongTraVe.setThongBao("Xóa thành công");
        mapper.writeValue(resp.getOutputStream(), doiTuongTraVe);
    }

    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
