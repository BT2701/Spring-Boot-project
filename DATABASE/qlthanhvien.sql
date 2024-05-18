-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for qlthanhvien
CREATE DATABASE IF NOT EXISTS `qlthanhvien` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `qlthanhvien`;

-- Dumping structure for table qlthanhvien.thanhvien
CREATE TABLE IF NOT EXISTS `thanhvien` (
  `MaTV` int(10) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Khoa` varchar(100) DEFAULT NULL,
  `Nganh` varchar(100) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`MaTV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlthanhvien.thanhvien: ~25 rows (approximately)
INSERT INTO `thanhvien` (`MaTV`, `HoTen`, `Khoa`, `Nganh`, `SDT`, `email`, `password`) VALUES
	(1111111111, 'admin', NULL, NULL, NULL, 'truongnopro1111@gmail.com', 'admin'),
	(1120150137, 'Phan Thị Thanh Hằng', 'GDTH', 'GDTH', '0911201501', '1120150137@gmail.com', '1120150137'),
	(1121430037, 'Nguyễn Thị Phương Diễm', 'Luật', 'LHC', '0911214300', '1121430037@gmail.com', '1121430037'),
	(1121430051, 'Nguyễn Thị Tuyết Dung', 'Luật', 'LHC', '0911214300', '1121430051@gmail.com', '1121430051'),
	(1121430200, 'Lê Ngọc Linh', 'Luật', 'LHC', '0911214302', '1121430200@gmail.com', '1121430200'),
	(1121666666, 'user1121666666', 'CNTT', 'Kỹ thuật phần mềm', NULL, 'truong@gmail.com', 'truong123'),
	(1121777777, 'user1121777777', 'CNTT', 'Kỹ thuật phần mềm', NULL, 'dttruonga8tqtpy@gmail.com', 'truong123'),
	(1122130055, 'Phan Văn Anh', 'Ngoại Ngữ', 'Anh', '0911221300', '1122130055@gmail.com', '1122130055'),
	(1122380173, 'Hoàng Bích Hà', 'Ngoại Ngữ', 'NNA', '0911223801', '1122380173@gmail.com', '1122380173'),
	(1122520013, 'Lê Nguyễn Phương Linh', 'ĐT-VT', 'CNKTDTTT', '0911225200', '1122520013@gmail.com', '1122520013'),
	(1123380190, 'Trần Bùi Thảo My', 'Ngoại Ngữ', 'NNA', '0911233801', '1123380190@gmail.com', '1123380190'),
	(1123380205, 'Mai Thị Minh Huyền', 'Ngoại Ngữ', 'NNA', '0911233802', '1123380205@gmail.com', '1123380205'),
	(1123380365, 'Nguyễn Ngọc Thảo Vy', 'Ngoại Ngữ', 'NNA', '0911233803', '1123380365@gmail.com', '1123380365'),
	(1123430154, 'Đinh Hoàng Linh Chi', 'Luật', 'LHC', '0911234301', '1123430154@gmail.com', '1123430154'),
	(1124123456, 'Phạm Tấn Đạt', 'CNTT', 'Kỹ thuật phần mềm', '1234567890', 'a@gmail.com', 'dat123'),
	(1124123457, 'Phạm Văn Dự', 'CNTT', 'Kỹ thuật phần mềm', '1231231231', 'b@gmail.com', 'du123'),
	(1124123458, 'Dương Thành Trưởng', 'CNTT', 'Kỹ thuật phần mềm', '1234567890', 'truongnopro1111@gmail.com', 'truong123'),
	(1124123459, 'Võ Trần Linh', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', ''),
	(1124123460, 'Lý Thanh Phát', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', ''),
	(1124123461, 'Lê Đức Toàn', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', ''),
	(1124123462, 'Nguyễn Nhật Trường', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', ''),
	(1124123463, 'Ngô Hoàng Minh Trí', 'CNTT', 'Khoa học máy tính', '1234567890', '', ''),
	(1124123464, 'Nguyễn Hà Phi Hùng', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', ''),
	(1124123465, 'Trịnh Quang Trường', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', ''),
	(1124123466, 'Trần Minh Quân', 'CNTT', 'Công nghệ phần mềm', '1234567890', '', '');

-- Dumping structure for table qlthanhvien.thietbi
CREATE TABLE IF NOT EXISTS `thietbi` (
  `MaTB` int(10) NOT NULL,
  `TenTB` varchar(100) NOT NULL,
  `MoTaTB` text DEFAULT NULL,
  PRIMARY KEY (`MaTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlthanhvien.thietbi: ~24 rows (approximately)
INSERT INTO `thietbi` (`MaTB`, `TenTB`, `MoTaTB`) VALUES
	(100001, 'Micro Không dây', 'Micro bluetooth'),
	(120191, 'Micro không dây 01', 'JBL VM 2001'),
	(120192, 'Micro có dây 01', 'MCCD 1001'),
	(120203, 'Micro không dây 02', 'BCE 9001'),
	(120214, 'Micro không dây 03', 'M3001'),
	(120235, 'Micro không dây 03', 'BCE UGX12'),
	(200001, 'Máy chiếu cỡ lớn', 'Máy chiếu sử dụng công nghệ led'),
	(220191, 'Máy chiếu Panasonic', 'PNSN 031'),
	(300001, 'Máy ảnh', 'Siêu cấp vip pro'),
	(320201, 'Máy ảnh Fuji', 'FJ 20201'),
	(400001, 'Cassette', 'Đỉnh quá shop'),
	(420201, 'Cassette Sony', 'CN 20201'),
	(420212, 'Cassette Sony', 'CN 20211'),
	(420213, 'Cassette TQ', 'CSTQ 20211'),
	(420224, 'Cassette Sony', 'CS 20221'),
	(420236, 'Cassette Sony', 'CS 2023'),
	(500001, 'Tivi', 'Đã quá pepsi ơi'),
	(520221, 'Tivi LG', 'TVLG021'),
	(520222, 'Tivi Samsung', 'TVSS20221'),
	(600001, 'Quạt đứng cao cấp', 'Vỗ tay'),
	(620231, 'Quạt đứng', 'QD 20231'),
	(620232, 'Quạt đứng', 'QD 20232'),
	(620233, 'Quạt đứng', 'QD 20233'),
	(620234, 'Quạt đứng', 'QD 20234');

-- Dumping structure for table qlthanhvien.thongtinsd
CREATE TABLE IF NOT EXISTS `thongtinsd` (
  `MaTT` int(10) NOT NULL AUTO_INCREMENT,
  `MaTV` int(10) NOT NULL,
  `MaTB` int(10) DEFAULT NULL,
  `TGVao` datetime DEFAULT NULL,
  `TGMuon` datetime DEFAULT NULL,
  `TGTra` datetime DEFAULT NULL,
  `TGDatCho` datetime DEFAULT NULL,
  PRIMARY KEY (`MaTT`),
  KEY `MaTV` (`MaTV`,`MaTB`),
  KEY `MaTB` (`MaTB`),
  CONSTRAINT `fk_matb` FOREIGN KEY (`MaTB`) REFERENCES `thietbi` (`MaTB`),
  CONSTRAINT `fk_matv` FOREIGN KEY (`MaTV`) REFERENCES `thanhvien` (`MaTV`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlthanhvien.thongtinsd: ~12 rows (approximately)
INSERT INTO `thongtinsd` (`MaTT`, `MaTV`, `MaTB`, `TGVao`, `TGMuon`, `TGTra`, `TGDatCho`) VALUES
	(37, 1124123458, 100001, NULL, '2024-05-13 09:45:42', NULL, NULL),
	(38, 1124123456, 200001, NULL, '2024-05-13 09:45:50', NULL, NULL),
	(39, 1124123460, NULL, '2024-05-13 09:46:01', NULL, NULL, NULL),
	(40, 1124123465, 500001, NULL, '2024-05-13 09:47:30', '2024-05-13 09:47:39', NULL),
	(41, 1124123458, 300001, NULL, NULL, NULL, '2024-05-22 09:59:00'),
	(45, 1124123458, 400001, NULL, NULL, NULL, '2024-05-30 12:50:00'),
	(46, 1121666666, 120191, NULL, NULL, NULL, '2024-05-30 13:09:00'),
	(47, 1121666666, 120192, NULL, NULL, NULL, '2024-05-23 13:09:00'),
	(48, 1121666666, 120191, NULL, NULL, NULL, '2024-05-29 13:10:00'),
	(49, 1121430200, NULL, '2024-05-13 13:18:17', NULL, NULL, NULL),
	(50, 1121430200, 620232, NULL, '2024-05-13 13:24:30', NULL, NULL),
	(51, 1121430200, 220191, NULL, '2024-05-13 13:27:18', NULL, NULL);

-- Dumping structure for table qlthanhvien.xuly
CREATE TABLE IF NOT EXISTS `xuly` (
  `MaXL` int(10) NOT NULL AUTO_INCREMENT,
  `MaTV` int(10) NOT NULL,
  `HinhThucXL` varchar(250) DEFAULT NULL,
  `SoTien` int(100) DEFAULT NULL,
  `NgayXL` datetime DEFAULT NULL,
  `TrangThaiXL` int(2) DEFAULT NULL,
  PRIMARY KEY (`MaXL`),
  KEY `MaTV` (`MaTV`),
  KEY `MaTV_2` (`MaTV`),
  CONSTRAINT `FKa0dgbfa4l5gv4vtgvbnf44o1p` FOREIGN KEY (`MaTV`) REFERENCES `thanhvien` (`MaTV`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qlthanhvien.xuly: ~4 rows (approximately)
INSERT INTO `xuly` (`MaXL`, `MaTV`, `HinhThucXL`, `SoTien`, `NgayXL`, `TrangThaiXL`) VALUES
	(14, 1124123462, 'Khóa thẻ', NULL, '2024-05-13 09:46:13', 1),
	(15, 1124123460, 'Phạt tiền 50,000đ', 50000, '2024-05-13 09:46:51', 1),
	(16, 1124123463, 'Phạt tiền 100,000đ', 100000, '2024-05-13 09:47:15', 0),
	(17, 1121430200, 'Khóa thẻ 1 năm', NULL, '2024-05-13 13:25:30', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
