<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--<link rel="stylesheet" href="/css/profile.css">--%>

<link rel="stylesheet" href="/template/css/thongtintaikhoanAdmin.css">

<div class="thungchua cot-trungbinh-9">
    <div class="hang">
        <div class="cot-l-10">
            <h2 class="h3 mb-4 trang-tieude">Cài đặt</h2>
            <div class="mb-4">
                <ul class="dieuhuong dieuhuong-cactab mb-4" id="myTab" role="tablist">
                    <li class="dieuhuong-muc">
                        <a class="dieuhuong-lienket" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="false">Thông tin người dùng</a>
                    </li>
                </ul>
                <form id="mau-hoso" method="post">
                    <hr class="mb-4" />
                    <div class="mau-hang">
                        <div class="mau-nhom cot-trungbinh-5">
                            <label for="tenDangNhap">Tên đăng nhập</label>
                            <input type="text" id="tenDangNhap" class="mau-kiemsoat" value="${NGUOIDUNG.tenDangNhap}" readonly/>
                        </div>
                        <div class="mau-nhom cot-trungbinh-5">
                            <label for="hoTen">Họ và tên</label>
                            <input type="text" id="hoTen" class="mau-kiemsoat" value="${NGUOIDUNG.hoTen}" />
                        </div>
                    </div>
                    <div class="mau-nhom cot-trungbinh-9">
                        <label for="email">Email</label>
                        <input type="email" class="mau-kiemsoat" id="email" value="${NGUOIDUNG.email}" />
                    </div>
                    <div class="mau-nhom cot-trungbinh-9">
                        <label for="diaChi">Địa chỉ</label>
                        <input type="text" class="mau-kiemsoat" id="diaChi" value="${NGUOIDUNG.diaChi}" />
                    </div>
                    <hr class="mb-4"/>
                    <div class="hang mb-4">
                        <div class="cot-trungbinh-6">
                            <div class="mau-nhom">
                                <label for="matKhauMoi">Mật Khẩu mới</label>
                                <input type="password" class="mau-kiemsoat" id="matKhauMoi" />
                            </div>
                            <div class="mau-nhom">
                                <label for="matKhauXacNhan">Nhập lại mật khẩu</label>
                                <input type="password" class="mau-kiemsoat" id="matKhauXacNhan" />
                                <label for="matKhauXacNhan" id="warn-cf-pass" style="color: #A11515FF"></label>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="nut nut-chinh">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="/template/js/web/thongtin.js"></script>
