package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.NhanHieu;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import java.util.List;

@ManagedBean
public class NhanHieuRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
    public List findAll(){
        return entityManager.createQuery("select nh from NhanHieu nh").getResultList();
    }

    public void save(NhanHieu nhanHieu){
        entityManager.persist(nhanHieu);
    }

    public NhanHieu findById(Long id){
        return entityManager.find(NhanHieu.class, id);
    }

    public NhanHieu findByTen (String ten) {
        return (NhanHieu) entityManager.createQuery("SELECT nh FROM NhanHieu nh WHERE nh.ten = :ten")
                .setParameter("ten", ten)
                .getSingleResult();
    }

    public void deleteById(Long id){
        entityManager.createQuery("DELETE FROM NhanHieu nh WHERE nh.id = :id").setParameter("id",id);
    }
}
