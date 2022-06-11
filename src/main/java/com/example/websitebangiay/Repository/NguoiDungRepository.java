package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.*;
import java.util.List;

@ManagedBean
public class NguoiDungRepository {

    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }

    public List findAll(){
        return entityManager.createQuery("select nd from NguoiDung nd").getResultList();
    }


    public void save(NguoiDung nguoiDung){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(nguoiDung);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    public void update(NguoiDung nguoiDung){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(nguoiDung);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    public NguoiDung findById(Long id){
        return entityManager.find(NguoiDung.class, id);
    }

    public NguoiDung findByTenDangNhap(String ten){
        NguoiDung nguoiDung = null;
        try {
            nguoiDung = (NguoiDung) entityManager.createQuery("select nd from NguoiDung nd where nd.tenDangNhap = :tdn")
                    .setParameter("tdn", ten)
                    .getSingleResult();
        }catch (NoResultException e){
            e.getMessage();
        }

        return nguoiDung;
    }

    public void deleteById(Long id){
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM NguoiDung nd WHERE nd.id = :id").setParameter("id",id).executeUpdate();
            System.out.println("da xoa tai khoan");
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }


}
