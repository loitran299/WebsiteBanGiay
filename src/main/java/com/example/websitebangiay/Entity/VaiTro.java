package com.example.websitebangiay.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "vai_tro")
@lombok.Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VaiTro implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "ten_vai_tro")
    private String tenVaiTro;

    @Column(name = "ten_vai_tro")
    private String ten;

    @JsonIgnore
    @ManyToMany(mappedBy = "vaiTro")
    private Set<NguoiDung> nguoiDung;

    public VaiTro(String ten) {
        this.ten = ten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
