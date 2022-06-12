package com.example.websitebangiay.Service.Bus;



import com.example.websitebangiay.Dto.NguoiDungDto;
import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Entity.VaiTro;
import com.example.websitebangiay.Repository.NguoiDungRepository;
import com.example.websitebangiay.Repository.VaiTroRepository;
import com.example.websitebangiay.Service.NguoiDungService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@ManagedBean
public class NguoiDungServiceImpl implements NguoiDungService {

    @Inject
    private NguoiDungRepository nguoiDungRepository;

    @Inject
    private VaiTroRepository vaiTroRepository;



    @Override
    public boolean nguoiDungTonTai(String username) {
        if(nguoiDungRepository.findByTenDangNhap(username) != null) return true;
        return false;
    }

    @Override
    public NguoiDung findByTenDangNhap(String tenDangNhap) {
        return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
    }

    @Override
    public void saveUser(NguoiDung nguoiDung) {
        Set<VaiTro> vaiTros = new HashSet<VaiTro>();
        vaiTros.add(vaiTroRepository.findByTen("ROLE_USER"));
        nguoiDung.setVaiTro(vaiTros);

        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public List getAll() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        nguoiDungRepository.deleteById(id);
    }

    @Override
    public NguoiDung getById(Long id) {
        return nguoiDungRepository.findById(id);
    }

    @Override
    public void update(NguoiDungDto user) {
        NguoiDung oldNguoiDung = nguoiDungRepository.findByTenDangNhap(user.getTenDangNhap());
        if (!Objects.equals(user.getMatKhau(), "")) {
            oldNguoiDung.setMatKhau(user.getMatKhau());
        }
        oldNguoiDung.setEmail(user.getEmail());
        oldNguoiDung.setDiaChi(user.getDiaChi());
        oldNguoiDung.setHoTen(user.getHoTen());
        nguoiDungRepository.update(oldNguoiDung);
    }

    @Override
    public void save(NguoiDungDto nguoiDungDto) {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setTenDangNhap(nguoiDungDto.getTenDangNhap());
        nguoiDung.setMatKhau(nguoiDungDto.getMatKhau());
        nguoiDung.setEmail(nguoiDungDto.getEmail());
        nguoiDung.setDiaChi(nguoiDungDto.getDiaChi());
        Set<VaiTro> vaiTros = new HashSet<VaiTro>();
        vaiTros.add(vaiTroRepository.findByTen(nguoiDungDto.getTenVaiTro()));
        nguoiDung.setVaiTro(vaiTros);
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void updateNguoiDung(NguoiDung nguoiDung) {
        nguoiDungRepository.update(nguoiDung);
    }


}
