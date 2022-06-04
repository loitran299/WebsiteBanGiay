package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.VaiTro;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@ManagedBean
public class VaiTroRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }

    public List findAll(){
        return entityManager.createQuery("SELECT vt FROM VaiTro vt").getResultList();
    }

    public VaiTro findByTen(String ten){
        return (VaiTro) entityManager.createQuery("SELECT vt FROM VaiTro vt WHERE vt.ten = :ten")
                .setParameter("ten",ten)
                .getSingleResult();
    }

}
