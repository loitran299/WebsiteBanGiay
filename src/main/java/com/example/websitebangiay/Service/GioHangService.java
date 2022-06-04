package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.GioHang;
import com.example.websitebangiay.Entity.NguoiDung;

public interface GioHangService {
    GioHang timTheoNguoiDung(NguoiDung nguoiDung);
    GioHang luuGioHang(GioHang gioHang);
}
