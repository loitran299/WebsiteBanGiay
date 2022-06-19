<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>T-Sneaker</title>
    <!------ Include the above in your HEAD tag ---------->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="/template/css/style.css">
<%--    <link rel="stylesheet" href="/template/css/slide.css">--%>
<%--    <link rel="stylesheet" href="/template/css/reset.css">--%>

    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
            rel="stylesheet"
    />
    <script
            type="module"
            src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
    ></script>
    <script
            nomodule
            src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
    ></script>
    <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
</head>
<body>



<nav class="dieuhuong dieuhuong-thietbilon dieuhuong-den mauden">
    <div class="tong">
        <a class="dieuhuong-thuonghieu" href="/trang-chu">T-Sneaker</a>

        <div class="dieuhuong-canchinh flex-cancuoi">
            <ul class="dieuhuong-trang">
                <li>
                    <a class="duongdan" href="/trang-san-pham">Sản phẩm</a>
                </li>
                <li class="luachon">
                    <a class="luachon-chuyendoi duongdan" href="/trang-san-pham">Danh Mục<span class="caret"></span></a>
                    <ul class="danhsach-luachon">
                        <li class="nut luachon-con indam-700" onclick="khiClickDanhMuc(0)">Tất cả</li>
                        <c:forEach items="${cacDanhMuc}" var="danhMuc">
                            <li class="nut luachon-con indam-700" onclick="khiClickDanhMuc(${danhMuc.id})">${danhMuc.ten}</li>
                        </c:forEach>
                    </ul>
                </li>
                <li>
                    <a class="duongdan" href="/lien-he">Liên hệ</a>
                </li>
                                <c:if test="${empty NGUOIDUNG}">
                                <li>
                                    <a class="duongdan" href="<%=request.getContextPath()%>/dang-nhap">Đăng nhập</a>
                                </li>
                                    <li>
                                        <a class="duongdan" href="<%=request.getContextPath()%>/dang-ky">Đăng ký</a>
                                    </li>
                                </c:if>
                                <c:if test="${not empty NGUOIDUNG}">
                                    <li>
                                        <a class="duongdan" href="<%=request.getContextPath()%>/thong-tin-tai-khoan">Xin chào : ${NGUOIDUNG.tenDangNhap}</a>
                                    </li>
                                    <li>
                                        <a class="duongdan" href="<%=request.getContextPath()%>/dang-xuat">Đăng xuất</a>
                                    </li>
                                </c:if>
            </ul>

            <form action="/tim-san-pham" class="form-timkiem dayxuong-2 dayxuong-thietbivua-0" id="timKiem">
                <div class="nhap-timkiem">
                    <input name="txt" type="text" class="form-kiemsoat" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Tìm kiếm..." required>
                    <div class="nut-timkiem">
                        <button type="submit" class="nut nut-2">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <c:if test="${not empty NGUOIDUNG}">
                    <a class="nut nut-giohang" href="/gio-hang">
                        <i class="fa fa-shopping-cart"></i> Giỏ hàng
                        <span id="soChiMucCuaGioHang"></span>
                    </a>
                </c:if>
            </form>
        </div>
    </div>
</nav>

<script src="/template/js/web/header.js"></script>


