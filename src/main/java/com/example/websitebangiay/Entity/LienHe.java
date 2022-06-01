package com.example.websitebangiay.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "lien_he")
@Data
@Entity
public class LienHe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "email")
    private String email;

    @Column(name = "loi_nhan")
    private String loiNhan;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
