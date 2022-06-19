<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<link rel="stylesheet" href="/template/css/chitietsanpham.css">
<% DecimalFormat formatter = new DecimalFormat("###,###,###");
    request.setAttribute("formatter",formatter);
%>
<div class="chitiet-tong">
    <div class="chitiet-the">
        <div class="chitiet-the-phanthan">
            <h3 class="chitiet-the-tieude">${sanPham.ten}</h3>
            <div class="hang">
                <div class="cot-thietbilon-5 cot-thietbivua-5 cot-thietbinho-6">
                    <div class="cangiua"><img src="${sanPham.pathAnh}"></div>
                </div>
                <div class="cot-thietbilon-7 cot-thietbivua-7 cot-thietbinho-6">
                    <h4 class="daytren-3">Mô tả</h4>
                    <p>${sanPham.moTa}</p>
                    <h2 class="daytren-2 font-chu-2">
                        ${formatter.format(sanPham.gia)}VND<small class="chitiet-giamgia">(36% off)</small>
                    </h2>
                    <button class="nut nut-den" data-toggle="tooltip" title="" data-original-title="Add to cart" onclick="themSanPham(${sanPham.id})">
                        <i class="fa fa-shopping-cart" style="width: 60px; font-size: 30px; height: auto"></i>
                    </button>
                    <h3 class="daytren-2">Điểm nổi bật chính</h3>
                    <ul class="chitiet-danhsachthongtin">
                        <li><i class="fa fa-check mauxanh"></i>Cấu trúc chắc chắn</li>
                        <li><i class="fa fa-check mauxanh"></i>Được thiết kế để mang lại cảm giác em ái nhất</li>
                        <li><i class="fa fa-check mauxanh"></i>Vẻ ngoài hào nhoáng tô điểm thêm sự sang chảnh của bạn
                        </li>
                    </ul>
                </div>
                <div class="chitiet-bangthongtin cot-thietbilon-12 cot-thietbivua-12 cot-thietbinho-12">
                    <h3 class="daytren-2">Thông tin chung</h3>
                    <div class="bang-giaodien">
                        <table class="bang bang-sanpham">
                            <tbody>
                            <tr>
                                <td>Nhãn hiệu</td>
                                <td>${sanPham.nhanHieu.ten}</td>
                            </tr>
                            <tr>
                                <td>Kiểu dáng</td>
                                <td>${sanPham.danhMuc.ten}</td>
                            </tr>
                            <tr>
                                <td>Màu sắc</td>
                                <td>${sanPham.mauSac}</td>
                            </tr>
                            <tr>
                                <td>Giới tính</td>
                                <td>${sanPham.gioiTinh}</td>
                            </tr>
                            <tr>
                                <td>Số lượng</td>
                                <td>${sanPham.soLuong}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/template/js/web/themsanpham.js"></script>
<script src="/template/js/web/sanpham.js"></script>