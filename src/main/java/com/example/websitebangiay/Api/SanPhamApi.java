package com.example.websitebangiay.Api;

import com.example.websitebangiay.Dto.SanPhamDto;
import com.example.websitebangiay.Entity.DoiTuongTraVe;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Service.SanPhamService;
import com.example.websitebangiay.Utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@MultipartConfig(
        maxFileSize = 1024 * 1024 *10
)
@WebServlet(name = "SanPhamApi" ,urlPatterns = {"/api/sanpham/*"})
public class SanPhamApi extends HttpServlet {
    @Inject
    private SanPhamService sanPhamService;


    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            String path = req.getPathInfo();
            List<SanPham> sanPhams = sanPhamService.tatCaSanPham();
            if (path.endsWith("/all")) {
                mapper.writeValue(resp.getOutputStream(), sanPhams);
            } else if (path.equals("/timkiem")) {
                String txt = req.getParameter("txt");
                List<SanPham> ketQua = new ArrayList<>();
                txt = txt.toLowerCase();
                for (SanPham sanPham : sanPhams) {
                    String chuoi = sanPham.getTen() + " " + sanPham.getGioiTinh() + " " + sanPham.getMauSac() + " " + sanPham.getDanhMuc().getTen() + " " + sanPham.getNhanHieu().getTen();
                    chuoi = chuoi.toLowerCase(Locale.ROOT);
                    if (chuoi.contains(txt)) {
                        ketQua.add(sanPham);
                    }
                }
                mapper.writeValue(resp.getOutputStream(), ketQua);
            } else if (path.startsWith("/get")) {
                Long id = getId(req);
                mapper.writeValue(resp.getOutputStream(), sanPhamService.timTheoId(id));
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        Part part = null;
        Collection<Part> a = req.getParts();
        //---------------------------------------------------
        SanPhamDto sanPhamDto = new SanPhamDto();
        sanPhamDto.setTen(req.getParameter("ten"));
        sanPhamDto.setGioiTinh(req.getParameter("gioiTinh"));
        sanPhamDto.setGia(Long.parseLong(req.getParameter("gia")) );
        sanPhamDto.setMauSac(req.getParameter("mauSac"));
        sanPhamDto.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));
        sanPhamDto.setMoTa(req.getParameter("moTa"));
        sanPhamDto.setDanhMuc(Long.parseLong(req.getParameter("danhMuc")));
        sanPhamDto.setNhanHieu(Long.parseLong(req.getParameter("nhanHieu")));
        //--------------------------------------------------------------
        try {
            var arr = a.toArray();
            part = (Part) arr[8];
            String realPath = req.getServletContext().getRealPath("/");
            System.out.println("realPath: "+realPath);
            Part data = (Part) arr[0];
            String tenFile = Path.of(part.getSubmittedFileName()).getFileName().toString();
            System.out.println("tenFile: "+tenFile);
            sanPhamDto.setPath(tenFile);
            SanPham sp = sanPhamService.luuSanPham(sanPhamDto);
            part.write(realPath+"/"+sp.getPathAnh());
            doiTuongTraVe.setThongBao("Lưu thành công!");
        } catch (Exception e){
            doiTuongTraVe.setThongBao("đã xảy ra lỗi");
        }

        mapper.writeValue(resp.getOutputStream(),doiTuongTraVe);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        DoiTuongTraVe doiTuongTraVe = new DoiTuongTraVe();
        try {
            sanPhamService.xoaSanPham(getId(req));
            doiTuongTraVe.setThongBao("Xóa thành công");
        }catch (Exception e){
            doiTuongTraVe.setThongBao("đã xảy ra lỗi");
        }
        mapper.writeValue(resp.getOutputStream(),doiTuongTraVe);

    }

    public Long getId(HttpServletRequest request) {
        String path = request.getPathInfo();
        String[] pathParts = path.split("/");
        Long id = Long.valueOf(pathParts[pathParts.length - 1]);
        return id;
    }
}
