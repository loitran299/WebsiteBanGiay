package com.example.websitebangiay.Service.Bus;


import com.example.websitebangiay.Entity.DonHang;
import com.example.websitebangiay.Repository.DonHangRepository;
import com.example.websitebangiay.Service.DonHangService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;


@ManagedBean
public class DonHangServiceImpl implements DonHangService {

    @Inject
    private DonHangRepository donHangRepository;

    @Override
    public DonHang luuDonHang(DonHang donHang) {
        return donHangRepository.save(donHang);
    }

    @Override
    public DonHang updateDonHang(DonHang donHang) {
        return donHangRepository.update(donHang);
    }

    @Override
    public List layTatCaDonHang() {
        return donHangRepository.findAll();
    }

    @Override
    public void hoanThanhDonHang(Long id) {
        DonHang donHang = donHangRepository.findById(id);
        donHang.setTrangThai("hoanthanh");
        donHang.setNgayNhan(new Date());
        donHangRepository.update(donHang);
    }
}
