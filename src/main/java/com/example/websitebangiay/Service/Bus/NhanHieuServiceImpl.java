package com.example.websitebangiay.Service.Bus;


import com.example.websitebangiay.Entity.NhanHieu;
import com.example.websitebangiay.Repository.NhanHieuRepository;
import com.example.websitebangiay.Service.NhanHieuService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class NhanHieuServiceImpl implements NhanHieuService {

    @Inject
    private NhanHieuRepository nhanHieuRepository;


    @Override
    public void save(String name) {
        nhanHieuRepository.save(new NhanHieu(name));
    }

    @Override
    public void save(NhanHieu nhanHieu) {
        nhanHieuRepository.save(nhanHieu);
    }

    @Override
    public List<NhanHieu> getAll() {
        return nhanHieuRepository.findAll();
    }

    @Override
    public boolean nhanHieuTonTai(NhanHieu nhanHieu) {
        if(nhanHieuRepository.findByTen(nhanHieu.getTen()) != null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(Long id) {
        nhanHieuRepository.deleteById(id);
    }

    @Override
    public NhanHieu timTheoTen(String ten) {
        return nhanHieuRepository.findByTen(ten);
    }

    @Override
    public NhanHieu timTheoId(Long id) {
        return nhanHieuRepository.findById(id);
    }


}
