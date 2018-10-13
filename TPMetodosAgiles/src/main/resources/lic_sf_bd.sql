-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 13, 2018 at 06:34 AM
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
  `id` varchar(1) NOT NULL,
  `un_año` int(3) NOT NULL,
  `tres_años` int(3) NOT NULL,
  `cuatro_años` int(3) NOT NULL,
  `cinco_años` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `costos`
--

INSERT INTO `costos` (`id`, `un_año`, `tres_años`, `cuatro_años`, `cinco_años`) VALUES
('A', 40, 30, 25, 20),
('B', 40, 30, 25, 20),
('C', 47, 35, 30, 23),
('E', 59, 44, 39, 29),
('G', 40, 30, 25, 20);

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
  `costo_id` varchar(1) NOT NULL,
  `vigencia_id` int(1) NOT NULL,
  `motivo` varchar(10) NOT NULL,
  `fecha_emision` date NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_lic` (`persona_id`),
  KEY `fk_clase_lic` (`clase_id`),
  KEY `fk_usuario_lic` (`usuario_id`),
  KEY `fk_costo_lic` (`costo_id`),
  KEY `fk_vigencia_lic` (`vigencia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tipo_id` varchar(3) NOT NULL,
  `nro_id` int(8) NOT NULL,
  `apellido` varchar(32) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `fecha_nac` date NOT NULL,
  `domicilio` varchar(32) NOT NULL,
  `grupo_sanguineo` varchar(2) NOT NULL,
  `factor` varchar(1) NOT NULL,
  `donante` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `persona_id` int(10) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `privilegio` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_usuario` (`persona_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vigencias`
--

DROP TABLE IF EXISTS `vigencias`;
CREATE TABLE IF NOT EXISTS `vigencias` (
  `id` int(1) NOT NULL,
  `primera_menor_21` int(1) NOT NULL,
  `segunda_menor_21` int(1) NOT NULL,
  `menor_46` int(1) NOT NULL,
  `menor_60` int(1) NOT NULL,
  `menor_70` int(1) NOT NULL,
  `mayor_70` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vigencias`
--

INSERT INTO `vigencias` (`id`, `primera_menor_21`, `segunda_menor_21`, `menor_46`, `menor_60`, `menor_70`, `mayor_70`) VALUES
(1, 1, 3, 5, 4, 3, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
