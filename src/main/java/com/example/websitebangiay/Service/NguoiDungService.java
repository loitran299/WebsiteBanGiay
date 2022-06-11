package com.example.websitebangiay.Service;



import com.example.websitebangiay.Dto.NguoiDungDto;
import com.example.websitebangiay.Entity.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    boolean nguoiDungTonTai(String username);
    NguoiDung findByTenDangNhap(String userName);
    void saveUser(NguoiDung nguoiDung);
    List<NguoiDung> getAll();
    void deleteById(Long id);
    NguoiDung getById(Long id);
    void update(NguoiDungDto user);
    void save(NguoiDungDto user);
    void updateNguoiDung(NguoiDung nguoiDung);
}
