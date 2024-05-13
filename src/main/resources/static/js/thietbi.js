
document.addEventListener("DOMContentLoaded", function () {
    // Tải header và footer bằng AJAX
    fetch("./admin-header")
        .then(response => response.text())
        .then(html => {
            document.getElementById("header").innerHTML = html;
        });


});


function toggleClassAddItem() {
    document.getElementById("idTB-modal-add").value = "";
    document.getElementById("tenTB-modal-add").value = "";
    document.getElementById("moTaTB-modal-add").value = "";

    var element = document.getElementById("addItem");
    element.classList.toggle("d-none");
}

function toggleClassAddItemRemove() {
    var element = document.getElementById("addItem");
    element.classList.toggle("d-none");
}

function toggleClassDeleteItems() {
    document.getElementById("idOption-modal-deleteList").value = 1;
    document.getElementById("tenTB-modal-deleteList").value = "";
    document.getElementById("moTaTB-modal-deleteList").value = "";
    var element = document.getElementById("deleteItems");
    element.classList.toggle("d-none");
}

function toggleClassDeleteItemsRemove() {
    var element = document.getElementById("deleteItems");
    element.classList.toggle("d-none");
}

function toggleClassDeleteItem(btn) {
    var row = btn.closest("tr");
    var maTB = row.querySelector(".column1").innerText; // Lấy giá trị của cột 1

    // Gán giá trị cho các span
    document.getElementById("span-modal-delete").innerText = "Bạn có chắc chắn muốn xóa thiết bị có ID " + maTB + " không?";

    // Lưu giá trị maTB vào thuộc tính data-maTB của modal
    var deleteModal = document.getElementById("deleteItem");
    deleteModal.setAttribute("data-maTB", maTB);

    // Hiển thị modal delete
    var element = document.getElementById("deleteItem");
    element.classList.toggle("d-none");
}

function toggleClassDeleteItemRemove() {
    var element = document.getElementById("deleteItem");
    element.classList.toggle("d-none");
}

function toggleClassUpdateItem(btn) {
    var row = btn.closest("tr");
    var maTB = row.querySelector(".column1").innerText; // Lấy giá trị của cột 1
    var tenTB = row.querySelector(".column2").innerText; // Lấy giá trị của cột 2
    var moTaTB = row.querySelector(".column3").innerText; // Lấy giá trị của cột 3

    // Tách từ đầu tiên từ chuỗi tenTB
    var firstWord = tenTB.split(/\s+/)[0];

    // Bỏ đi từ đầu tiên từ chuỗi tenTB
    var restOfTenTB = tenTB.slice(firstWord.length).trim();

    // Gán giá trị cho các input
    document.getElementById("idTB-modal-update").value = maTB;
    document.getElementById("chuDauTenTB-modal-update").value = firstWord;
    document.getElementById("tenTB-modal-update").value = restOfTenTB;
    document.getElementById("moTaTB-modal-update").value = moTaTB;

    // Hiển thị modal update
    var element = document.getElementById("updateItem");
    element.classList.toggle("d-none");
}

function toggleClassUpdateItemRemove() {
    var element = document.getElementById("updateItem");
    element.classList.toggle("d-none");

}

function toggleClassNotiRemove() {
    var element = document.getElementById("modalNoti");
    element.classList.toggle("d-none");
}

function toggleClassWarningDelete() {
    const idOp = document.getElementById("idOption-modal-deleteList").value;

    // Định nghĩa một đối tượng ánh xạ giữa giá trị option và tên tương ứng của loại thiết bị
    const tenTBMap = {
        "1": "Micro",
        "2": "Máy chiếu",
        "3": "Máy ảnh",
        "4": "Cassette",
        "5": "Tivi",
        "6": "Quạt đứng"
    };

    // Lấy tên tương ứng của loại thiết bị dựa trên giá trị option đã chọn
    const tenTBFromOption = tenTBMap[idOp];

    let message = "Bạn có chắc chắn muốn xóa các thiết bị ";

    // Thêm tên thiết bị vào câu thông báo
    if (tenTBFromOption) {
        message += tenTBFromOption + " không?";
    }

    document.getElementById("span-modal-warningDelete").innerText = message;

    var element = document.getElementById("deleteItems");
    element.classList.toggle("d-none");

    var element1 = document.getElementById("warningDelete");
    element1.classList.toggle("d-none");
}

function toggleClassWarningDeleteRemove() {
    var element = document.getElementById("warningDelete");
    element.classList.toggle("d-none");

    var element1 = document.getElementById("deleteItems");
    element1.classList.toggle("d-none");
}

