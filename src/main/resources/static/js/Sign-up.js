function validateForm() {
    var id = document.getElementById("id").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Validate mã sinh viên
    var idRegex = /^(11)\d{8}$/;
    if (!idRegex.test(id)) {
        document.getElementById("nameError").innerHTML = "Mã Sinh Viên phải gồm 10 số bắt đầu bằng số 11.";
        return false;
    } else {
        document.getElementById("nameError").innerHTML = "";
    }

    // Validate email
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        document.getElementById("EmailError").innerHTML = "Email không hợp lệ. Vui lòng nhập lại.";
        return false;
    } else {
        document.getElementById("EmailError").innerHTML = "";
    }

    // Validate password
    var passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordRegex.test(password)) {
        document.getElementById("passwordError").innerHTML = "Mật khẩu phải có ít nhất 8 ký tự và chứa cả chữ và số.";
        return false;
    } else {
        document.getElementById("passwordError").innerHTML = "";
    }

    return true;
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




