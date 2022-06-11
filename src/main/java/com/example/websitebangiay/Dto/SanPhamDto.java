package com.example.websitebangiay.Dto;

import lombok.*;


import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SanPhamDto implements Serializable {
    private Long id;
    private String ten;
    private Long gia;
    private String gioiTinh;
    private String mauSac;
    private Integer soLuong;
    private String moTa;
    private Long danhMuc;
    private Long nhanHieu;
    private File anh;
    private String path;

}
