-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2015 at 03:55 AM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;



-- --------------------------------------------------------

--
-- Table structure for table `operaciones`
--

CREATE TABLE IF NOT EXISTS `operaciones` (
  `idaportaciones` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `cantidad` double NOT NULL,
  `portafolios` int(11) NOT NULL,
  `tipooperacion` varchar(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `operaciones`
--

INSERT INTO `operaciones` (`idaportaciones`, `fecha`, `cantidad`, `portafolios`, `tipooperacion`) VALUES
(2, '2015-08-20 00:00:00', 98.001, 6, NULL),
(30, '2015-09-21 10:46:27', 10, 6, 'RT'),
(31, '2015-09-21 10:46:27', 20, 6, 'RT'),
(33, '2015-09-21 14:42:42', 1000, 6, 'AP');

-- --------------------------------------------------------

--
-- Table structure for table `portafolios`
--

CREATE TABLE IF NOT EXISTS `portafolios` (
  `idportafolios` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `valorinicial` double NOT NULL,
  `fechacreacion` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `portafolios`
--

INSERT INTO `portafolios` (`idportafolios`, `nombre`, `valorinicial`, `fechacreacion`) VALUES
(6, 'ENEFIN 1', 5036, '2014-11-19 15:38:00');

-- --------------------------------------------------------

--
-- Table structure for table `resultados`
--

CREATE TABLE IF NOT EXISTS `resultados` (
  `idresultados` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `protafolios` int(11) NOT NULL,
  `valor` double NOT NULL,
  `profit` double NOT NULL,
  `rendimiento` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resultados`
--

INSERT INTO `resultados` (`idresultados`, `fecha`, `protafolios`, `valor`, `profit`, `rendimiento`) VALUES
(3, '2015-09-17 17:49:53', 6, 5101.89, 100, 0.029787),
(4, '2015-09-17 17:50:03', 6, 5101.89, 100, 0.029787),
(5, '2015-09-17 18:00:42', 6, 5101.89, 100, 0.029787),
(6, '2015-09-18 10:38:48', 6, 5101.89, 100, 0.029787),
(7, '2015-09-18 10:41:23', 6, 5101.89, 100, 0.029787),
(8, '2015-09-18 10:45:45', 6, 5101.89, 100, 0.029787);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `operaciones`
--
ALTER TABLE `operaciones`
  ADD PRIMARY KEY (`idaportaciones`),
  ADD KEY `fk_aportacion_portafolio_idx` (`portafolios`);

--
-- Indexes for table `portafolios`
--
ALTER TABLE `portafolios`
  ADD PRIMARY KEY (`idportafolios`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indexes for table `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`idresultados`),
  ADD UNIQUE KEY `resultadodiario` (`fecha`,`protafolios`),
  ADD KEY `fk_resultado_portafolios_idx` (`protafolios`);

--
-- AUTO_INCREMENT for dumped tables
--


--
-- AUTO_INCREMENT for table `operaciones`
--
ALTER TABLE `operaciones`
  MODIFY `idaportaciones` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `portafolios`
--
ALTER TABLE `portafolios`
  MODIFY `idportafolios` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `resultados`
--
ALTER TABLE `resultados`
  MODIFY `idresultados` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `aportaciones`
--
-- Constraints for table `operaciones`
--
ALTER TABLE `operaciones`
  ADD CONSTRAINT `fk_aportacion_portafolio` FOREIGN KEY (`portafolios`) REFERENCES `portafolios` (`idportafolios`);

--
-- Constraints for table `resultados`
--
ALTER TABLE `resultados`
  ADD CONSTRAINT `fk_resultado_portafolios` FOREIGN KEY (`protafolios`) REFERENCES `portafolios` (`idportafolios`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
