package com.example.websitebangiay.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLUpdate;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "don_hang")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DonHang implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "ho_ten")
    private String hoTen;

    @JsonIgnore
    @OneToMany(mappedBy = "donHang")
    private List<ChiTietDonHang> chiTiets;

    @Column(name = "ngay_dat")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
    private Date ngayDat;
    @Column(name = "ngay_giao")
    private Date ngayGiao;


    @Column(name = "ngay_nhan")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
    private Date ngayNhan;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "trang_thai")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung nguoiDung;

    @Column(name = "tong_gia")
    private long tongGia;

}
