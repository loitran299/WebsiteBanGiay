<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="/template/css/login.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
    <!-- //web font -->
</head>
<body>
<!-- main -->
<div class="main-w3layouts wrapper">
    <h1>SIGN UP</h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form method="post" action="dang-ky" >

                <input type="text" path="tenDangNhap" class="text" placeholder="Tên Đăng nhập" required="required"/>

<%--                <input class="text" type="text" name="Username" placeholder="Username" required="required">--%>

                <input type="text" path="email" class="email" placeholder="Email" required="required"/>

<%--                <input class="text email" type="email" name="email" placeholder="Email" required="required">--%>

                <input type="password" path="matKhau" class="text" placeholder="Mật khẩu" required="required"/>

<%--                <input class="text" type="password" name="password" placeholder="Password" required="required">--%>

                <input type="password" path="matKhauXacThuc" class="text w3lpass" placeholder="Nhập lại mật khẩu" required="required"/>

<%--                <input class="text w3lpass" type="password" name="confirmPassword" placeholder="Confirm Password" required="required">--%>
                <div class="wthree-text">
                    <label class="anim">
                        <input type="checkbox" class="checkbox">
                        <span>I Agree To The Terms & Conditions</span>
                    </label>
                    <div class="clear"> </div>
                </div>
                <input type="submit" value="Đăng ký">
            </form>
            <p>Đã có tài khoản? <a href="/dang-nhap"> Đăng nhập!</a></p>
        </div>
    </div>
</div>
</body>
</html>