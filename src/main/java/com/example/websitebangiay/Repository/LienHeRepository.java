package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.LienHe;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import java.util.List;

@ManagedBean
public class LienHeRepository {

    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }

    public List findAll() {
        return entityManager.createQuery("SELECT lh FROM LienHe lh").getResultList();
    }

    public LienHe save(LienHe lienHe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(lienHe);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return lienHe;
    }

    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM LienHe lh WHERE lh.id = :id")
                    .setParameter("id", id).executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    public LienHe findById(Long id) {
        return entityManager.find(LienHe.class, id);
    }
}
