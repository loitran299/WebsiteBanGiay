//jjkh
document.getElementById("mau-lienhe").addEventListener('submit',function (e) {
    e.preventDefault();
    const ten = document.getElementById("ten");
    const email = document.getElementById("email");
    const loiNhan = document.getElementById("loinhan");

    const data = {
        "hoTen":ten.value,
        "email":email.value,
        "loiNhan":loiNhan.value
    }
    const url = "http://localhost:8080/api/lienhe/them";
    fetch(url,{
        method:"POST",
        body:JSON.stringify(data),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then(function (re) {
        if (re.ok) {
            alert("cảm ơn đã gửi góp ý");
            ten.value = '';
            email.value = '';
            loiNhan.value = '';
        }
    })
})