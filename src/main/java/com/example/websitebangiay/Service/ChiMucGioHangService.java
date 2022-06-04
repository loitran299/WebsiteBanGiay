package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.ChiMucGioHang;
import com.example.websitebangiay.Entity.GioHang;
import com.example.websitebangiay.Entity.SanPham;

import java.util.List;

public interface ChiMucGioHangService {
    ChiMucGioHang timTheoSanPhamVaGioHang(SanPham sp, GioHang gh);
    ChiMucGioHang luuChiMuc(ChiMucGioHang chiMucGioHang);
    List<ChiMucGioHang> timTheoGiohang(GioHang gioHang);
    ChiMucGioHang timTheoId(Long id);
    void xoaTheoId(Long id);
    void xoaChiMuc(ChiMucGioHang chiMucGioHang);
}
