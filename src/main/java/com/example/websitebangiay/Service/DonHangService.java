package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.DonHang;

import java.util.List;

public interface DonHangService {
    DonHang luuDonHang(DonHang donHang);
    DonHang updateDonHang(DonHang donHang);
    List<DonHang> layTatCaDonHang();
    void hoanThanhDonHang(Long id);
}
