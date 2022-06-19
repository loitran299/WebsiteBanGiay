<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/template/css/slide.css">
<link rel="stylesheet" href="/template/css/reset.css">
<link rel="stylesheet" href="/template/css/sanpham.css">
<section class="slide cangiua">
    <div class="sanpham-tong">
        <!-- Slider -->
        <div class="image-slider">
            <div class="image-item">
                <div class="image">
                    <img
                            src="https://images.unsplash.com/photo-1611510338559-2f463335092c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"
                            alt=""
                    />
                </div>
                <h3 class="image-title">Balenciaga</h3>
            </div>
            <div class="image-item">
                <div class="image">
                    <img
                            src="https://images.unsplash.com/photo-1588484628369-dd7a85bfdc38?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80"
                            alt=""
                    />
                </div>
                <h3 class="image-title">Yeezy 700V3</h3>
            </div>
            <div class="image-item">
                <div class="image">
                    <img
                            src="https://images.unsplash.com/photo-1602033693432-b88c0b6320ed?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80"
                            alt=""
                    />
                </div>
                <h3 class="image-title">Rick Owens</h3>
            </div>
            <div class="image-item">
                <div class="image">
                    <img
                            src="https://images.unsplash.com/photo-1606890542241-b848582fe5cd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80"
                            alt=""
                    />
                </div>
                <h3 class="image-title">Salomon</h3>
            </div>
            <div class="image-item">
                <div class="image">
                    <img
                            src="https://images.unsplash.com/photo-1621665421558-831f91fd0500?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
                            alt=""
                    />
                </div>
                <h3 class="image-title">Jordan</h3>
            </div>
        </div>
    </div>
</section>

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


<script src="/template/js/web/sanpham.js"></script>
<script src="/template/js/web/themsanpham.js"></script>

