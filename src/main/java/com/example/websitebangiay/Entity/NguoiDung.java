package com.example.websitebangiay.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "nguoi_dung")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NguoiDung implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ho_ten")
    private String hoTen;


    @Column(name = "ten_dang_nhap",unique = true)
    private String tenDangNhap;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "mat_khau")
    @JsonIgnore
    private String matKhau;


    @ManyToMany
    @JoinTable(name = "vaiTro_nguoiDung",
    joinColumns = @JoinColumn(name = "id_nguoi_dung"),
    inverseJoinColumns = @JoinColumn(name = "id_vaiTro"))
    private Set<VaiTro> vaiTro;

    @JsonIgnore
    @Transient
    private String matKhauXacThuc;

    @JsonIgnore
    @Transient
    @OneToMany(mappedBy = "nguoiDung")
    private List<DonHang> donHangs;

    public NguoiDung(String tenDangNhap, String email, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.email = email;
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getEmail() {
        return email;
    }

    public Set<VaiTro> getVaiTro() {
        return vaiTro;
    }

    public void setTenDangNhap(String userName) {
        this.tenDangNhap = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVaiTro(Set<VaiTro> vaiTro) {
        this.vaiTro = vaiTro;
    }
}
