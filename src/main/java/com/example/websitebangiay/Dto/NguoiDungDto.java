package com.example.websitebangiay.Dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NguoiDungDto implements Serializable {
    private Long id;
    private String hoTen;
    private String tenDangNhap;
    private String email;
    private String diaChi;
    private String matKhau;
    private String tenVaiTro;


}
