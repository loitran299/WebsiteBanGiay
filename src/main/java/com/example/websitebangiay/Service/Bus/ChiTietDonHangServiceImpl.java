package com.example.websitebangiay.Service.Bus;

import com.example.websitebangiay.Entity.ChiMucGioHang;
import com.example.websitebangiay.Entity.ChiTietDonHang;
import com.example.websitebangiay.Entity.DonHang;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Repository.ChiTietDonHangRepository;
import com.example.websitebangiay.Service.ChiTietDonHangService;
import com.example.websitebangiay.Service.SanPhamService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService {
    @Inject
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Inject
    private SanPhamService sanPhamService;

    @Override
    public ChiTietDonHang luuChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        return chiTietDonHangRepository.save(chiTietDonHang);
    }

    @Override
    public ChiTietDonHang luuChiTietDonHang(ChiMucGioHang chiMucGioHang, DonHang donHang) {
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        chiTietDonHang.setDonHang(donHang);
        chiTietDonHang.setSanPham(chiMucGioHang.getSanPham());
        chiTietDonHang.setSoLuong(chiMucGioHang.getSoLuong());
        Long donGia = chiMucGioHang.getSoLuong() * chiMucGioHang.getSanPham().getGia();
        chiTietDonHang.setDonGia(donGia);
        return chiTietDonHangRepository.save(chiTietDonHang);
    }

}
