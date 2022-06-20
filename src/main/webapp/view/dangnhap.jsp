<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/template/css/login.css" rel="stylesheet" type="text/css" media="all" />
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
</head>
<body>
<div class="dangnhap-tong">
    <h1>Đăng nhập</h1>
    <div class="dangnhap-phanthan">
        <c:if test="${param.loi != null}">
            <div class="dangnhap-thongbao">
                Tên đăng nhập hoặc mật khẩu không đúng!
            </div>
        </c:if>
        <c:if test="${param.dangxuat != null}">
            <div class="dangnhap-thongbao">
                Đăng xuất thành công!
            </div>
        </c:if>
        <c:if test="${param.khongthetruycap != null}">
            <div class="dangnhap-thongbao">
                Không thể truy cập trang này!
            </div>
        </c:if>
        <div class="dangnhap-form">
            <form action="kiem-tra-dang-nhap" method="post">
                <input class="nhap-tendangnhap" type="text" name="tenDangNhap" placeholder="Tên đăng nhập" required="required"/>
                <input class="nhap-matkhau" type="password" name="matKhau" placeholder="mật khẩu" required="required">
                <div class="dangnhap-nhomatkhau">
                    <label>
                        <input type="checkbox" class="nhap-nhomatkhau" name="nhomatkhau">
                        <span>Nhớ mật khẩu</span>
                    </label>
                </div>
                <input type="hidden" name="action" value="dangnhap">
                <input class="nut-dangnhap" type="submit" value="Đăng nhập">
            </form>
            <p>Đã có tài khoản? <a href="/dang-ky"> Đăng ký!</a></p>
        </div>
    </div>
</div>
</body>
</html>