package com.example.websitebangiay.Service;


import com.example.websitebangiay.Entity.LienHe;

import java.util.List;

public interface LienHeService {
    LienHe luuLienHe(LienHe lienHe);
    List<LienHe> tatCaLienHe();
    void xoaLienHe(Long id);
    LienHe timTheoId(Long id);
}
