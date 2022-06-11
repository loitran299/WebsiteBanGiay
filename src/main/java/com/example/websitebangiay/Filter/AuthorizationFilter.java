package com.example.websitebangiay.Filter;

import com.example.websitebangiay.Entity.NguoiDung;
import com.example.websitebangiay.Utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        if (url.startsWith("/admin")) {
            NguoiDung nguoiDung = (NguoiDung) SessionUtils.getValue(request, "NGUOIDUNG");
            if (nguoiDung != null) {
                if (nguoiDung.laAdmin()){
                    filterChain.doFilter(servletRequest, servletResponse);
                }else{
                    response.sendRedirect(request.getContextPath()+"/dang-nhap?khongthetruycap");
                }
            }else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?chuadangnhap");
            }
        }else if (url.equals("/gio-hang") || url.equals("/thong-tin-tai-khoan") || url.equals("/xac-nhan-don-hang")){
            NguoiDung nguoiDung = (NguoiDung) SessionUtils.getValue(request, "NGUOIDUNG");
            if (nguoiDung != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
            }else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?chuadangnhap");
            }
        }
        else if(url.startsWith("/api")){
//            if(url.equals("/api/sanpham/luu")){
//
//                System.out.println(servletContext.getRealPath("file"));
//            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
