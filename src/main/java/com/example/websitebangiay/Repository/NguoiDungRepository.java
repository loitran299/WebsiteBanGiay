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
        entityManager.persist(nguoiDung);
    }

    public void update(NguoiDung nguoiDung){
        entityManager.merge(nguoiDung);
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
        entityManager.createQuery("DELETE FROM NguoiDung nd WHERE nd.id = :id").setParameter("id",id);
    }


}
