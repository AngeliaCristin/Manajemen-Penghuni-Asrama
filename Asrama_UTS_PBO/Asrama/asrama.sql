-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2023 at 07:41 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asrama`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Username` char(5) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Username`, `Password`) VALUES
('User1', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `data_kamar`
--

CREATE TABLE `data_kamar` (
  `No_Kamar` varchar(5) NOT NULL,
  `lantai` varchar(2) NOT NULL,
  `Fasilitas` varchar(30) NOT NULL,
  `Harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_kamar`
--

INSERT INTO `data_kamar` (`No_Kamar`, `lantai`, `Fasilitas`, `Harga`) VALUES
('1.01', '1', 'AS', 350000),
('2.01', '2', 'AC', 350000);

-- --------------------------------------------------------

--
-- Table structure for table `data_penghuni`
--

CREATE TABLE `data_penghuni` (
  `id_penghuni` char(5) NOT NULL,
  `Nama` varchar(15) NOT NULL,
  `Alamat_KTP` varchar(30) NOT NULL,
  `Instansi` varchar(30) NOT NULL,
  `No_HP` varchar(15) NOT NULL,
  `No_Kamar` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `data_kamar`
--
ALTER TABLE `data_kamar`
  ADD PRIMARY KEY (`No_Kamar`);

--
-- Indexes for table `data_penghuni`
--
ALTER TABLE `data_penghuni`
  ADD PRIMARY KEY (`id_penghuni`),
  ADD UNIQUE KEY `DATA_PENGHUNI__IDX` (`No_Kamar`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_penghuni`
--
ALTER TABLE `data_penghuni`
  ADD CONSTRAINT `data_penghuni_ibfk_1` FOREIGN KEY (`No_Kamar`) REFERENCES `data_kamar` (`No_Kamar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
