package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.ChiMucGioHang;
import com.example.websitebangiay.Entity.ChiTietDonHang;
import com.example.websitebangiay.Entity.GioHang;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import java.util.List;

@ManagedBean
public class ChiMucGioHangRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }

    public ChiMucGioHang findChiMucGioHangBySanPhamAndGioHang(SanPham sp, GioHang gh) {
        ChiMucGioHang chiMucGioHang = null;
        try {
            chiMucGioHang = (ChiMucGioHang) entityManager.createQuery("SELECT cm FROM ChiMucGioHang cm WHERE cm.sanPham = :sp AND cm.gioHang = :gh")
                    .setParameter("sp", sp)
                    .setParameter("gh", gh)
                    .getSingleResult();
        }catch (Exception e){

        }

        return chiMucGioHang;
    }

    public ChiMucGioHang save(ChiMucGioHang chiMucGioHang) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(chiMucGioHang);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return chiMucGioHang;
    }

    public List findChiMucGioHangsByGioHang(GioHang gioHang) {
        List list = null;
        try {
            list = entityManager.createQuery("SELECT cm FROM ChiMucGioHang cm WHERE cm.gioHang = :gh")
                    .setParameter("gh", gioHang)
                    .getResultList();
        }catch (Exception e){

        }
        return list;
    }

    public ChiMucGioHang findById(Long id) {
        return entityManager.find(ChiMucGioHang.class, id);
    }

    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM ChiMucGioHang cm WHERE cm.id = :id")
                    .setParameter("id", id).executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    public void delete(ChiMucGioHang chiMucGioHang) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(chiMucGioHang);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
