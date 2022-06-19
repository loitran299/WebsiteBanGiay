<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--<link rel="stylesheet" href="/css/profile.css">--%>
<link rel="stylesheet" href="/template/css/thongtin.css">

<div class="thungchua">
    <div class="hang bienminh-noidung-trungtam">
        <div class="cot-12 cot-l-10 cot-xl-8 mb-auto">
            <h2 class="h3 mb-4 tieude">Cài đặt</h2>
            <div class="b-4">
                <ul class="dieuhuong dieuhuong-cactab mb-4" id="tabCuaToi" role="tablist">
                    <li class="dieuhuong-muc">
                        <a class="dieuhuong-lienket hoatdong" id="tabTrangChu" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Thông tin người dùng</a>
                    </li>
                </ul>
                <form id="hoso-mau" method="post">
                    <div class="mau-hang">
                        <div class="mau-nhom cot-trungbinh-6">
                            <label for="tenDangNhap">Tên đăng nhập</label>
                            <input type="text" id="tenDangNhap" class="mau-kiemsoat" value="${NGUOIDUNG.tenDangNhap}" readonly/>
                        </div>
                        <div class="mau-nhom cot-trungbinh-6">
                            <label for="hoTen">Họ và tên</label>
                            <input type="text" id="hoTen" class="mau-kiemsoat" value="${NGUOIDUNG.hoTen}" />
                        </div>
                    </div>
                    <div class="mau-nhom">
                        <label for="email">Email</label>
                        <input type="email" class="mau-kiemsoat" id="email" value="${NGUOIDUNG.email}" />
                    </div>
                    <div class="mau-nhom">
                        <label for="diaChi">Địa chỉ</label>
                        <input type="text" class="mau-kiemsoat" id="diaChi" value="${NGUOIDUNG.diaChi}" />
                    </div>
                    <hr class="mb-4" />
                    <div class="hang mb-4">
                        <div class="cot-trungbinh-6">
                            <div class="mau-nhom">
                                <label for="matKhauMoi">Mật khẩu mới</label>
                                <input type="password" class="mau-kiemsoat" id="matKhauMoi" />
                            </div>
                            <div class="mau-nhom">
                                <label for="matKhauXacNhan">Nhập lại mật khẩu</label>
                                <input type="password" class="mau-kiemsoat" id="matKhauXacNhan" />
                                <label for="matKhauXacNhan" id="warn-cf-pass" style="color: #A11515FF"></label>
                            </div>
                        </div>
                        <div class="cot-trungbinh-6 pl-4">
                            <p class="mb-2">Yêu cầu mật khẩu</p>
                            <p class="nho vanban-dabitat mb-2">Để tạo một tài khoản, bạn cần đáp ứng tất cả các yêu cầu dưới đây:</p>
                            <ul class="nho vanban-dabitat pl-4 mb-0">
                                <li>1. Ít nhất 3 ký tự</li>
                                <li>2. Không được giống với mật khẩu cũ</li>
                            </ul>
                        </div>
                    </div>
                    <button type="submit" class="nut nut-chinh">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </div>

</div>

<script src="/template/js/web/thongtin.js"></script>
<script src="/template/js/web/sanpham.js"></script>
