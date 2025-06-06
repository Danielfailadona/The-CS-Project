-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2025 at 01:05 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs_s`
--

-- --------------------------------------------------------

--
-- Table structure for table `client_partition`
--

CREATE TABLE `client_partition` (
  `c_id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Total_size` varchar(255) NOT NULL,
  `Free_Space` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Deleted` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client_partition`
--

INSERT INTO `client_partition` (`c_id`, `Name`, `Total_size`, `Free_Space`, `Type`, `Deleted`) VALUES
(1, 'Drive 0 Partition 1: Recovery', '450.0 MB', '139.0 MB', 'Recovery', 'No'),
(2, 'Drive 0 Partition 2', '100.0 MB', '71.0 MB', 'System', 'No'),
(3, 'Drive 0 Partition 3', '16.0 MB', '16.0 MB', 'MSR (Reserved)', 'No'),
(4, 'Drive 0 Partition 4', '237.9 MB', '226.0 MB', 'Primary', 'No'),
(5, 'Drive 0 Unallocated Space', '60.0 GB', '60.0 GB', '', 'No');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
