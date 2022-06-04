package com.example.websitebangiay.Service.Bus;



import com.example.websitebangiay.Entity.VaiTro;
import com.example.websitebangiay.Repository.VaiTroRepository;
import com.example.websitebangiay.Service.VaiTroService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ManagedBean
public class VaiTroServiceImpl implements VaiTroService {

    @Inject
    private VaiTroRepository vaiTroRepository;


    @Override
    public Set<VaiTro> getRoleAdmins() {
        Set<VaiTro> vaiTros = new HashSet<VaiTro>();
        vaiTros.add(vaiTroRepository.findByTen("ROLE_ADMIN"));
        return vaiTros;
    }

    @Override
    public Set<VaiTro> getRoleUsers() {
        Set<VaiTro> vaiTros = new HashSet<VaiTro>();
        vaiTros.add(vaiTroRepository.findByTen("ROLE_USER"));
        return vaiTros;
    }

    @Override
    public VaiTro timTheoTen(String ten) {
        return vaiTroRepository.findByTen(ten);
    }

    @Override
    public VaiTro vaiTroQuanTri() {
        return vaiTroRepository.findByTen("ROLE_ADMIN");
    }

    @Override
    public List getAll() {
        return vaiTroRepository.findAll();
    }



}
