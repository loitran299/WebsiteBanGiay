<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<script src="https://kit.fontawesome.com/75eef02814.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/template/css/quantri.css">
<div class="danhmuc-thietbilon-8">
    <h3 class="danhmuc-phandau">Quản lý Danh mục</h3>

    <select class="danhmuc-form" id="trangThai">
        <option value="chuahoanthanh">Chưa hoàn thành</option>
        <option value="hoanthanh">Hoàn thành</option>
    </select>

    <hr/>

    <table class="danhmuc-bang">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Người nhận</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th>Ngày đặt</th>
            <th>Ngày nhận</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        </tbody>

    </table>

    <ul class="danhmuc-phantrang">
    </ul>
</div>

<script src="/template/js/admin/donhang.js"></script>
