package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.DonHang;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import java.util.List;

@ManagedBean
public class DonHangRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
    public List findAll(){
        return entityManager.createQuery("select sp from SanPham sp").getResultList();
    }

    public DonHang save(DonHang sanPham){
        entityManager.persist(sanPham);
        entityManager.flush();
        return sanPham;
    }

    public DonHang findById(Long id) {
        return entityManager.find(DonHang.class, id);
    }
}
