package com.example.websitebangiay.Repository;

import com.example.websitebangiay.Entity.ChiTietDonHang;
import com.example.websitebangiay.Entity.NhanHieu;
import com.example.websitebangiay.Utils.JpaUtils;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;

@ManagedBean
public class ChiTietDonHangRepository {
    private EntityManager entityManager = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
    public ChiTietDonHang save(ChiTietDonHang chiTietDonHang){
        entityManager.persist(chiTietDonHang);
        entityManager.flush();
        System.out.println("Khong luu chi tiet don hang");
        return chiTietDonHang;
    }

}
