package com.example.websitebangiay.Service.Bus;


import com.example.websitebangiay.Entity.ChiMucGioHang;
import com.example.websitebangiay.Entity.GioHang;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Repository.ChiMucGioHangRepository;
import com.example.websitebangiay.Service.ChiMucGioHangService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class ChiMucGioHangServiceImpl implements ChiMucGioHangService {
    @Inject
    private ChiMucGioHangRepository chiMucGioHangRepository;

    @Override
    public ChiMucGioHang timTheoSanPhamVaGioHang(SanPham sp, GioHang gh) {
        return chiMucGioHangRepository.findChiMucGioHangBySanPhamAndGioHang(sp,gh);
    }

    @Override
    public ChiMucGioHang luuChiMuc(ChiMucGioHang chiMucGioHang) {
        return chiMucGioHangRepository.save(chiMucGioHang);
    }

    @Override
    public List timTheoGiohang(GioHang gioHang) {
        return chiMucGioHangRepository.findChiMucGioHangsByGioHang(gioHang);
    }

    @Override
    public ChiMucGioHang timTheoId(Long id) {
        return chiMucGioHangRepository.findById(id);
    }

    @Override
    public void xoaTheoId(Long id) {
        chiMucGioHangRepository.deleteById(id);
    }

    @Override
    public void xoaChiMuc(ChiMucGioHang chiMucGioHang) {
        chiMucGioHangRepository.delete(chiMucGioHang);
    }
}
