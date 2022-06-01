package com.example.websitebangiay.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "gio_hang")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GioHang implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tong_gia", nullable = false)
    private long tongGia;
    @Column(name = "id_nguoi_dung")
    private Long idNguoiDung;

    @OneToOne
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung nguoiDung;

    @JsonIgnore
    @OneToMany(mappedBy = "gioHang")
    private List<ChiMucGioHang> chiMucGioHangs;

}
