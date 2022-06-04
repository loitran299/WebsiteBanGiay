package com.example.websitebangiay.Service;


import com.example.websitebangiay.Dto.SanPhamDto;
import com.example.websitebangiay.Entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> tatCaSanPham();
    void luuSanPham(SanPham sanPham);
    boolean sanPhamTonTai(String ten);
    Long luuSanPham(SanPhamDto sanPhamDto);
    void xoaSanPham(Long id);
    SanPham timTheoId(Long id);
}
