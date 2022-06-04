package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import java.util.List;

@ManagedBean
public class SanPhamRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }

    public List findAll(){
        return entityManager.createQuery("select sp from SanPham sp").getResultList();
    }

    public void save(SanPham sanPham){
        entityManager.persist(sanPham);
    }

    public SanPham findById(Long id){
        return entityManager.find(SanPham.class, id);
    }



    public void deleteById(Long id){
        entityManager.createQuery("DELETE FROM SanPham sp WHERE sp.id = :id").setParameter("id",id);
    }


}
