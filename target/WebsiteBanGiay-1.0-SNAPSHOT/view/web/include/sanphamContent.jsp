<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/template/css/sanpham.css">
<div class="sanpham-tong">
    <div class="sanpham-hang">
        <div class="sanpham-cot chieudaitoida">
            <nav class="sanpham-vitri">
                <ol class="vitri">
                    <li class="vitri-con"><a class="chuden" style="text-decoration: none" href="/trang-chu">Trang Chủ</a></li>
                    <li class="vitri-con hoatdong">Sản phẩm</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="sanpham-tong">
    <div class="sanpham-hang">
        <div class="sanpham-thietbilon-3 sanpham-thietbivua-0">
            <div class="sanpham-the nentrang dayxuong-1">
                <div class="sanpham-the-phandau chutrang chuhoa"><i class="fa fa-list"></i>Thương hiệu</div>
                <ul class="sanpham-danhsach-nhanhieu" id="listNhanHieu">
                    <c:forEach items="${cacNhanHieu}" var="nhanHieu">
                        <li class="sanpham-danhsach-nhanhieu-con chuden chudam-700" onclick="khiClickNhanHieu(${nhanHieu.id})">${nhanHieu.ten}</li>
                    </c:forEach>
                    <input type="hidden" value="${idDanhMuc}" id="idDanhMuc">
                </ul>
            </div>
            <div class="sanpham-the nentrang dayxuong-1">
                <div class="sanpham-the-phandau chutrang chuhoa">Sản phẩm mới nhất</div>
                <div class="sanpham-the-phanthan" id="sanPhamMoi"></div>
            </div>
        </div>
        <div class="sanpham-thietbilon-9 sanpham-thietbivua-12">
            <div class="sanpham-hang sanpham-danhsach" id="listSanPham">
            </div>
        </div>
    </div>
    <div class="sanpham-hang cangiua-justify">
        <ul class="sanpham-phantrang" id="so-trang">
        </ul>
    </div>
</div>


<script src="/template/js/web/sanpham.js"></script>
<script src="/template/js/web/themsanpham.js"></script>