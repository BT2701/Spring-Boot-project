// Dữ liệu cho biểu đồ 1
var dataMember = {
    labels: ['A', 'B', 'C', 'D', 'E'],
    datasets: [{
        label: 'Tổng quan',
        backgroundColor: 'rgb(255, 99, 132)',
        borderColor: 'rgb(255, 99, 132)',
        data: [20, 30, 25, 40, 35],
        fill: false,
    }]
};

// Dữ liệu cho biểu đồ 2
var dataDepartment = {
    labels: ['X', 'Y', 'Z'],
    datasets: [{
        label: 'Khoa',
        backgroundColor: 'rgb(54, 162, 235)',
        borderColor: 'rgb(54, 162, 235)',
        data: [50, 60, 55],
        fill: false,
    }]
};

// Dữ liệu cho biểu đồ 3
var dataBranch = {
    labels: ['M', 'N', 'O', 'P'],
    datasets: [{
        label: 'Ngành',
        backgroundColor: 'rgb(75, 192, 192)',
        borderColor: 'rgb(75, 192, 192)',
        data: [15, 25, 20, 30],
        fill: false,
    }]
};

var dataDevice = {
    labels: ['M', 'N', 'O', 'P'],
    datasets: [{
        label: 'Thiết bị',
        backgroundColor: 'rgb(75, 192, 192)',
        borderColor: 'rgb(75, 192, 192)',
        data: [15, 25, 20, 30],
        fill: false,
    }]
};

var dataCurrent = {
    labels: ['M', 'N', 'O', 'P'],
    datasets: [{
        label: 'Thiết bị',
        backgroundColor: 'rgb(75, 192, 192)',
        borderColor: 'rgb(75, 192, 192)',
        data: [15, 25, 20, 30],
        fill: false,
    }]
};

var dataHandle = {
    labels: ['M', 'N', 'O', 'P'],
    datasets: [{
        label: 'Xử lý',
        backgroundColor: 'rgb(75, 192, 192)',
        borderColor: 'rgb(75, 192, 192)',
        data: [15, 25, 20, 30],
        fill: false,
    }]
};
// Cấu hình biểu đồ
var options = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
        yAxes: [{
            ticks: {
                beginAtZero: true
            }
        }]
    }
};

// Vẽ biểu đồ 1
var ctx1 = document.getElementById('chartMember').getContext('2d');
var myChart1 = new Chart(ctx1, {
    type: 'line',
    data: dataMember,
    options: options
});

// Vẽ biểu đồ 2
var ctx2 = document.getElementById('chartDepartment').getContext('2d');
var myChart2 = new Chart(ctx2, {
    type: 'bar',
    data: dataDepartment,
    options: options
});

// Vẽ biểu đồ 3
var ctx3 = document.getElementById('chartBranch').getContext('2d');
var myChart3 = new Chart(ctx3, {
    type: 'bar',
    data: dataBranch,
    options: options
});

// Vẽ biểu đồ 4
var ctx4 = document.getElementById('chartDevice').getContext('2d');
var myChart4 = new Chart(ctx4, {
    type: 'bar',
    data: dataDevice,
    options: options
});

// Vẽ biểu đồ 5
var ctx5 = document.getElementById('chartCurrent').getContext('2d');
var myChart5 = new Chart(ctx5, {
    type: 'bar',
    data: dataCurrent,
    options: options
});

// Vẽ biểu đồ 6
var ctx6 = document.getElementById('chartBranch').getContext('2d');
var myChart6 = new Chart(ctx6, {
    type: 'bar',
    data: dataHandle,
    options: options
});