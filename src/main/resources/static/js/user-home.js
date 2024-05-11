document.addEventListener("DOMContentLoaded", function() {
    // Tải header và footer bằng AJAX
    fetch("./user-header")
        .then(response => response.text())
        .then(html => {
            document.getElementById("user-header").innerHTML = html;
        });

//    fetch("./../user-header")
//        .then(response => response.text())
//        .then(html => {
//            document.getElementById("sub-header").innerHTML = html;
//        });
});