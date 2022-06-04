package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.ChiMucGioHang;
import com.example.websitebangiay.Entity.ChiTietDonHang;
import com.example.websitebangiay.Entity.DonHang;

public interface ChiTietDonHangService {
    ChiTietDonHang luuChiTietDonHang(ChiTietDonHang chiTietDonHang);
    ChiTietDonHang luuChiTietDonHang(ChiMucGioHang chiMucGioHang, DonHang donHang);
}
