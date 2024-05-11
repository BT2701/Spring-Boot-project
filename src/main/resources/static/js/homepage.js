document.addEventListener("DOMContentLoaded", function() {
    // Tải header và footer bằng AJAX
    fetch("./admin-header")
        .then(response => response.text())
        .then(html => {
            document.getElementById("header").innerHTML = html;
        });

    fetch("./footer")
        .then(response => response.text())
        .then(html => {
            document.getElementById("footer").innerHTML = html;
        });
});

    var maThanhVienBackUp = -1;

    // xóa thành viên
    var maTvToDelete = -1;
    function ClickDeleteOneTVBtn (matv) {
      document.getElementById("modal-body-idTV").innerText = matv.toString();

      maTvToDelete = matv;
    }
    async function DeleteOneTv() {
      if(maTvToDelete == -1) return;

      const data = { maTV: maTvToDelete };

      try {
          const response = await fetch("/thanhvien/delete/" + maTvToDelete, {
              method: "DELETE",
              headers: {
                  "Content-Type": "application/x-www-form-urlencoded",
              },
              body: new URLSearchParams(data),
          });

          if (response.ok) {
              document.getElementById("closeModalJoinKvhtTVBtn").click();
              window.location.reload();
          } else {
              const errorMessage = await response.text();
              alert(errorMessage);
              document.getElementById("closeModalJoinKvhtTVBtn").click();
          }
      } catch (error) {
          console.error("Lỗi:", error);
          alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
      }
    }

    // xử lý click phải hiện ra modal
    document.body.addEventListener('click', function () {
      document.getElementById("rightclicked").style.display = "none";
    })
    document.body.addEventListener('contextmenu', function () {
      document.getElementById("rightclicked").style.display = "none";
    })

    members = document.querySelectorAll('.member');
    members.forEach(member => {
      member.addEventListener('contextmenu', function (ev) {
      ev.stopPropagation();
      ev.preventDefault();

      const parentElement = ev.target.closest('.member'); // Tìm phần tử cha gần nhất với class 'member'
      const maTVElement = parentElement.querySelector("#mathanhvien"); // Tìm phần tử con với ID 'mathanhvien'

      maThanhVienBackUp = maTVElement.innerText || -1;

      rightclick();
      return false;
    }, false);
    });

    function rightclick() {
      var e = window.event;
      var cantThinkOfAName = document.getElementById("rightclicked");
      cantThinkOfAName.style.display = "block";
      cantThinkOfAName.style.left = e.clientX + "px";
      cantThinkOfAName.style.top = e.clientY + "px";
    }

    // render ra các major trong các modal
    function renderMajorFirstTime() {
      const facultySelects = document.querySelectorAll(".s_faculty");
      const majorSelects = document.querySelectorAll(".s_major");

      const majors = ["Khoa học máy tính", "Truyền thông dữ liệu và mạng máy tính", "Công nghệ phần mềm", "Kỹ thuật máy tính", "Kỹ thuật mạng"];

      facultySelects.forEach((facultySelect, index) => {
          const majorSelect = majorSelects[index];

          if (facultySelect.value === "CNTT") {
              majorSelect.innerHTML = "";

             majors.forEach(major => {
                  const option = document.createElement("option");
                  option.text = major;
                  option.value = major;
                  majorSelect.add(option);
              });
         }
      });
    }
    renderMajorFirstTime();

    function updateMajor() {
            const facultySelects = document.querySelectorAll(".s_faculty");
            const majorSelects = document.querySelectorAll(".s_major");

            facultySelects.forEach((facultySelect, index) => {
                const majorSelect = majorSelects[index];
                majorSelect.innerHTML = "";

                if (facultySelect.value === "CNTT") {
                    const majors = ["Khoa học máy tính", "Truyền thông dữ liệu và mạng máy tính", "Công nghệ phần mềm", "Kỹ thuật máy tính", "Kỹ thuật mạng"];
                    majors.forEach(major => {
                        const option = document.createElement("option");
                        option.text = major;
                        option.value = major;
                        majorSelect.add(option);
                    });
                } else if (facultySelect.value === "GD") {
                    const majors = ["Tư vấn học đường", "Tâm lý giáo dục", "Sư phạm", "Công nghệ giáo dục"];
                    majors.forEach(major => {
                        const option = document.createElement("option");
                        option.text = major;
                        option.value = major;
                        majorSelect.add(option);
                    });
                } else if (facultySelect.value === "GDMN") {
                    const majors = ["Ngành giáo dục mầm non"];
                    majors.forEach(major => {
                        const option = document.createElement("option");
                        option.text = major;
                        option.value = major;
                        majorSelect.add(option);
                    });
                } else if (facultySelect.value === "KL") {
                    const majors = ["Luật Hình sự", "Luật Dân sự", "Luật Hành chính","Luật Thương mại","Luật Quốc tế","Cố vấn pháp lý","Thẩm phán"];
                    majors.forEach(major => {
                        const option = document.createElement("option");
                        option.text = major;
                        option.value = major;
                        majorSelect.add(option);
                    });
                }
            });
        }

    function validateAddAndUpdateThanhVien(maTV, hoten, khoa, nganh, sdt) {
        if (!maTV || !hoten || !khoa || !nganh || !sdt) {
            alert("Tất cả các trường phải được điền.");
            return false;
        }

        if (sdt.length !== 10) {
            alert("Số điện thoại phải là 10 chữ số.");
            return false;
        }

        return true;
    }

    document.getElementById("addTVByFormBtn").addEventListener("click", async () => {
        const inputMaTV = document.getElementById("inputMTV1");

        // 2 số đầu tiên
        const firstNumber = "11";
        // Lấy năm hiện tại
        const currentDate = new Date();
        const year = currentDate.getFullYear();
        // Lấy 2 số cuối cùng của năm
        const yearStr = String(year);
        const majorStr = yearStr.substring(2, 4);

        // Lấy 6 số cuối cùng của maTV
        const res = await fetch("/thanh-vien/getAll");
        const data = await res.json();
        console.log(data);
        const lastThanhVien = data.length !== 0 && data[data.length - 1];
        const maTVStr = lastThanhVien && (lastThanhVien.maTV + 1);
        const last6Digits = maTVStr.toString().slice(-6);

        const maTV = firstNumber + majorStr + last6Digits;
        inputMaTV.value = maTV;
    })

    function saveNewThanhVien() {
        const maTV = document.getElementById("inputMTV1").value.trim();
        const hoten = document.getElementById("inputHVT1").value.trim();
        const khoa = document.getElementById("selectKhoa1").value;
        const nganh = document.getElementById("major1").value;
        const sdt = document.getElementById("inputSdt1").value.trim();
        const email = "";
        const password = "";

        if (!validateAddAndUpdateThanhVien(maTV, hoten, khoa, nganh, sdt)) {
            return;
        }

        const data = {
            maTV,
            hoten,
            khoa,
            nganh,
            sdt,
            email,
            password
        };

        try {
          fetch("/thanhvien/add", {
              method: "POST",
              headers: {
                  "Content-Type": "application/x-www-form-urlencoded"
              },
              body: new URLSearchParams(data)
          })
          .then(response => {
              if (response.ok) {
                  document.getElementById("closeModalAddTVBtn").click();
                  window.location.reload();
              } else {
                  alert("Có lỗi khi thêm thành viên");
              }
          })
          .catch(error => console.error("Lỗi:", error));
        } catch (error) {
            console.error("Lỗi:", error);
            alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
        }
    }

    document.getElementById("uploadFileBtn").addEventListener("click", function () {
        const fileInput = document.getElementById("filechooser");

        if (fileInput.files.length === 0) { // Kiểm tra nếu không có file được chọn
            alert("Vui lòng chọn một file Excel để tải lên.");
            return;
        }

        const file = fileInput.files[0];
        const formData = new FormData();
        formData.append("file", file);

        fetch("/upload-excel", {
            method: "POST",
            body: formData
        })
        .then(response => {
            if (response.ok) {
                document.getElementById("closeModalUploadFile").click();
                window.location.reload();
            } else {
                return response.text().then(text => {
                    alert("Lỗi tải lên: " + text);
                });
            }
        })
        .catch(error => {
            console.error("Lỗi:", error);
            alert("Đã xảy ra lỗi khi tải lên. Vui lòng thử lại sau.");
        });
    });

    var emailBackupToUpdate = "";
    var passwordBackupToUpdate = "";
    document.getElementById("openModalUpdateTVBtn").addEventListener("click", async () => {
        if(maThanhVienBackUp === -1) {
          alert("Không tìm thấy sinh viên với mã : " + maThanhVienBackUp)
        };

        const inputMaTV = document.getElementById("inputMTV2");
        const inputHoten = document.getElementById("inputHVT2");
        const inputKhoa = document.getElementById("selectKhoa2");
        const inputSdt = document.getElementById("inputSdt2");

        const res = await fetch("/thanhvien/" + maThanhVienBackUp);
        const tvJson = await res.json();
        const tv = tvJson.thanhVien;

        inputMaTV.value = maThanhVienBackUp;
        inputHoten.value = tv.hoTen;
        inputSdt.value = tv.sdt;
        emailBackupToUpdate = tv.email;
        passwordBackupToUpdate = tv.password;

        for (let i = 0; i < inputKhoa.options.length; i++) {
          if (inputKhoa.options[i].value === tv.khoa) {
            inputKhoa.selectedIndex = i;
            updateMajor();

            const inputNganh = document.getElementById("major2");
            for (let i = 0; i < inputNganh.options.length; i++) {
              if (inputNganh.options[i].value === tv.nganh) {
                inputNganh.selectedIndex = i;
                break;
              }
            }

            break;
          }
        }

    });

    document.getElementById("updateTVBtn").addEventListener("click", () => {
      const maTV = document.getElementById("inputMTV2").value.trim();
      const hoten = document.getElementById("inputHVT2").value.trim();
      const khoa = document.getElementById("selectKhoa2").value.trim();
      const nganh = document.getElementById("major2").value.trim();
      const sdt = document.getElementById("inputSdt2").value.trim();
      const email = emailBackupToUpdate;
      const password = passwordBackupToUpdate;

      if (!validateAddAndUpdateThanhVien(maTV, hoten, khoa, nganh, sdt)) {
          return;
      }

      const data = {
        maTV,
        hoten,
        khoa,
        nganh,
        sdt,
        email,
        password,
      };

      try {
        fetch("/thanhvien/update", {
          method: "PUT",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams(data),
         })
          .then((response) => {
            if (response.ok) {
              document.getElementById("closeModalUpdateTVBtn").click();
              window.location.reload();
            } else {
              alert("Có lỗi khi sửa thông tin thành viên.");
            }
          })
          .catch((error) => {
            console.error("Lỗi:", error);
          });
      } catch (error) {
          console.error("Lỗi:", error);
          alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
      }

    })

    // xem chi tiết
    document.getElementById("openModalDetailTVBtn").addEventListener("click", async () => {
      if(maThanhVienBackUp === -1) {
          alert("Không tìm thấy sinh viên với mã : " + maThanhVienBackUp)
      };

      const res = await fetch("/thanhvien/" + maThanhVienBackUp);
      const tvJson = await res.json();
      const tv = tvJson.thanhVien;
      const vipham = tvJson.viPham || "";
      const thietBiDaMuon = tvJson.thietBiDaMuon || "";
      const thietBiDaDatCho = tvJson.thietBiDaDatCho || "";

      if(tv === null) {
        return;
      }

      document.getElementById("inputMTV7").value = tv.maTV;
      document.getElementById("inputHVT7").value = tv.hoTen;
      document.getElementById("inputNganh7").value = tv.nganh;
      document.getElementById("inputKhoa7").value = tv.khoa;
      document.getElementById("inputSdt7").value = tv.sdt;
      document.getElementById("inputEmail7").value = tv.email.length === 0 ? "Chưa tạo" : tv.email;
      document.getElementById("inputPw7").value = tv.password.length === 0 ? "Chưa tạo" : tv.password;
      document.getElementById("inputTbdm7").value = thietBiDaMuon.length === 0 ? "Không có" : thietBiDaMuon;
      document.getElementById("inputTbdc7").value = thietBiDaDatCho.length === 0 ? "Không có" : thietBiDaDatCho;
      document.getElementById("inputVp7").value = vipham.length === 0 ? "Không có" : vipham;
    })


    // vào khu vực học
    document.getElementById("openModalJoinKVHTBtn").addEventListener("click", async () => {
      if(maThanhVienBackUp === -1) {
          alert("Không tìm thấy sinh viên với mã : " + maThanhVienBackUp)
      };

      const res = await fetch("/thanhvien/" + maThanhVienBackUp);
      const tvJson = await res.json();
      const tv = tvJson.thanhVien;

      if(tv === null) {
        return;
      }

      document.getElementById("inputMaTV4").value = tv.maTV;
      document.getElementById("inputHVT4").value = tv.hoTen;
      document.getElementById("inputNganh4").value = tv.nganh;
      document.getElementById("inputKhoa4").value = tv.khoa;
      document.getElementById("inputSdt4").value = tv.sdt;
    })

    document.getElementById("joinKVHTBtn").addEventListener("click", async () => {
      const maTV = document.getElementById("inputMaTV4").value;

      const data = { maTV };

      try {
          const response = await fetch("/thanhvien/join-kvht", {
              method: "POST",
              headers: {
                  "Content-Type": "application/x-www-form-urlencoded",
              },
              body: new URLSearchParams(data),
          });

          if (response.ok) {
              document.getElementById("closeModalJoinKvhtTVBtn").click();
              window.location.reload();
          } else {
              const errorMessage = await response.text();
              alert(errorMessage);
          }
      } catch (error) {
          console.error("Lỗi:", error);
          alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
      }
    })


    // cảnh báo vi phạm
    document.getElementById("openModalCanhBaoViPhamBtn").addEventListener("click", async () => {
      if(maThanhVienBackUp === -1) {
          alert("Không tìm thấy sinh viên với mã : " + maThanhVienBackUp)
      };

      const res = await fetch("/thanhvien/" + maThanhVienBackUp);
      const tvJson = await res.json();
      const tv = tvJson.thanhVien;

      document.getElementById("selectThanhVien5").value = maThanhVienBackUp + "-" + tv.hoTen;
    })

    document.getElementById("addViPhamBtn").addEventListener("click", async () => {
      const viPham = document.getElementById("inputViPham5").value.trim();
      const soTienRaw = document.getElementById("inputSoTien5").value.trim();

      const info = document.getElementById("selectThanhVien5").value.trim();
      const maTV = parseInt(info.split("-")[0]);
      const hoTen = info.split("-")[1];

      if (viPham.length === 0) {
        alert("Trường vi phạm không được bỏ trống!");
        return;
      }

      let soTien = -1;

       if (soTienRaw.length !== 0) {
          const soTienParsed = parseInt(soTienRaw);
          if (soTienParsed <= 0) {
            alert("Số tiền phải là số dương!");
            return;
          }
          soTien = soTienParsed;
       }

      const data = {
        maTV,
        viPham,
        soTien,
      };

      try {
        const response = await fetch("/thanhvien/cbvp", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams(data),
        });

        if (response.ok) {
          document.getElementById("closeModalCbcpBtn").click();
          window.location.reload();
        } else {
          const errorMessage = await response.text();
          alert(errorMessage);
        }
      } catch (error) {
        console.error("Lỗi:", error);
        alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
      }
    });



    // mượn trả thiết bị  id="openModalMuonTraTbBtn"  id="muonThietBiBtn" id="traThietBiBtn" id="closeModalMuonTraTbBtn"
    document.getElementById("openModalMuonTraTbBtn").addEventListener("click", async () => {
      if(maThanhVienBackUp === -1) {
          alert("Không tìm thấy sinh viên với mã : " + maThanhVienBackUp)
      };

      const res = await fetch("/thanhvien/" + maThanhVienBackUp);
      const tvJson = await res.json();
      const tv = tvJson.thanhVien;
      document.getElementById("selectThanhVien6").value = maThanhVienBackUp + "-" + tv.hoTen;
    })

    document.getElementById("muonThietBiBtn").addEventListener("click", async () => {
      const tvInfo = document.getElementById("selectThanhVien6").value.trim();
      const maTV = parseInt(tvInfo.split("-")[0]);

      const tbInfo = document.getElementById("selectThietBi6").value.trim();
      const maTB = parseInt(tbInfo.split("-")[0]);

      const data = {
        maTV,
        maTB
      };

      try {
        const response = await fetch("/thanhvien/muontb", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams(data),
        });

        if (response.ok) {
          document.getElementById("closeModalMuonTraTbBtn").click();
          window.location.reload();
        } else {
          const errorMessage = await response.text();
          console.log(errorMessage);
          alert(errorMessage);
        }
      } catch (error) {
        console.error("Lỗi:", error);
        alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
      }
    })

    document.getElementById("traThietBiBtn").addEventListener("click", async () => {
      const tvInfo = document.getElementById("selectThanhVien6").value.trim();
      const maTV = parseInt(tvInfo.split("-")[0]);

      const tbInfo = document.getElementById("selectThietBi6").value.trim();
      const maTB = parseInt(tbInfo.split("-")[0]);

      const data = {
        maTV,
        maTB
      };

      try {
        const response = await fetch("/thanhvien/tratb", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams(data),
        });

        if (response.ok) {
          document.getElementById("closeModalMuonTraTbBtn").click();
          window.location.reload();
        } else {
          const errorMessage = await response.text();
          alert(errorMessage);
        }
      } catch (error) {
        console.error("Lỗi:", error);
        alert("Đã xảy ra lỗi khi thực hiện yêu cầu. Vui lòng thử lại sau.");
      }
    })


    // xóa nhiều thành viên
    document.getElementById("deleteManyTvBtn").addEventListener("click", () => {
        const khoaThu = document.getElementById("selectKhoaThu").value; // ko co = ""
        const hoTen = document.getElementById("inputHVT3").value.trim();
        const khoa = document.getElementById("selectKhoa3").value; // ko co = ""
        const nganh = document.getElementById("selectNganh3").value; // ko co = ""
        const sdt = document.getElementById("inputSdt3").value.trim();

        if(khoaThu.trim().length === 0 && hoTen.trim().length === 0 && khoa.trim().length === 0
          && nganh.trim().length === 0 && sdt.trim().length === 0
        ) {
          alert("Hãy nhập hoặc chọn 1 điều kiện để thực hiện xóa nhiều !");
          return;
        }

        const data = {
            khoaThu: khoaThu.length > 0 ? khoaThu : undefined,
            hoTen: hoTen.length > 0 ? hoTen : undefined,
            khoa: khoa.length > 0 ? khoa : undefined,
            nganh: nganh.length > 0 ? nganh : undefined,
            sdt: sdt.length > 0 ? sdt : undefined
        };

        fetch("/thanhvien/delete-multiple", {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (response.ok) {
                document.getElementById("closeDeleteManyTvModalBtn").click();
                window.location.reload();
            } else {
                response.text().then(text => alert("Lỗi: " + text));
            }
        })
        .catch(error => {
            console.error("Lỗi:", error);
            alert("Đã xảy ra lỗi. Vui lòng thử lại sau.");
        });
    })