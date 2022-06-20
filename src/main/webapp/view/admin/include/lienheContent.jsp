<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<script src="https://kit.fontawesome.com/75eef02814.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/template/css/lienhe-admin.css">
<div class="cot-lap-9 hien-len">
    <h3 class="dau-trang">Quản lý Danh mục</h3>
    <table class="bang">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Email</th>
            <th>Lời nhắn</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <ul class="phan-trang">
    </ul>
</div>

<div class="hien-thi-kieu-none" id="myModal">
    <div class="phuong-thuc-lop-phu"></div>

    <div class="phuong-thuc-than">
        <div class="phuong-thuc-ben-trong">
            <div class="the">
                <div class="the-dau nen hang-dau">
                    <i class="fa fa-envelope"></i>Trả lời liên hệ.
                    <div class="nut-bam" id="dong">x</div>
                </div>
                <div class="than-the" style="width: 500px">
                    <form id="formLienHe" >
                        <div class="phong-nhom">
                            <label for="traLoi">Trả lời</label>
                            <textarea class="phong-kiem-soat" id="traLoi" rows="5" required style="font-size: 25px"></textarea>
                        </div>
                        <div class="le-trai-phai-tu-can">
                            <button type="submit" class="nut-bam nut-bam-so-cap" style="float: right;">Gửi</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/template/js/admin/lienhe.js"></script>
