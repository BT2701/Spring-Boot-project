function handleSelection() {
    var selectedOption = document.getElementById("type-selection").value;
    var tuyChonDiv = document.getElementById("tuy-chon");
    
    if (selectedOption === "all") {
        tuyChonDiv.style.display="none"; // Thêm class hidden để ẩn tùy chọn
    } else if (selectedOption === "time") {
        tuyChonDiv.style.display="flex";  // Loại bỏ class hidden để hiện tùy chọn
    }
}