function toggleClassChooseFile() {
    var element = document.getElementById("chooseFileModal");
    element.classList.toggle("d-none");
}

function toggleClassChooseFileRemove() {
    var element = document.getElementById("chooseFileModal");
    element.classList.toggle("d-none");
}

async function toggleClassThongTinChiTiet(btn) {
    var row = btn.closest("tr");
    var maTB = row.querySelector(".column1").innerText; // Lấy giá trị của cột 1
    var tenTB = row.querySelector(".column2").innerText; // Lấy giá trị của cột 2
    var moTaTB = row.querySelector(".column3").innerText; // Lấy giá trị của cột 3

    const response = await fetch(`/thiet-bi-admin/thongTinTB/${maTB}`);
    const data = await response.json();

    document.getElementById("idTB-modal-thongTinTB").innerText = maTB;
    document.getElementById("tenTB-modal-thongTinTB").innerText = tenTB;
    document.getElementById("moTaTB-modal-thongTinTB").innerText = moTaTB;
    document.getElementById("tinhTrangTB-modal-thongTinTB").innerText = data.message;

    var element = document.getElementById("modalThongTinChiTiet");
    element.classList.toggle("d-none");
}

function toggleClassThongTinChiTietRemove() {
    var element = document.getElementById("modalThongTinChiTiet");
    element.classList.toggle("d-none");
}





async function deleteThietBi() {
    // Lấy giá trị maTB từ thuộc tính data-maTB của modal
    let maTB = document.getElementById("deleteItem").getAttribute("data-maTB");
    const response = await fetch(`/thiet-bi-admin/delete/${maTB}`);
    const data = await response.json();

    document.getElementById("message-modal-noti").innerText = data.message;

    var element = document.getElementById("modalNoti");
    element.classList.toggle("d-none");
}


async function getNewestId() {
    const tenTB = document.getElementById("tenTB-modal-add").value.trim(); // Lấy giá trị của trường "Tên thiết bị" và loại bỏ khoảng trắng thừa
    const words = tenTB.split(/\s+/); // Tách từ trong tên thiết bị thành mảng các từ

    let id = 0;

    switch (words[0]) {
        case "Micro":
            id = await getNewestIdByTenTB("Micro");
            if (id == 1) id = 100001;
            break;
        case "Máy":
            if (words.length >= 2) {
                if (words[1] === "chiếu") {
                    id = await getNewestIdByTenTB("Máy chiếu");
                    if (id == 1) id = 200001;
                } else if (words[1] === "ảnh") {
                    id = await getNewestIdByTenTB("Máy ảnh");
                    if (id == 1) id = 300001;
                }
            }
            break;
        case "Cassette":
            id = await getNewestIdByTenTB("Cassette");
            if (id == 1) id = 400001;
            break;
        case "Tivi":
            id = await getNewestIdByTenTB("Tivi");
            if (id == 1) id = 500001;
            break;
        case "Quạt":
            if (words.length >= 2 && words[1] === "đứng") {
                id = await getNewestIdByTenTB("Quạt đứng");
                if (id == 1) id = 600001;
            }
            break;
    }

    if (id !== 0) {
        document.getElementById("idTB-modal-add").value = id;
    } else {
        document.getElementById("idTB-modal-add").value = "";
    }
}

async function getNewestIdByTenTB(tenTB) {
    const response = await fetch(`/thiet-bi-admin/newestId/${tenTB}`);
    const data = await response.json();
    return data.id;
}



async function addNewTB() {
    const idTB = document.getElementById("idTB-modal-add").value;
    if (idTB === "") {
        // Trường idTB-modal-add đang trống
        alert("Bạn nhập sai định dạng tên! Bạn phải nhập tên có chữ cái đầu: Micro, Máy chiếu, Máy ảnh, Cassette, Tivi, Quạt đứng");

    } else {
        // Trường idTB-modal-add không trống
        const tenTB = document.getElementById("tenTB-modal-add").value;
        const moTaTB = document.getElementById("moTaTB-modal-add").value;

        const data = { idTB, tenTB, moTaTB };

        const response = await fetch(`/thiet-bi-admin/add`, {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams(data)
        });
        const rs = await response.json();

        var element = document.getElementById("addItem");
        element.classList.toggle("d-none");

        var element = document.getElementById("modalNoti");
        element.classList.toggle("d-none");

        document.getElementById("message-modal-noti").innerText = rs.message;
    }
}



