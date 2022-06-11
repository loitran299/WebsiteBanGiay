package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.DanhMuc;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@ManagedBean
public class DanhMucRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }

    public List findAll(){
        return entityManager.createQuery("select nh from DanhMuc nh").getResultList();
    }

    public void save(DanhMuc danhMuc){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(danhMuc);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    public DanhMuc findById(Long id){
        return entityManager.find(DanhMuc.class, id);
    }

    public DanhMuc findByTen (String ten) {
        DanhMuc danhMuc = null;
        try {
            danhMuc = (DanhMuc) entityManager.createQuery("SELECT nh FROM DanhMuc nh WHERE nh.ten = :ten")
                    .setParameter("ten", ten)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        return danhMuc;
    }


    public void deleteById(Long id){
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM DanhMuc nh WHERE nh.id = :id").setParameter("id",id).executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }
}
