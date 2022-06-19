<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/template/css/taikhoanAdmin.css">
<script src="https://kit.fontawesome.com/75eef02814.js" crossorigin="anonymous"></script>


<div class="cot-trungbinh-9 nay">
    <h3 class="trang-tieude">Quản lý Tài khoản</h3>
    <form id="form_them_tai_khoan" method="post">
        <div class="mau-hang">
            <div class="mau-nhom cot-trungbinhh-4">
                <input type="text" class="mau-kiemsoat" id="tenDangNhap" placeholder="Tên đăng nhập" name="tenDangNhap">
            </div>
            <div class="mau-nhom cot-trungbinh-5">
                <input type="password" class="mau-kiemsoat" id="matKhau" placeholder="Mật khẩu" name="matKhau">
            </div>
            <div class="mau-nhom cot-trungbinh-2">
                <label for="vaiTro">Vai Trò:</label>
                <select id="vaiTro" class="mau-kiemsoat" name="vaiTro">
                    <option selected>USER</option>
                    <option>ADMIN</option>
                </select>
            </div>
        </div>
        <div class="mau-nhom cot-trungbinh-9">
            <input type="email" class="mau-kiemsoat" id="email" placeholder="Email" name="email">
        </div>
        <div class="mau-nhom cot-trungbinh-9">
            <input type="text" class="mau-kiemsoat" id="diaChi" placeholder="Địa chỉ" name="diaChi">
        </div>
        <div class="mau-nhom cot-trungbinnh-1">
            <button type="submit" class="nut nut-chinh">Thêm tài khoản</button>
        </div>
    </form>

    <hr>
    <table class="bang bang-phanung" style="text-align: center;">
        <thead>
            <tr>
                <th>Mã</th>
                <th>Tên đăng nhập</th>
                <th>Email</th>
                <th>Họ và tên</th>
                <th>Địa chỉ</th>
                <th>Vai trò</th>
                <th></th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<%--</div>--%>
<script src="/template/js/admin/taikhoan.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>