async function updateThietBi() {
    // Trường idTB-modal-add không trống
    const idTB = document.getElementById("idTB-modal-update").value;
    const chuDauTenTB = document.getElementById("chuDauTenTB-modal-update").value;
    const sauChuDauTenTB = document.getElementById("tenTB-modal-update").value;
    const moTaTB = document.getElementById("moTaTB-modal-update").value;

    let tenTB = chuDauTenTB + " " + sauChuDauTenTB;

    const data = { idTB, tenTB, moTaTB };

    const response = await fetch(`/thiet-bi-admin/update`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams(data)
    });
    const rs = await response.json();

    var element = document.getElementById("updateItem");
    element.classList.toggle("d-none");

    var element = document.getElementById("modalNoti");
    element.classList.toggle("d-none");

    document.getElementById("message-modal-noti").innerText = rs.message;
}



document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput');
    const searchOption = document.getElementById('searchOption');

    // Bắt sự kiện khi người dùng thay đổi giá trị của ô input tìm kiếm
    searchInput.addEventListener('input', function () {
        const searchText = searchInput.value.trim().toLowerCase();
        const selectedOption = searchOption.value;

        // Gọi hàm để lọc thông tin bảng
        filterTable(searchText, selectedOption);
    });

    // Bắt sự kiện khi người dùng thay đổi giá trị của dropdown menu
    searchOption.addEventListener('change', function () {
        const searchText = searchInput.value.trim().toLowerCase();
        const selectedOption = searchOption.value;

        // Gọi hàm để lọc thông tin bảng
        filterTable(searchText, selectedOption);
    });

    // Hàm để lọc thông tin bảng dựa trên từ khóa tìm kiếm và tùy chọn đã chọn
    function filterTable(searchText, selectedOption) {
        const tableRows = document.querySelectorAll('.table-row');

        tableRows.forEach(function (row) {
            const rowData1 = row.querySelector('.column1').textContent.trim().toLowerCase();
            const rowData2 = row.querySelector('.column2').textContent.trim().toLowerCase();
            const rowData3 = row.querySelector('.column3').textContent.trim().toLowerCase();

            if (
                (selectedOption == 'all' && (rowData1.includes(searchText) || rowData2.includes(searchText) || rowData3.includes(searchText))) ||
                (selectedOption === 'id' && rowData1.includes(searchText)) ||
                (selectedOption === 'tenTB' && rowData2.includes(searchText)) ||
                (selectedOption === 'moTaTB' && rowData3.includes(searchText))
            ) {
                row.style.display = ''; // Hiển thị hàng nếu dữ liệu khớp với từ khóa tìm kiếm và tùy chọn đã chọn
            } else {
                row.style.display = 'none'; // Ẩn hàng nếu không khớp
            }
        });
    }
});



async function deleteListThietBi() {

    const idOp = document.getElementById("idOption-modal-deleteList").value;
    const tenTB = document.getElementById("tenTB-modal-deleteList").value;
    const moTaTB = document.getElementById("moTaTB-modal-deleteList").value;

    const data = { idOp, tenTB, moTaTB };

    const response = await fetch(`/thiet-bi-admin/deleteList`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams(data)
    });

    const rs = await response.json();

    var element = document.getElementById("deleteItems");
    element.classList.toggle("d-none");

    var element = document.getElementById("modalNoti");
    element.classList.toggle("d-none");

    let message = "";

    if (rs.successIds.length == 0) {
        if (rs.failureIds.length != 0) {
            message += "Xóa thât bại " + rs.failureIds.length + " thiết bị có ID: " + rs.failureIds.join(", ");
        } else message += "Không có thiết bị nào thỏa mãn điều kiện";
    } else {
        message += "Xóa thành công " + rs.successIds.length + " thiết bị có ID: " + rs.successIds.join(", ");
        if (rs.failureIds.length != 0) {
            message += "\nXóa thất bại " + rs.failureIds.length + " thiết bị có ID: " + rs.failureIds.join(", ");
        }
    }

    document.getElementById("message-modal-noti").innerText = message;

}

document.getElementById("uploadBtn").addEventListener("click", function () {
    const fileInput = document.getElementById("filechooser");

    if (fileInput.files.length === 0) { // Kiểm tra nếu không có file được chọn
        alert("Vui lòng chọn một file Excel để tải lên.");
        return;
    }

    const file = fileInput.files[0];
    const formData = new FormData();
    formData.append("file", file);

    fetch("/thiet-bi-admin/addListThietBi", {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (response.ok) {
                var element = document.getElementById("chooseFileModal");
                element.classList.toggle("d-none");

                var element = document.getElementById("modalNoti");
                element.classList.toggle("d-none");
                return response.text().then(text => {
                    document.getElementById("message-modal-noti").innerText = text;
                });
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

