package com.example.websitebangiay.Service.Bus;


import com.example.websitebangiay.Entity.DanhMuc;
import com.example.websitebangiay.Repository.DanhMucRepository;
import com.example.websitebangiay.Service.DanhMucService;

import javax.inject.Inject;
import java.util.List;


public class DanhMucServiceImpl implements DanhMucService {
    @Inject
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> tatCaDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Override
    public void xoaBoiID(Long id) {
        danhMucRepository.deleteById(id);
    }

    @Override
    public boolean danhMucTonTai(DanhMuc danhMuc) {
        if(danhMucRepository.findByTen(danhMuc.getTen()) != null) return true;
        return false;
    }

    @Override
    public void luuDanhMuc(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMuc timTheoTen(String ten) {
        return danhMucRepository.findByTen(ten);
    }

    @Override
    public DanhMuc timTheoId(Long id) {
        return danhMucRepository.findById(id);
    }
}
