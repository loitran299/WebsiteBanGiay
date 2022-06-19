<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<link rel="stylesheet" href="/template/css/lienhe.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />

<div class="thungchua">
    <div class="hang">
        <div class="cot">
            <div class="the">
                <div class="the-tieude vanban-trang"><i class="fa fa-envelope"></i> Liên hệ với chúng tôi.
                </div>
                <div class="the-than">
                    <form id="mau-lienhe">
                        <div class="mau-nhom">
                            <label for="ten">Tên</label>
                            <input type="text" class="mau-kiemsoat" id="ten" aria-describedby="email-hotro" placeholder="Nhập tên" required>
                        </div>
                        <div class="mau-nhom">
                            <label for="email">Email</label>
                            <input type="email" class="mau-kiemsoat" id="email" aria-describedby="email-hotro" placeholder="Nhập email" required>
                            <small id="email-hotro" class="mau-vanban vanban-dabitat">Chúng tôi sẽ không chia sẻ email của bạn cho bất kỳ ai.</small>
                        </div>
                        <div class="mau-nhom">
                            <label for="loinhan">Lời nhắn</label>
                            <textarea class="mau-kiemsoat" id="loinhan" rows="6" required></textarea>
                        </div>
                        <div class="ml-auto">
                            <button type="submit" class="nut nut-chinh vanban-phai">Gửi</button></div>
                    </form>
                </div>
            </div>
        </div>
        <div class="cot-12 col-nho-4">
            <div class="the nen-sang mb-3">
                <div class="the-tieude vanban-trang"><i class="fa fa-home"></i> Địa chỉ</div>
                <div class="the-than">
                    <p>282 Kim Giang</p>
                    <p>Hoàng Mai, Hà Nội</p>
                    <p>Việt Nam</p>
                    <p>Email: email@example.com</p>
                    <p>Tel: +8454524525</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/template/js/web/lienhe.js"></script>
<script src="/template/js/web/sanpham.js"></script>