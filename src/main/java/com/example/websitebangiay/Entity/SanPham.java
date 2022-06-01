package com.example.websitebangiay.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Table(name = "san_pham")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanPham implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "path_anh")
    private String pathAnh;

    @Column(name = "ten")
    private String ten;
    @Column(name = "id_danh_muc")
    private Long idDanhMuc;
    @Column(name = "id_nhan_hieu")
    private Long idNhanHieu;
    @Column(name = "gia", nullable = false)
    private long gia;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "so_luong", nullable = false)
    private int soLuong;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "id_nhan_hieu")
    private NhanHieu nhanHieu;

    @Column(length = 6000)
    private String moTa;
}
