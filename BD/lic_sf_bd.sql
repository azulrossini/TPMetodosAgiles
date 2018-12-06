-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 06, 2018 at 01:51 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lic_sf_bd`
--

-- --------------------------------------------------------

--
-- Table structure for table `vigencias`
--

DROP TABLE IF EXISTS `vigencias`;
CREATE TABLE IF NOT EXISTS `vigencias` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `condicion` varchar(16) NOT NULL,
  `duracion` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vigencias`
--

INSERT INTO `vigencias` (`id`, `condicion`, `duracion`) VALUES
(1, 'primera_menor_21', 1),
(2, 'segunda_menor_21', 3),
(3, 'menor_46', 5),
(4, 'menor_60', 4),
(5, 'menor_70', 3),
(6, 'mayor_70', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
