const sanPhamsApi = "http://localhost:8080/api/sanpham/get/all";
var listSanPham = [];
var tatCaSP = [];
function load() {
    var element = document.getElementById("idDanhMuc");
    let idDanhMuc;
    if (element) idDanhMuc = document.getElementById("idDanhMuc").value;
    console.log(idDanhMuc)
    laySanPhams(idDanhMuc);


}
load();
function laySanPhams(id) {
    id = Number(id);
    console.log(typeof id);
    fetch(sanPhamsApi)
        .then(function (response){
            return response.json();
        })
        .then(function (sanPhams){
            tatCaSP = sanPhams;
            console.log(sanPhams)
            if(!id){
                listSanPham = sanPhams;
            }else{
                listSanPham = sanPhams.filter( (sanPham) =>{
                    if(sanPham.danhMuc.id === id){
                        return sanPham;
                    }
                })
            }
            sanPhamMoi(listSanPham[listSanPham.length - 1])
            xuatHTML(listSanPham);
        });
}

let trangHienTai = 1;
let soSanPhamTrang = 6;
let batDau = 0;
let ketThuc = soSanPhamTrang;
let soSanPham = 0;
let soTrang;

function xuatHTML(sanPhams) {
    soSanPham = sanPhams.length;
    soTrang = Math.ceil(soSanPham/soSanPhamTrang);
    xuatDanhSachTrang();
    const sanPhamView = document.getElementById("listSanPham");
    const htmls = sanPhams.map((sanPham , index) => {
        if(index >= batDau && index <ketThuc) {
            return `
                <div class="sanpham-thietbilon-4 sanpham-thietbivua-6 sanpham">
                    <div class="sanpham-the">
                        <img class="sanpham-the-anh" src="${sanPham.pathAnh}">
                        <div class="sanpham-the-phanthan">
                            <h4 class="sanpham-the-tieude sanpham-the-rutgon"><a href="/chi-tiet-san-pham?id=${sanPham.id}" title="View Product">${sanPham.ten}</a></h4>
                            <p class="sanpham-the-loaigiay sanpham-the-rutgon">${sanPham.danhMuc.ten} / ${sanPham.nhanHieu.ten}</p>
                            <div class="sanpham-hang sanpham-themvaogiohang">
                                <div class="sanpham-cot sanpham-the-gia fontchu-1">
                                    <p>${sanPham.gia.toLocaleString('vi-VN', {
                style: 'currency',
                currency: 'VND'
            })}</p>
                                </div>
                                <div class="sanpham-cot">
                                    <button class="nut-themvaogiohang" onclick="themSanPham(${sanPham.id})">Thêm vào giỏ</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        `;
        }
    })
    if(sanPhamView !== null){
        sanPhamView.innerHTML = htmls.join('');
    }

}

function rsTrang(trang){
    trangHienTai = trang;
    batDau = (trangHienTai - 1) * soSanPhamTrang;
    ketThuc = trangHienTai * soSanPhamTrang;
}

function onClickTrangSau() {
    trangHienTai ++;
    if(trangHienTai > soTrang) trangHienTai = soTrang;
    rsTrang(trangHienTai);
    xuatHTML(listSanPham);
    activeTrang();
}

function onClickTrangTruoc() {
    trangHienTai --;
    if(trangHienTai < 1) trangHienTai = 1;
    rsTrang(trangHienTai);
    xuatHTML(listSanPham);
    activeTrang();
}


function khiClickNhanHieu(id) {

    var sanPhamTheoNhanHieu = [];
    const fun = tatCaSP.map(function (sanPham) {
        if(sanPham.nhanHieu.id === id){
            sanPhamTheoNhanHieu.push(sanPham);
            return sanPham;
        }
    })
    listSanPham = sanPhamTheoNhanHieu;
    xuatHTML(sanPhamTheoNhanHieu);

}
 function khiClickDanhMuc(id){
    if(id === 0) window.location = "http://localhost:8080/trang-san-pham";
    window.location = "http://localhost:8080/trang-san-pham?idDanhMuc="+id;
     // var sanPhamTheoDanhMuc = [];
     // const fun = listSanPham.map(function (sanPham) {
     //     if(sanPham.danhMuc.id === id){
     //         sanPhamTheoDanhMuc.push(sanPham);
     //         return sanPham;
     //     }
     // })
     // xuatHTML(sanPhamTheoDanhMuc);
 }

 function sanPhamMoi(sanPham){
    const sanPhamMoi = document.getElementById('sanPhamMoi');
    if (sanPhamMoi != null){
        sanPhamMoi.innerHTML = `
                <div class="sanpham-the-phanthan">
                    <img class="anh-giaypine" src="${sanPham.pathAnh}" />
                    <h5 class="sanpham-the-tieude"><a href="/chi-tiet-san-pham?id=${sanPham.id}">${sanPham.ten}</a></h5>
                    <p class="sanpham-the-loaigiay">${sanPham.danhMuc.ten} / ${sanPham.nhanHieu.ten}</p>
                    <p class="sanpham-the-gia">${sanPham.gia.toLocaleString('vi-VN', {style: 'currency', currency: 'VND'})}</p>
                </div>
        `;
    }
 }

function xuatDanhSachTrang() {
    let html = '';
    html += `<li class="page-item" onclick="onClickTrangTruoc()"><a class="sanpham-phantrang-duongdan">Trước</a></li>`;
    html += `<li class="page-item active"><a class="sanpham-phantrang-duongdan">1</a></li>`;
    for (let i = 2; i<= soTrang; i++){
        html += `<li class="page-item"><a class="sanpham-phantrang-duongdan">${i}</a></li>`;
    }
    html += `<li class="page-item" onclick="onClickTrangSau()"><a class="sanpham-phantrang-duongdan">Sau</a></li>`;
    if(document.getElementById("so-trang") != null){
        document.getElementById("so-trang").innerHTML = html;
    }

    chuyenTrang()
}

function activeTrang() {
    $('#so-trang li').removeClass('active');

    $(`#so-trang li:nth-child(${trangHienTai+1})`).addClass('active');

}




function chuyenTrang() {
    const danhSachTrang = document.querySelectorAll("#so-trang li");
    console.log(danhSachTrang);
    for (let i = 1; i< danhSachTrang.length - 1; i++){
        danhSachTrang[i].addEventListener('click',function (){
            rsTrang(i);
            xuatHTML(listSanPham);
            activeTrang();
        })
    }

}


