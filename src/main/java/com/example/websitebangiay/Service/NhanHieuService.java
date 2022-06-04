package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.NhanHieu;

import java.util.List;

public interface NhanHieuService {
    void save(String name);
    void save(NhanHieu nhanHieu);
    List<NhanHieu> getAll();
    boolean nhanHieuTonTai(NhanHieu nhanHieu);
    void deleteById(Long id);
    NhanHieu timTheoTen(String ten);
    NhanHieu timTheoId(Long id);
}
