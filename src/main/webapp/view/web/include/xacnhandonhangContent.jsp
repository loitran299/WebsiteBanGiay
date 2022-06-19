<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/template/css/xacnhandonhang.css">

<% DecimalFormat formatter = new DecimalFormat("###,###,###");
    request.setAttribute("formatter",formatter);
%>

<div class="thungdung letren-5 leduoi-5">
    <div class="hang huong-linhhoat bienminh-noidung-trungtam">
        <div class="cot-trungbinh-8">
            <div class="the">
                <div class="vanban-bentrai p-2 px-5">
                    <img src="https://i.imgur.com/2zDU056.png" width="50">
                </div>
                <div class="hoadon p-5">
                    <h5>Bạn đã xác nhận đơn hàng!</h5>
                    <c:if test="${NGUOIDUNG.hoTen != null}">
                        <span class="phongchu-trongluong-dam hienthi-khoi mt-4">Xin chào, ${NGUOIDUNG.hoTen}</span>
                    </c:if>
                    <c:if test="${NGUOIDUNG.hoTen == null}">
                        <span class="phongchu-trongluong-dam hienthi-khoi mt-4">Xin chào, ${NGUOIDUNG.tenDangNhap}</span>
                    </c:if>
                    <span>Đơn hàng của bạn đã được xác nhận và sẽ được giao trong vài ngày tới!</span>
                    <div class="thanhtoan bien-tren mt-3 mb-3 bien-duoi bang-phanung">
                        <table class="bang">
                            <tbody>
                            <tr>
                                <td class="cot-bang">
                                    <div class="pb-2">

                                        <span class="hienthi-khoi vanban-dabitat">Ngày đặt</span>
                                        <span>${donHang.ngayDat}</span>
                                    </div>
                                </td>
                                <td class="cot-bang">
                                    <div class="pb-2">
                                        <span class="hienthi-khoi vanban-dabitat">Mã đơn</span>
                                        <span>MT12345</span>
                                    </div>
                                </td>
                                <td class="cot-bang">
                                    <div class="pb-2">
                                        <span class="hienthi-khoi vanban-dabitat">Thanh toán</span>
                                        <span><img src="https://img.icons8.com/color/48/000000/mastercard.png"
                                                   width="20"/></span>
                                    </div>
                                </td>
                                <td class="cot-bang">
                                    <div class="pb-2">
                                        <span class="hienthi-khoi vanban-dabitat">Địa chỉ nhận hàng</span>
                                        <span>${NGUOIDUNG.diaChi}</span>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="sanpham bien-duoi bang-phanung">
                        <table class="bang">
                            <tbody>
                            <c:forEach items="${chiTiets}" var="chiTiet">
                                <tr>
                                    <td width="20%">
                                        <img src="${chiTiet.sanPham.pathAnh}" width="90">
                                    </td>
                                    <td width="60%">
                                        <span class="phongchu-trongluong-dam">${chiTiet.sanPham.ten}</span>
                                        <div class="soluong-sanpham">
                                            <span class="hienthi-khoi">Số lượng: ${chiTiet.soLuong}</span>
                                            <span>Màu sắc: ${chiTiet.sanPham.mauSac}</span>
                                        </div>
                                    </td>
                                    <td width="20%">
                                        <div class="vanban-benphai">
                                            <span class="phongchu-trongluong-dam">${formatter.format(chiTiet.donGia)}đ</span>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="hang huong-linhhoat bienminh-noidung-cuoi">
                        <div class="cot-trungbinh-5">
                            <table class="bang">
                                <tbody class="toanbo">
                                <tr>
                                    <td class="cot-bang">
                                        <div class="vanban-bentrai">
                                            <span class=vanban-dabitat>Miễn phí vận chuyển: </span>
                                        </div>
                                    </td>
                                    <td class="cot-bang">
                                        <div class="vanban-benphai">
                                            <span> 30,000đ</span>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="bien-duoi bien-tren">
                                    <td>
                                        <div class="vanban-bentrai">

                                            <span class="phongchu-trongluong-dam">Đơn giá</span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="vanban-benphai">
                                            <span class="phongchu-trongluong-dam">${formatter.format(donHang.tongGia)}đ</span>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <p>Chúng tôi sẽ gửi email xác nhận đã giao hàng!</p>
                    <p class="phongchu-trongluong-dam mb-0">Cảm ơn đã tin tưởng và mua sắm!</p>
                    <span>Nike Team</span>
                </div>
                <div class="huong-linhhoat bienminh-noidung-trungtam p-3">
                    <span>Cần giúp đỡ? Truy cập <a href="#"> trung tâm trợ giúp</a> của chúng tôi</span>
                </div>
            </div>
        </div>
    </div>
</div>