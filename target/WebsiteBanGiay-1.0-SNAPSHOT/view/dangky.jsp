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
    <link href="/template/css/dangky.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
    <!-- //web font -->
</head>
<body>
<!-- main -->
<div class="main-w3layouts wrapper">
    <h1>Đăng ký</h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form action="xu-ly-dang-ky" method="post">
                <c:if test="${param.nguoidungdatontai != null}">
                    <label for="tenDangNhap" class="error" id="tenDangNhapLabel">Tên đăng nhập đã tồn tại!</label>
                </c:if>
                <input type="text" id="tenDangNhap" name="tenDangNhap" class="text" placeholder="Tên Đăng nhập" required="required"/>

                <label for="email" class="error" id="emailLabel"></label>
                <input type="text" id="email" name="email" class="email" placeholder="Email" required="required"/>


                <input type="password" id="matKhau" name="matKhau" class="text" placeholder="Mật khẩu" required="required"/>

                <label for="matKhauXacThuc" class="error" id="matKhauXacThucLabel"></label>
                <input type="password" id="matKhauXacThuc" name="matKhauXacThuc" class="text w3lpass" placeholder="Nhập lại mật khẩu" required="required"/>

                <input type="hidden" name="action" value="dangky">
                <div class="wthree-text">
                    <label class="anim">
                        <input type="checkbox" class="checkbox">
<%--                        <span>I Agree To The Terms & Conditions</span>--%>
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
<script>
    const filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    const email = document.getElementById("email");
    email.addEventListener("blur", function () {
        const lb = document.getElementById("emailLabel");
        if (filter.test(email.value)){
            lb.innerText = "";
        }else{
            lb.innerText = "Email sai định dạng!";
        }
    })
    const matKhauXacThuc = document.getElementById("matKhauXacThuc");
    matKhauXacThuc.addEventListener("mouseleave", function () {
        const matKhau = document.getElementById("matKhau");
        const lb = document.getElementById("matKhauXacThucLabel");
        if (matKhau.value == matKhauXacThuc.value){
            lb.innerText = "";
        }else{
            lb.innerText = "Mật khẩu không khớp!";
        }
    })
</script>
</html>