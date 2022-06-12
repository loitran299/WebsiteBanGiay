package com.example.websitebangiay.Service.Bus;


import com.example.websitebangiay.Entity.LienHe;
import com.example.websitebangiay.Repository.LienHeRepository;
import com.example.websitebangiay.Service.LienHeService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class LienHeServiceImpl implements LienHeService {
    @Inject
    private LienHeRepository lienHeRepository;


    @Override
    public LienHe luuLienHe(LienHe lienHe) {
        return lienHeRepository.save(lienHe);
    }



    @Override
    public List tatCaLienHe() {
        return lienHeRepository.findAll();
    }

    @Override
    public void xoaLienHe(Long id) {
        lienHeRepository.deleteById(id);
    }

    @Override
    public LienHe timTheoId(Long id) {
        return lienHeRepository.findById(id);
    }
}
