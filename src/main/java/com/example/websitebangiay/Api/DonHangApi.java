package com.example.websitebangiay.Api;

import com.example.websitebangiay.Entity.DonHang;
import com.example.websitebangiay.Service.DonHangService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DonHangApi", urlPatterns = {"/api/donhang/*"})
public class DonHangApi extends HttpServlet {
    @Inject
    private DonHangService donHangService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DonHang> list = donHangService.layTatCaDonHang();
        mapper.writeValue(resp.getOutputStream(),list);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        donHangService.hoanThanhDonHang(getId(req));
    }

    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
