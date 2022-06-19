<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<link rel="stylesheet" href="/template/css/quantri.css">
<div class="danhmuc-thietbilon-8">
    <h3 class="danhmuc-phandau">Danh sách công việc</h3>
    <c:if test = "${listCongViec.soDonHangMoi > 0}">
    <p>Bạn có: <a href='<c:url value="/admin/don-hang" />'> ${listCongViec.soDonHangMoi} đơn hàng mới</a><p>
    </c:if>

    <c:if test = "${listCongViec.soLienHeMoi > 0}">
    <p>Bạn có: <a href='<c:url value="/admin/lien-he" />'> ${listCongViec.soLienHeMoi} liên hệ mới</a><p>
    </c:if>

</div>
</div>

