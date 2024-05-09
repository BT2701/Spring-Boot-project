function handleSelection() {
    var selectedOption = document.getElementById("type-selection").value;
    var tuyChonDiv = document.getElementById("tuy-chon");
    
    if (selectedOption === "all") {
        tuyChonDiv.style.display="none"; // Thêm class hidden để ẩn tùy chọn
    } else if (selectedOption === "time") {
        tuyChonDiv.style.display="flex";  // Loại bỏ class hidden để hiện tùy chọn
    }
}
const fromInput = document.getElementById("from");
const toInput = document.getElementById("to");

fromInput.addEventListener("change", function () {
    updateStatistics();
});

toInput.addEventListener("change", function () {
    updateStatistics();
});

function updateStatistics() {
    const fromDate = fromInput.value;
    const toDate = toInput.value;

    // Gửi request AJAX đến server để lấy dữ liệu thống kê mới dựa trên fromDate và toDate
    // Tôi giả sử bạn có một API endpoint để lấy dữ liệu thống kê từ server

    // Ví dụ về cách sử dụng fetch API để gửi request AJAX
    fetch('/api/thong-ke?from=' + fromDate + '&to=' + toDate)
        .then(response => response.json())
        .then(data => {
            // Cập nhật giá trị của các input statistic
            document.getElementById("txt1").value = data.countMember;
            document.getElementById("txt2").value = data.borrowed;
            document.getElementById("txt3").value = data.borrowing;
            document.getElementById("txt4").value = data.violation;
            document.getElementById("txt5").value = data.handled;
            document.getElementById("txt6").value = data.handling;
            document.getElementById("txt7").value = data.fee + ' VND';
        })
        .catch(error => console.error('Error:', error));
}