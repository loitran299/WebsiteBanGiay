package com.example.websitebangiay.Service.Bus;



import com.example.websitebangiay.Dto.SanPhamDto;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Repository.SanPhamRepository;
import com.example.websitebangiay.Service.DanhMucService;
import com.example.websitebangiay.Service.NhanHieuService;
import com.example.websitebangiay.Service.SanPhamService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@ManagedBean
public class SanPhamServiceImpl implements SanPhamService {

    @Inject
    private SanPhamRepository sanPhamRepository;

    @Inject
    private NhanHieuService nhanHieuService;

    @Inject
    private DanhMucService danhMucService;

    private ServletContext app;

    @Override
    public List<SanPham> tatCaSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void luuSanPham(SanPham sanPham) {
//        sanPhamRepository.save(sanPham);
    }

    @Override
    public boolean sanPhamTonTai(String ten) {
//        if(sanPhamRepository.findSanPhamByTen(ten) != null) return true;
//        return false;
        return false;
    }

    @Override
    public Long luuSanPham(SanPhamDto sanPhamDto) {
        SanPham sanPham = new SanPham();
        sanPham.setTen(sanPhamDto.getTen());
        sanPham.setGia(sanPhamDto.getGia());
        System.out.println("nhan hieu: "+nhanHieuService.timTheoId(sanPhamDto.getNhanHieu()));
        sanPham.setNhanHieu(nhanHieuService.timTheoId(sanPhamDto.getNhanHieu()));
        sanPham.setDanhMuc(danhMucService.timTheoId(sanPhamDto.getDanhMuc()));

        sanPham.setMauSac(sanPhamDto.getMauSac());
        sanPham.setGioiTinh(sanPhamDto.getGioiTinh());
        sanPham.setMoTa(sanPhamDto.getMoTa());
        sanPham.setSoLuong(sanPhamDto.getSoLuong());
        sanPhamRepository.save(sanPham);
        sanPham.setPathAnh("/img/" +sanPham.getId()+ sanPhamDto.getAnh().getName());
        sanPhamRepository.save(sanPham);
        return sanPham.getId();
    }

    @Override
    public void xoaSanPham(Long id) {
        SanPham sanPham = sanPhamRepository.findById(id);
        String path = app.getRealPath("/");
        String filePath = path + "/WEB-INF/template"+sanPham.getPathAnh();
        File file = new File(filePath);
        file.delete();
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham timTheoId(Long id) {
        return sanPhamRepository.findById(id);
    }

}
