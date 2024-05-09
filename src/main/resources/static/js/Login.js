function validateForm() {
    var username = document.getElementById('maTV').value;
    var password = document.getElementById('password').value;

    var isValid = true;

    // Validate mã sinh viên
    var idRegex = /^(11)\d{8}$/;
    if (!idRegex.test(username)) {
        document.getElementById("usernameError").innerHTML = "Mã thành viên phải gồm 10 số bắt đầu bằng số 11.";
        return false;
    } else {
        document.getElementById("usernameError").innerHTML = "";
    }

    if (password.trim() === '') {
        document.getElementById('passwordError').innerText = 'Vui lòng nhập mật khẩu';
        return false;
    } else {
        document.getElementById('passwordError').innerText = ''; // Xóa thông báo lỗi nếu dữ liệu hợp lệ
    }

    // Trả về false để ngăn form được submit nếu dữ liệu không hợp lệ
    return isValid;
}
// Gọi hàm changeUsername khi người dùng thay đổi giá trị trong ô nhập liệu username
function changeUsername() {
    document.getElementById('usernameError').innerHTML = "";

}

// Gọi hàm changePassword khi người dùng thay đổi giá trị trong ô nhập liệu password
function changePassword() {
    document.getElementById('passwordError').innerHTML = "";
}
function changeCheckbox() {
    var passwordInput = document.getElementById("password");
    var checkbox = document.getElementById("showPasswordCheckbox");

    if (checkbox.checked) {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
}

