function validateForm() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var id = document.getElementById("id").value;
    var confirmPassword = document.getElementById("confirmpassword").value;

    // Validate mã thành viên
    if (id.trim() === "") {
        document.getElementById("idError").innerHTML = "Mã thành viên không được để trống.";
        return false;
    } else {
        document.getElementById("idError").innerHTML = "";
    }
    // Validate mã thành viên
    if (id.length !== 6 || isNaN(id)) {
        document.getElementById("idError").innerHTML = "Mã thành viên phải là một chuỗi 6 số.";
        return false;
    } else {
        document.getElementById("idError").innerHTML = "";
    }
    // Validate email
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        document.getElementById("EmailError").innerHTML = "Email không hợp lệ. Vui lòng nhập lại.";
        return false;
    } else {
        document.getElementById("EmailError").innerHTML = "";
    }

    // Validate combobox Khoa
    var selectedKhoa = document.getElementById("comboboxKhoa").value;
    if (selectedKhoa === "nonekhoa") {
        document.getElementById("comboboxKhoaherror").innerHTML = "Vui lòng chọn khoa.";
        return false;
    } else {
        document.getElementById("comboboxKhoaherror").innerHTML = "";
    }

    // Validate combobox Nganh
    var selectedNganh = document.getElementById("comboboxNganh").value;
    if (selectedNganh === "nonekhoa") {
        document.getElementById("comboboxNganherror").innerHTML = "Vui lòng chọn ngành.";
        return false;
    } else {
        document.getElementById("comboboxNganherror").innerHTML = "";
    }

    // Validate combobox Khoahoc
    var selectedKhoahoc = document.getElementById("comboboxKhoahoc").value;
    if (selectedKhoahoc === "noneKhoahoc") {
        document.getElementById("comboboxKhoahocerror").innerHTML = "Vui lòng chọn khóa học.";
        return false;
    } else {
        document.getElementById("comboboxKhoahocerror").innerHTML = "";
    }
    // Validate password
    var passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordRegex.test(password)) {
        document.getElementById("passwordError").innerHTML = "Mật khẩu phải có ít nhất 8 ký tự và chứa cả chữ và số.";
        return false;
    } else {
        document.getElementById("passwordError").innerHTML = "";
    }
    // Validate confirm password
    if (password !== confirmPassword) {
        document.getElementById("confirmpasswordError").innerHTML = "Xác nhận mật khẩu không khớp. Vui lòng nhập lại.";
        return false;
    } else {
        document.getElementById("confirmpasswordError").innerHTML = "";
    }

    return true;
}
function changeCheckbox() {
    var passwordInput = document.getElementById("password");
    var ConfirmpasswordInput = document.getElementById("confirmpassword");
    var checkbox = document.getElementById("showPasswordCheckbox");

    if (checkbox.checked) {
        passwordInput.type = "text";
        ConfirmpasswordInput.type = "text";

    } else {
        passwordInput.type = "password";
        ConfirmpasswordInput.type = "password";
    }
}




