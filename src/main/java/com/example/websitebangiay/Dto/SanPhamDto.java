package com.example.websitebangiay.Dto;

import lombok.Data;


import javax.servlet.http.Part;
import java.io.Serializable;

@Data
public class SanPhamDto implements Serializable {
    private final Long id;
    private final String ten;
    private final long gia;
    private final String gioiTinh;
    private final String mauSac;
    private final int soLuong;
    private final String moTa;
    private Long danhMuc;
    private Long nhanHieu;
    private Part anh;

    public SanPhamDto(Long id, String ten, long gia, String gioiTinh, String mauSac, int soLuong, String moTa, Long danhMuc, Long nhanHieu, Part anh) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.gioiTinh = gioiTinh;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
        this.nhanHieu = nhanHieu;
        this.anh = anh;
    }
}
