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
        entityManager.persist(lienHe);
        entityManager.flush();
        return lienHe;
    }

    public void deleteById(Long id) {
        entityManager.createQuery("DELETE FROM LienHe lh WHERE lh.id = :id")
                .setParameter("id", id);
    }

    public LienHe findById(Long id) {
        return entityManager.find(LienHe.class, id);
    }
}
