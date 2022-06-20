<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<link rel="stylesheet" href="/template/css/thanhben.css">

<div class="thungchua-long">
    <div class="cot-trungbinh-3">
        <div id="thanhben">
            <div class="thungchua-long mt">
                <div class="dauvao-nhom">
                </div>
            </div>

            <ul class="dieuhuong thanhdieuhuong-dieuhuong thanh-ben">
                <li class="thanh-ben mt">
                    <a href="<c:url value='/admin/don-hang' />">Đơn hàng</a>
                </li>
                <li class="thanh-ben">
                    <a href='<c:url value="/admin/san-pham"/>' >Sản phẩm</a>
                </li>
                <li class="thanh-ben">
                    <a href='<c:url value="/admin/danh-muc"/>'>Danh mục</a>
                </li>
                <li class="thanh-ben">
                    <a href='<c:url value="/admin/nhan-hieu"/>'>Nhãn hiệu</a>
                </li>
                <li class="thanh-ben">
                    <a href="<c:url value='/admin/quan-ly-tai-khoan' />">Tài khoản</a>
                </li>
                <li class="thanh-ben">
                    <a href="<c:url value='/admin/lien-he' />">Liên hệ</a>
                </li>
                <li class="thanh-ben">
                    <a href="<c:url value='/admin/thong-tin-tai-khoan'/>">Thông tin tài khoản</a>
                </li>
            </ul>
        </div>
    </div>

    <script src="<c:url value='/template/js/quantri.js'/>" ></script>
