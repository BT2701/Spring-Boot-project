document.addEventListener("DOMContentLoaded", function() {
    // Tải header và footer bằng AJAX
    fetch("./admin-header")
        .then(response => response.text())
        .then(html => {
            document.getElementById("header").innerHTML = html;
        });


});
document.addEventListener("DOMContentLoaded", function() {
    // Tải header và footer bằng AJAX
    fetch("./notification")
        .then(response => response.text())
        .then(html => {
            document.getElementById("notification").innerHTML = html;
        });


});