<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/template/css/quantri.css" />
    <link rel="stylesheet" href="/template/css/header-admin.css">
</head>

<body>

<nav class="thanh-dieu-huong thanh-dieu-huong-nguoc thanh-dieu-huong-fixed-tren">
    <div class="phan-than">
        <div class="phan-than-dau">
            <button class="thanh-dieu-huong-chuyen-doi" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="thanh-dieu-huong-nhan" href="<c:url value='/admin/trang-quan-tri'/>">SHOES - HOME ADMIN</a>
        </div>
        <div class="bien-doi thanh-dieu-huong-bien-doi">
            <ul class="dieu-huong thanh-dieu-huong-dieu-huong thanh-dieu-huong-phai">
                <li>
                    <a href="<c:url value='/admin/thong-tin-tai-khoan' />">
                        <span class="glyphicon glyphicon-nguoiDung">&nbsp;</span>Xin chào: ${NGUOIDUNG.tenDangNhap }</a>
                </li>
                <li>
                    <a href="<c:url value='/dang-xuat' />"><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a>
                </li>
            </ul>
        </div>
    </div>
</nav>