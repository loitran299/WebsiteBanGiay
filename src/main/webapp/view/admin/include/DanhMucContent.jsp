<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<script src="https://kit.fontawesome.com/75eef02814.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/template/css/quantri.css">
<div class="danhmuc-thietbilon-8">
    <h3 class="danhmuc-phandau">Quản lý Danh mục</h3>

    <form id="form_them_danh_muc" method="post">
        <div class="danhmuc-form-tong danhmuc-thietbilon-4">
            <input type="text" class="danhmuc-form dai-toida" id="danhMuc" placeholder="Danh mục" name="danhMuc">
        </div>
        <div class="danhmuc-form-tong danhmuc-thietbilon-1">
            <button type="submit" class="danhmuc-nut danhmuc-nut-chinh">Thêm Danh Mục</button>
        </div>
    </form>

    <table class="danhmuc-bang">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Danh mục</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        </tbody>

    </table>

    <ul class="danhmuc-phantrang">
    </ul>
</div>

<script src="/template/js/admin/danhmuc.js"></script>
