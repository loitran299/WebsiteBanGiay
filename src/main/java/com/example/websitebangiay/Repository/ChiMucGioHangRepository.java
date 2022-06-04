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
        return (ChiMucGioHang) entityManager.createQuery("SELECT cm FROM ChiMucGioHang cm WHERE cm.sanPham = :sp AND cm.gioHang = :gh")
                .setParameter("sp", sp)
                .setParameter("gh", gh)
                .getSingleResult();
    }

    public ChiMucGioHang save(ChiMucGioHang chiMucGioHang) {
        entityManager.persist(chiMucGioHang);
        entityManager.flush();
        return chiMucGioHang;
    }

    public List findChiMucGioHangsByGioHang(GioHang gioHang) {
        return entityManager.createQuery("SELECT cm FROM ChiMucGioHang cm WHERE cm.gioHang = :gh")
                .setParameter("gh", gioHang)
                .getResultList();
    }

    public ChiMucGioHang findById(Long id) {
        return entityManager.find(ChiMucGioHang.class, id);
    }

    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM ChiMucGioHang cm WHERE cm.id = :id")
                .setParameter("id", id);
    }

    public void delete(ChiMucGioHang chiMucGioHang) {
        entityManager.remove(chiMucGioHang);
    }
}
