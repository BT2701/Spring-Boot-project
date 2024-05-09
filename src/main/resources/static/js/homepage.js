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