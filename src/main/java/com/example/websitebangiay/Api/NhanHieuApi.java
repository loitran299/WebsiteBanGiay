package com.example.websitebangiay.Api;

import com.example.websitebangiay.Entity.DoiTuongTraVe;
import com.example.websitebangiay.Entity.NhanHieu;
import com.example.websitebangiay.Service.NhanHieuService;
import com.example.websitebangiay.Utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/nhanhieu/*"})
public class NhanHieuApi extends HttpServlet {
    @Inject
    private NhanHieuService nhanHieuService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String path = req.getPathInfo();
        if (path.endsWith("/all")){
            mapper.writeValue(resp.getOutputStream(), nhanHieuService.getAll());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NhanHieu nhanHieu = HttpUtils.of(req.getReader()).toEntity(NhanHieu.class);
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        if (nhanHieuService.nhanHieuTonTai(nhanHieu)){
            doiTuongTraVe.setThongBao("Nhãn hiệu đã tồn tại");
        }else {
            nhanHieuService.save(nhanHieu);
            doiTuongTraVe.setThongBao("Thêm thành công");
        }
        mapper.writeValue(resp.getOutputStream(), doiTuongTraVe);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Long id = getId(req);
        nhanHieuService.deleteById(id);
    }

    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
