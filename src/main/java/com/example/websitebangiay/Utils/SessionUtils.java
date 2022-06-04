package com.example.websitebangiay.Utils;

import javax.annotation.ManagedBean;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class SessionUtils {

    public void putValue(HttpServletRequest request, String key, Object value){
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key){
        request.getSession().removeAttribute(key);
    }
}
