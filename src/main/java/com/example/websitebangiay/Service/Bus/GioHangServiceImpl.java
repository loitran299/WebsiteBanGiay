package com.example.websitebangiay.Service.Bus;


import com.example.websitebangiay.Entity.GioHang;
import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Repository.GioHangRepository;
import com.example.websitebangiay.Service.GioHangService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class GioHangServiceImpl implements GioHangService {
    @Inject
    private GioHangRepository gioHangRepository;

    @Override
    public GioHang timTheoNguoiDung(NguoiDung nguoiDung) {
        return gioHangRepository.findGioHangByNguoiDung(nguoiDung);
    }

    @Override
    public GioHang luuGioHang(GioHang gioHang) {
        return gioHangRepository.save(gioHang);
    }
}
