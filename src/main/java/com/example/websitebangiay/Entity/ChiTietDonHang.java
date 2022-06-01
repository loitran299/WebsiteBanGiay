package com.example.websitebangiay.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "chi_tiet_don_hang")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChiTietDonHang implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    @Column(name = "don_gia", nullable = false)
    private long donGia;
    @Column(name = "so_luong", nullable = false)
    private int soLuong;
    @Column(name = "id_don_hang")
    private Long idDonHang;
    @Column(name = "id_san_pham")
    private Long idSanPham;

    @ManyToOne
    @JoinColumn(name = "id_don_hang")
    private DonHang donHang;


}
