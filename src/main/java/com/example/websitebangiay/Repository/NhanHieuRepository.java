package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.NhanHieu;
import com.example.websitebangiay.Entity.SanPham;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(nhanHieu);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    public NhanHieu findById(Long id){
        return entityManager.find(NhanHieu.class, id);
    }

    public NhanHieu findByTen (String ten) {
        NhanHieu nhanHieu = null;
        try {
            nhanHieu = (NhanHieu) entityManager.createQuery("SELECT nh FROM NhanHieu nh WHERE nh.ten = :ten")
                    .setParameter("ten", ten)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
//            return null;
        }
        return nhanHieu;
    }

    public void deleteById(Long id){
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM NhanHieu nh WHERE nh.id = :id").setParameter("id",id).executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }
}
