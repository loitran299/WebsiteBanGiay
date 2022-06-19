
function load() {
    layGioHang(xuatGioHang)
}
load();

function layGioHang(goilai) {
    var url = "http://localhost:8080/api/giohang/get";
    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(goilai);
}


function xuatGioHang(chiMucs) {
    console.log("list chi muc : "+chiMucs);
    const tbody = document.querySelector("tbody");
    var tongThanhToan = 0;
    const htmls = chiMucs.map(function (chiMuc) {
        var gia = chiMuc.soLuong * chiMuc.sanPham.gia;
        tongThanhToan += gia;
        console.log("id: "+chiMuc.id);
        return `
             <tr>
                 <td class="can-giua">
                         <img src="${chiMuc.sanPham.pathAnh}" alt="" style="width: 70px;" class="kieu-anh do-cong-vien">
                 </td>
                 <td class="can-giua"> 
                     <div class="hien-thi-thanh-1-hang can-giua">
                         <h5 class="le-duoi-0"><a href="/chi-tiet-san-pham?id=${chiMuc.sanPham.id}" class="chu-den hien-thi-thanh-1-hang">${chiMuc.sanPham.ten}</a></h5>
                         <span class="chu-nghieng-in-duoi do-dam-phong-chu phong-chu-italic">${chiMuc.sanPham.danhMuc.ten}/</span>
                         <span class="chu-nghieng-in-duoi do-dam-phong-chu phong-chu-italic">${chiMuc.sanPham.nhanHieu.ten}</span>
                     </div>
                 </td>
                 <td class="can-giua"><strong>${gia.toLocaleString('vi-VN', {
            style: 'currency',
            currency: 'VND'
        })}</strong></td>
                 <td class="can-giua">
                     <button class="nut-bam btnSub" onclick="thayDoiSoLuong(${chiMuc.id},${chiMuc.soLuong -1})">-</button>
                     <strong>${chiMuc.soLuong}</strong>
                     <button class="nut-bam btnAdd" onclick="thayDoiSoLuong(${chiMuc.id},${chiMuc.soLuong +1})">+</button>
                 </td>
                 <td class="can-giua"><a href="#" class="chu-den">
                         <button type="button" class="nut-bam btn-danger" onclick="xoaChiMuc(${chiMuc.id})">Xóa</button>
                     </a>
                 </td>
                 
             </tr> 
        `;
    })
    tbody.innerHTML = htmls.join('');
    document.getElementById("soChiMucCuaGioHang").innerHTML = chiMucs.length;
    document.getElementById("tongThanhToan").innerHTML = `<h5 class="do-dam-phong-chu" id="tongThanhToan">${tongThanhToan.toLocaleString('vi-VN', {
        style: 'currency',
        currency: 'VND'
    })}</h5>`;
}

function thayDoiSoLuong(id , sl) {
    if (sl > 0){
        console.log("id"+id,"sl: "+sl);
        url = `http://localhost:8080/api/giohang/update/chimuc?id=${id}&soLuong=${sl}`;
        fetch(url,{
            method:"PUT"
        })
            .then(function (response) {
                return response.json();
            })
            .then(function (dt) {
                if(dt.trangThai === "ok"){
                    layGioHang(xuatGioHang);
                }
            })
    }

}

function xoaChiMuc(id) {
    url = `http://localhost:8080/api/giohang/xoa/chimuc/`+id;
    fetch(url,{
        method:"DELETE"
    })
        .then(function (response) {
            if(response.ok){
                layGioHang(xuatGioHang);
            }
        })
}

