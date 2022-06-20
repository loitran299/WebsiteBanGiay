
function load(){
    layLienHes(xuatHTML);

}
load()

function layLienHes(goilai) {
    const url = "http://localhost:8080/api/lienhe/get/all";
    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(goilai);
}

function xuatHTML(lienHes) {
    const tbody = document.querySelector("tbody");
    const htmls = lienHes.map(function (lienHe) {
        return `
                <tr>
                    <td>${lienHe.id}</td>
                    <td>${lienHe.hoTen}</td>
                    <td>${lienHe.email}</td>
                    <td style="max-width: 300px">${lienHe.loiNhan}</td>
                    <td>
                    <button class="btn btn-danger" onclick="xoaLienHe(${lienHe.id})">Xóa</button>
                    <button class="btn btn-success" onclick="traLoiLienHe(${lienHe.id})">Trả lời</button>
                    </td>
                    
                </tr>
        `;
    })
    tbody.innerHTML = htmls.join('');
}

function xoaLienHe(id) {
    const url = "http://localhost:8080/api/lienhe/xoa/"+id;
    fetch(url,{
        method:"DELETE"
    })
        .then(function (response) {
            if (response.ok) {
                layLienHes(xuatHTML);
            }
        })
}

const myModal = document.getElementById("myModal");
// myModal.classList.add('hien-thi-kieu-none');

document.getElementById("dong").addEventListener('click',function () {
    myModal.classList.remove('phuong-thuc-1');
    myModal.classList.add('hien-thi-kieu-none');
})

function traLoiLienHe(id) {
    myModal.classList.remove('hien-thi-kieu-none');
    myModal.classList.add('phuong-thuc-1');
    document.getElementById("formLienHe").addEventListener('submit',function () {
        const traLoi = document.getElementById("traLoi");
        const url = `http://localhost:8080/api/lienhe/traloi`;
        const data = {
            "id":id,
            "traLoi":traLoi.value,
            "tieuDe":"Trả lời từ T-sneaker"
        }
        fetch(url,{
            method:"PUT",
            body:JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            }
        })
            .then(function (response) {
                if (response.ok){
                    myModal.classList.remove('phuong-thuc-1');
                    myModal.classList.add('hien-thi-kieu-none');
                    layLienHes(xuatHTML);
                }else{
                    alert("lỗi");
                }
            })
    })

}