package com.example.websitebangiay.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "nhan_hieu")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class NhanHieu implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "nhanHieu")
    private List<SanPham> sanPhams;

    public NhanHieu(String ten) {
        this.ten = ten;
    }
}
