package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.GioHang;
import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;

@ManagedBean
public class GioHangRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }


    public GioHang findGioHangByNguoiDung(NguoiDung nguoiDung) {
        return (GioHang) entityManager.createQuery("SELECT gh FROM GioHang gh WHERE gh.nguoiDung = :nd").setParameter("nd", nguoiDung).getSingleResult();
    }

    public GioHang save(GioHang gioHang) {
        entityManager.persist(gioHang);
        entityManager.flush();
        return gioHang;
    }
}
