package com.example.websitebangiay.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "chi_muc_gio_hang")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChiMucGioHang implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    @Column(name = "so_luong", nullable = false)
    private int soLuong;
    @Column(name = "id_gio_hang")
    private Long idGioHang;
    @Column(name = "id_san_pham")
    private Long idSanPham;

    @ManyToOne
    @JoinColumn(name = "id_gio_hang")
    private GioHang gioHang;

}
