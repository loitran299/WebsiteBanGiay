const boTrinhChieu = document.querySelector(".bo-trinhchieu");
const cacTrinhChieu = document.querySelectorAll(".trinhchieu");
const cacTrinhChieuDaiDien = document.querySelectorAll(".trinhchieu-daidien");
const nutChuyenTiep = document.querySelector(".nut-chuyentiep");
const nutQuayLai = document.querySelector(".nut-quaylai");
const soLuongTrinhChieu = cacTrinhChieu.length;
let trinhChieuHienTai = 0;

// click vào nút chuyển slide tiếp theo
nutChuyenTiep.addEventListener("click", () => {
  cacTrinhChieu.forEach((trinhChieu) => {
    trinhChieu.classList.remove("hoatdong");
  });

  cacTrinhChieuDaiDien.forEach((trinhChieuDaiDien) => {
    trinhChieuDaiDien.classList.remove("hoatdong");
  });

  trinhChieuHienTai++;
  if (trinhChieuHienTai > soLuongTrinhChieu - 1) trinhChieuHienTai = 0;
  cacTrinhChieu[trinhChieuHienTai].classList.add("hoatdong");
  cacTrinhChieuDaiDien[trinhChieuHienTai].classList.add("hoatdong");
});

// click vào nút quay lại slide trước
nutQuayLai.addEventListener("click", () => {
  cacTrinhChieu.forEach((trinhChieu) => {
    trinhChieu.classList.remove("hoatdong");
  });

  cacTrinhChieuDaiDien.forEach((trinhChieuDaiDien) => {
    trinhChieuDaiDien.classList.remove("hoatdong");
  });

  trinhChieuHienTai--;
  if (trinhChieuHienTai < 0) trinhChieuHienTai = soLuongTrinhChieu - 1;
  cacTrinhChieu[trinhChieuHienTai].classList.add("hoatdong");
  cacTrinhChieuDaiDien[trinhChieuHienTai].classList.add("hoatdong");
});

// tự động chuyển slide
const tuDongChuyenTrinhChieu = () => {
  chuyenTrinhChieu = setInterval(() => {
    cacTrinhChieu.forEach((trinhChieu) => {
      trinhChieu.classList.remove("hoatdong");
    });

    cacTrinhChieuDaiDien.forEach((trinhChieuDaiDien) => {
      trinhChieuDaiDien.classList.remove("hoatdong");
    });

    trinhChieuHienTai++;
    if (trinhChieuHienTai > soLuongTrinhChieu - 1) trinhChieuHienTai = 0;
    cacTrinhChieu[trinhChieuHienTai].classList.add("hoatdong");
    cacTrinhChieuDaiDien[trinhChieuHienTai].classList.add("hoatdong");
  }, 3000);
};
tuDongChuyenTrinhChieu();

// chuyển slide nhanh
cacTrinhChieuDaiDien.forEach((trinhChieuDaiDien, chiMuc) => {
  trinhChieuDaiDien.addEventListener("click", () => {
    cacTrinhChieu[trinhChieuHienTai].classList.remove("hoatdong");
    cacTrinhChieuDaiDien[trinhChieuHienTai].classList.remove("hoatdong");

    trinhChieuHienTai = chiMuc;
    cacTrinhChieu[trinhChieuHienTai].classList.add("hoatdong");
    cacTrinhChieuDaiDien[trinhChieuHienTai].classList.add("hoatdong");
  });
});

// tạm dừng tự động chuyển slide khi đang di chuột lên slider
boTrinhChieu.addEventListener("mouseover", () => {
  clearInterval(chuyenTrinhChieu);
});

// tiếp tục tự động chuyển slide khi di chuột ra ngoài slider
boTrinhChieu.addEventListener("mouseout", () => {
  tuDongChuyenTrinhChieu();
});
