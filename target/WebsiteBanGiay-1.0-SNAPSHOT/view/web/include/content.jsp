<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="/template/css/sanpham.css">
<link rel="stylesheet" href="/template/css/phongcach.css">
<link rel="stylesheet" href="/template/css/phanung.css">
<div class="chua-bo-trinhchieu">
<div class="bo-trinhchieu">
    <div class="trinhchieu hoatdong">
        <img src="/template/img/1.jpg" alt="">
        <div class="thongtin">
            <h2>Xray Footwear</h2>
            <p>Đèn huỳnh quang phù hợp với giày là một cấu trúc kim loại được bao phủ bởi gỗ thành phẩm.</p>
        </div>
    </div>
    <div class="trinhchieu">
        <img src="/template/img/2.jpg" alt="">
        <div class="thongtin">
            <h2>Converse Chuck 70</h2>
            <p>Chuck Taylor II, một mô hình cập nhật, được công bố bởi ban quản lý công ty vào tháng 7 năm 2015.</p>
        </div>
    </div>
    <div class="trinhchieu">
        <img src="/template/img/3.jpg" alt="">
        <div class="thongtin">
            <h2>Stan Smith</h2>
            <p>Adidas Stan Smith là một đôi giày tennis do Adidas sản xuất và ra mắt lần đầu tiên vào năm 1965.</p>
        </div>
    </div>
    <div class="trinhchieu">
        <img src="/template/img/4.jpg" alt="">
        <div class="thongtin">
            <h2>Xray Footwear</h2>
            <p>Đèn huỳnh quang phù hợp với giày là một cấu trúc kim loại được bao phủ bởi gỗ thành phẩm.</p>
        </div>
    </div>
    <div class="trinhchieu">
        <img src="/template/img/5.jpg" alt="">
        <div class="thongtin">
            <h2>Stan Smith</h2>
            <p>Adidas Stan Smith là một đôi giày tennis do Adidas sản xuất và ra mắt lần đầu tiên vào năm 1965.</p>
        </div>
    </div>
    <div class="trinhchieu">
        <img src="/template/img/6.jpg" alt="">
        <div class="thongtin">
            <h2>Converse Chuck 70</h2>
            <p>Chuck Taylor II, một mô hình cập nhật, được công bố bởi ban quản lý công ty vào tháng 7 năm 2015.</p>
        </div>
    </div>

    <div class="dieuhuong-nut">
        <i class="fas fa-arrow-left nut-quaylai"></i>
        <i class="fas fa-arrow-right nut-chuyentiep"></i>
    </div>

    <div class="dieuhuong-nhanh">
        <div class="trinhchieu-daidien active"></div>
        <div class="trinhchieu-daidien"></div>
        <div class="trinhchieu-daidien"></div>
        <div class="trinhchieu-daidien"></div>
        <div class="trinhchieu-daidien"></div>
        <div class="trinhchieu-daidien"></div>
    </div>

</div>
</div>

<div class="sanpham-tong">
    <div class="sanpham-hang">
        <div class="sanpham-cot chieudaitoida">
            <nav class="sanpham-vitri">
                <ol class="vitri">
                    <li class="vitri-con"><a class="chuden" style="text-decoration: none" href="/trang-chu">Trang Chủ</a></li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="sanpham-tong">
    <div class="sanpham-hang">
        <div class="sanpham-thietbivua-0 sanpham-thietbilon-3">
            <div class="sanpham-the nentrang dayxuong-1">
                <div class="sanpham-the-phandau chutrang chuhoa"><i class="fa fa-list"></i>Thương hiệu</div>
                <ul class="sanpham-danhsach-nhanhieu" id="listNhanHieu">
                    <c:forEach items="${cacNhanHieu}" var="nhanHieu">
                    <li class="sanpham-danhsach-nhanhieu-con chuden chudam-700" onclick="khiClickNhanHieu(${nhanHieu.id})">${nhanHieu.ten}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="sanpham-the nentrang dayxuong-1">
                <div class="sanpham-the-phandau chutrang chuhoa">Sản phẩm mới nhất</div>
                <div class="sanpham-the-phanthan" id="sanPhamMoi"></div>
            </div>
        </div>

        <div class="sanpham-thietbivua-12 sanpham-thietbilon-9">
            <div class="sanpham-hang sanpham-danhsach" id="listSanPham">
            </div>
        </div>
    </div>

    <div class="sanpham-hang cangiua-justify">
        <ul class="sanpham-phantrang" id="so-trang">
        </ul>
    </div>
</div>

<script src="/template/js/web/ungdung.js"></script>
<script src="/template/js/web/sanpham.js"></script>
<script src="/template/js/web/themsanpham.js"></script>

