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
        GioHang gioHang = null;
        try {
            gioHang = (GioHang) entityManager.createQuery("SELECT gh FROM GioHang gh WHERE gh.nguoiDung = :nd").setParameter("nd", nguoiDung).getSingleResult();
        }catch (Exception e){

        }
        return gioHang;
    }

    public GioHang save(GioHang gioHang) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gioHang);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return gioHang;
    }
}
