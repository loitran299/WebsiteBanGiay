package com.example.websitebangiay.Api;

import com.example.websitebangiay.Dto.LienHeDto;
import com.example.websitebangiay.Entity.LienHe;
import com.example.websitebangiay.Service.LienHeService;
import com.example.websitebangiay.Utils.HttpUtils;
import com.example.websitebangiay.Utils.SendEmailUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LienHeApi", urlPatterns = {"/api/lienhe/*"})
public class LienHeApi extends HttpServlet {
    @Inject
    private LienHeService lienHeService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(), lienHeService.tatCaLienHe());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        LienHeDto lienHeDto = HttpUtils.of(req.getReader()).toEntity(LienHeDto.class);
        LienHe lienHe = lienHeService.timTheoId(lienHeDto.getId());
        String email = lienHe.getEmail();
        lienHeService.xoaLienHe(lienHeDto.getId());
        SendEmailUtils.getInstance().sendEmail(email,lienHeDto.getTieuDe(),lienHeDto.getTraLoi());

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        lienHeService.xoaLienHe(getId(req));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        LienHe lienHe = HttpUtils.of(req.getReader()).toEntity(LienHe.class);
        lienHeService.luuLienHe(lienHe);
    }
    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
