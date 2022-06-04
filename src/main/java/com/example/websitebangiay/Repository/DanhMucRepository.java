package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.DanhMuc;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
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
        entityManager.persist(danhMuc);
    }

    public DanhMuc findById(Long id){
        return entityManager.find(DanhMuc.class, id);
    }

    public DanhMuc findByTen (String ten) {
        return (DanhMuc) entityManager.createQuery("SELECT nh FROM DanhMuc nh WHERE nh.ten = :ten")
                .setParameter("ten", ten)
                .getSingleResult();
    }


    public void deleteById(Long id){
        entityManager.createQuery("DELETE FROM DanhMuc nh WHERE nh.id = :id").setParameter("id",id);
    }
}
