package com.example.websitebangiay.Service;



import com.example.websitebangiay.Entity.VaiTro;

import java.util.List;
import java.util.Set;

public interface VaiTroService {
    Set<VaiTro> getRoleAdmins();
    Set<VaiTro> getRoleUsers();
    VaiTro timTheoTen(String ten);
    VaiTro vaiTroQuanTri();
    List<VaiTro> getAll();
}
