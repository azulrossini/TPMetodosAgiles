﻿-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 07, 2018 at 04:06 AM
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
CREATE DATABASE IF NOT EXISTS `lic_sf_bd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `lic_sf_bd`;

-- --------------------------------------------------------

--
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
CREATE TABLE IF NOT EXISTS `clase` (
  `id` varchar(1) NOT NULL,
  `vehiculos` varchar(64) NOT NULL,
  `edad_minima` int(2) NOT NULL,
  `clases_heredadas_id` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_clases_heredadas` (`clases_heredadas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clase`
--

INSERT INTO `clase` (`id`, `vehiculos`, `edad_minima`, `clases_heredadas_id`) VALUES
('A', 'Ciclomotores, motocicletas y triciclos motorizados', 17, NULL),
('B', 'Automóviles y camionetas con acoplado', 17, NULL),
('C', 'Camiones sin acoplado', 21, 'B'),
('D', 'Servicio de transporte de pasajeros, emergencia, seguridad', 21, 'C'),
('E', 'Camiones con acoplado, maquinaria especial no agrícola', 21, 'C'),
('F', 'Automotores especialmente adaptados para discapacitados', 17, NULL),
('G', 'Tractores agrícolas y maquinaria especial agrícola', 17, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `costos`
--

DROP TABLE IF EXISTS `costos`;
CREATE TABLE IF NOT EXISTS `costos` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `clase` varchar(1) NOT NULL,
  `anios` int(1) NOT NULL,
  `precio` float(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clase` (`clase`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `costos`
--

INSERT INTO `costos` (`id`, `clase`, `anios`, `precio`) VALUES
(1, 'A', 1, 20.00),
(2, 'A', 3, 25.00),
(3, 'A', 4, 30.00),
(4, 'A', 5, 40.00),
(5, 'B', 1, 20.00),
(6, 'B', 3, 25.00),
(7, 'B', 4, 30.00),
(8, 'B', 5, 40.00),
(9, 'C', 1, 23.00),
(10, 'C', 3, 30.00),
(11, 'C', 4, 35.00),
(12, 'C', 5, 47.00),
(13, 'D', 1, 29.00),
(14, 'D', 3, 39.00),
(15, 'D', 4, 44.00),
(16, 'D', 5, 59.00),
(17, 'E', 1, 29.00),
(18, 'E', 3, 39.00),
(19, 'E', 4, 44.00),
(20, 'E', 5, 59.00),
(21, 'F', 1, 20.00),
(22, 'F', 3, 25.00),
(23, 'F', 4, 30.00),
(24, 'F', 5, 40.00),
(25, 'G', 1, 20.00),
(26, 'G', 3, 25.00),
(27, 'G', 4, 30.00),
(28, 'G', 5, 40.00);

-- --------------------------------------------------------

--
-- Table structure for table `licencia`
--

DROP TABLE IF EXISTS `licencia`;
CREATE TABLE IF NOT EXISTS `licencia` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `persona_id` int(10) NOT NULL,
  `clase_id` varchar(1) NOT NULL,
  `usuario_id` int(2) NOT NULL,
  `costo_id` int(2) NOT NULL,
  `vigencia_id` int(1) NOT NULL,
  `motivo` varchar(10) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_venc` date NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_lic` (`persona_id`),
  KEY `fk_clase_lic` (`clase_id`),
  KEY `fk_usuario_lic` (`usuario_id`),
  KEY `fk_costo_lic` (`costo_id`),
  KEY `fk_vigencia_lic` (`vigencia_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `licencia`
--

INSERT INTO `licencia` (`id`, `persona_id`, `clase_id`, `usuario_id`, `costo_id`, `vigencia_id`, `motivo`, `fecha_emision`, `fecha_venc`, `observaciones`) VALUES
(1, 12, 'A', 0, 4, 0, 'ORIGINAL', '2018-11-01', '2023-11-21', ''),
(2, 13, 'A', 0, 1, 0, 'ORIGINAL', '2018-11-01', '2019-09-21', '');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tipo_id` varchar(9) NOT NULL,
  `nro_id` varchar(11) NOT NULL,
  `apellido` varchar(32) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `fecha_nac` date NOT NULL,
  `domicilio` varchar(32) NOT NULL,
  `grupo_sanguineo` varchar(2) NOT NULL,
  `factor` varchar(1) NOT NULL,
  `donante` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `tipo_id`, `nro_id`, `apellido`, `nombre`, `fecha_nac`, `domicilio`, `grupo_sanguineo`, `factor`, `donante`) VALUES
(1, 'DNI', '40053701', 'Fedele', 'Fausto', '1997-05-06', 'Avellaneda 2178', 'O', '+', 1),
(2, 'DNI', '24789349', 'jsfkj', 'askjd', '1997-08-21', 'kajsd 8239  ', 'O', '+', 0),
(3, 'DNI', '23847436', 'jhdaj', 'ahad', '1997-02-02', 'jahdajs 2738  ', 'O', '+', 0),
(6, 'DNI', '40115862', 'jdas', 'asdhj', '1997-09-21', 'ajhasdl 889  ', 'O', '+', 0),
(5, 'DNI', '40115862', 'Rossini', 'Azul', '1997-05-21', 'La Tatenguita 478  ', 'O', '+', 1),
(7, 'DNI', '40115862', 'ljasd', 'auha', '1999-01-01', 'akjsdl 833  ', 'O', '+', 0),
(8, 'DNI', '40115862', 'ajsd', 'asdlj', '1999-09-21', 'asdlj 7138  ', 'O', '+', 0),
(9, 'DNI', '40115862', 'ajsd', 'asdlj', '1999-09-21', 'asdlj 7138  ', 'O', '+', 0),
(10, 'DNI', '37584638', 'jhdas', 'ajds', '1999-11-21', 'asdjhl 2389  ', 'O', '+', 0),
(11, 'DNI', '23478496', 'jhdlas', 'ahads', '1978-08-21', 'ahsdjm 2378  ', 'O', '+', 0),
(12, 'DNI', '40115862', 'rossi', 'azul', '1996-11-21', 'asdhj 389  ', 'O', '+', 0),
(13, 'DNI', '10382758', 'asdjl', 'asdjk', '1999-09-21', 'xxzx 222  ', 'O', '+', 0);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varbinary(20) NOT NULL,
  `privilegio` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
