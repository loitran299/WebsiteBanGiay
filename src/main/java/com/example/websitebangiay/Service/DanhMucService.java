package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.DanhMuc;

import java.util.List;

public interface DanhMucService {
    List<DanhMuc> tatCaDanhMuc();
    void xoaTheoId(Long id);
    boolean danhMucTonTai(DanhMuc danhMuc);
    void luuDanhMuc(DanhMuc danhMuc);
    DanhMuc timTheoTen(String ten);
    DanhMuc timTheoId(Long id);
}
