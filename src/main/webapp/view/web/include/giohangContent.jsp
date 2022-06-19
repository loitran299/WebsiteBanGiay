<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link href="/template/css/giohangContent.css" rel="stylesheet" type="text/css"/>
<div class="gio-hang">
    <div class="dem-phai-4 dem-trai-0">

        <div class="dem-duoi-tren-5">
            <div class="phan-than">
                <div class="hang">
                    <div class="cot-lap-12 dem-5 nen-trang ban-kinh-vien margin-xuong-5">

                        <!-- Shopping cart table -->
                        <div class="bang-thich-ung">
                            <table class="bang">
                                <thead>
                                <tr>
                                    <th scope="col" class="nen-sang vien-0">
                                        <div class="dem-2 dem-trai-3 chu-in-hoa">Sản Phẩm</div>
                                    </th>
                                    <th scope="col" class="nen-sang vien-0">
                                    </th>
                                    <th scope="col" class="nen-sang vien-0">
                                        <div class="dem-duoi-tren-2 chu-in-hoa">Đơn Giá</div>
                                    </th>
                                    <th scope="col" class="nen-sang vien-0">
                                        <div class="dem-duoi-tren-2 chu-in-hoa">Số Lượng</div>
                                    </th>
                                    <th scope="col" class="nen-sang vien-0">
                                        <div class="dem-duoi-tren-2 chu-in-hoa">Xóa</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- End -->
                    </div>
                </div>

                <div class="hang dem-duoi-tren-5 dem-4 nen-trang ban-kinh-vien">
                    <div class="cot-lap-6">
                        <div class="nen-sang ban-kinh-vien dem-trai-phai-4 dem-tren-duoi-3 chu-in-hoa do-dam-phong-chu">Voucher</div>
                        <div class="dem-4">
                            <div class="nhom-the-input le-duoi-4 vien ban-kinh-vien dem-2">
                                <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="kiem-soat-form vien-0">
                                <div class="nhom-the-input-le-trai vien-0">
                                    <button id="button-addon3" type="button" class="nut-bam nut-bam-den dem-trai-phai-4 ban-kinh-vien"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cot-lap-6">
                        <div class="nen-sang ban-kinh-vien dem-trai-phai-4 dem-tren-duoi-3 chu-in-hoa do-dam-phong-chu">Thành tiền</div>
                        <div class="dem-4">
                            <ul class="bo-gach-chan le-duoi-4">
                                <li class="hien-thi-kieu-flex can-giua dem-tren-duoi-3 vien-duoi"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                <li class="hien-thi-kieu-flex can-giua dem-tren-duoi-3 vien-duoi"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>
                                <li class="hien-thi-kieu-flex can-giua dem-tren-duoi-3 vien-duoi"><strong class="text-muted">Tổng thanh toán</strong>
                                    <h5 class="do-dam-phong-chu" id="tongThanhToan">0 đ</h5>
                                </li>
                            </ul><a href="/xac-nhan-don-hang" class="nut-bam nut-bam-den vien dem-duoi-tren-2 nut-bam-dang-hop">Mua hàng</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="/template/js/web/giohang.js"></script>
<script src="/template/js/web/sanpham.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>