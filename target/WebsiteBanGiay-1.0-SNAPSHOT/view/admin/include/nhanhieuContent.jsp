<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<script src="https://kit.fontawesome.com/75eef02814.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/template/css/nhanhieu-admin.css">
<div class="cot-lap-9 hien-len">
    <h3 class="dau-trang">Quản lý Nhãn hiệu</h3>

    <form id="form_them_nhan_hieu" method="post">
        <div class="phong-hang">
            <div class="phong-nhom cot-lap-4">
                <input type="text" class="phong-kiem-soat" id="nhanHieu" placeholder="Nhãn hiệu" name="nhanHieu">
            </div>
        </div>
        <div class="phong-nhom cot-lap-1">
            <button type="submit" class="nut-bam nut-bam-so-cap">Thêm Nhãn hiệu</button>
        </div>
    </form>

    <table class="bang table-hover " style="text-align: center;">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Nhãn hiệu</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        </tbody>

    </table>

    <ul class="pagination">
    </ul>
</div>

<script src="/template/js/admin/nhanhieu.js"></script>
