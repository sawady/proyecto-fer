-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.49-1ubuntu8.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema FER
--

CREATE DATABASE IF NOT EXISTS FER;
USE FER;

--
-- Definition of table `FER`.`Equipo`
--

DROP TABLE IF EXISTS `FER`.`Equipo`;
CREATE TABLE  `FER`.`Equipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(60) CHARACTER SET ucs2 DEFAULT NULL,
  `tecnico` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_tecnicoequipo` (`tecnico`),
  CONSTRAINT `fk_tecnicoequipo` FOREIGN KEY (`tecnico`) REFERENCES `Tecnico` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

--
-- Dumping data for table `FER`.`Equipo`
--

/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
LOCK TABLES `Equipo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;


--
-- Definition of table `FER`.`Formacion`
--

DROP TABLE IF EXISTS `FER`.`Formacion`;
CREATE TABLE  `FER`.`Formacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk3` (`equipo`),
  CONSTRAINT `fk3` FOREIGN KEY (`equipo`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Formacion`
--

/*!40000 ALTER TABLE `Formacion` DISABLE KEYS */;
LOCK TABLES `Formacion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Formacion` ENABLE KEYS */;


--
-- Definition of table `FER`.`FormacionStrategy`
--

DROP TABLE IF EXISTS `FER`.`FormacionStrategy`;
CREATE TABLE  `FER`.`FormacionStrategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` char(50) CHARACTER SET ucs2 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`FormacionStrategy`
--

/*!40000 ALTER TABLE `FormacionStrategy` DISABLE KEYS */;
LOCK TABLES `FormacionStrategy` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `FormacionStrategy` ENABLE KEYS */;


--
-- Definition of table `FER`.`Habilidad`
--

DROP TABLE IF EXISTS `FER`.`Habilidad`;
CREATE TABLE  `FER`.`Habilidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(60) DEFAULT NULL,
  `jugador` int(11) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `posicion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jugadorhabilidad` (`jugador`),
  CONSTRAINT `fk_jugadorhabilidad` FOREIGN KEY (`jugador`) REFERENCES `Jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=967 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Habilidad`
--

/*!40000 ALTER TABLE `Habilidad` DISABLE KEYS */;
LOCK TABLES `Habilidad` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Habilidad` ENABLE KEYS */;


--
-- Definition of table `FER`.`Jugador`
--

DROP TABLE IF EXISTS `FER`.`Jugador`;
CREATE TABLE  `FER`.`Jugador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) DEFAULT NULL,
  `equipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_equipojugador` (`equipo`),
  CONSTRAINT `fk_equipojugador` FOREIGN KEY (`equipo`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=974 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Jugador`
--

/*!40000 ALTER TABLE `Jugador` DISABLE KEYS */;
LOCK TABLES `Jugador` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Jugador` ENABLE KEYS */;


--
-- Definition of table `FER`.`Partido`
--

DROP TABLE IF EXISTS `FER`.`Partido`;
CREATE TABLE  `FER`.`Partido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipo1` int(11) DEFAULT NULL,
  `equipo2` int(11) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(50) DEFAULT NULL,
  `golesEq1` int(11) DEFAULT NULL,
  `golesEq2` int(11) DEFAULT NULL,
  `formacionEq1` int(11) DEFAULT NULL,
  `formacionEq2` int(11) DEFAULT NULL,
  `golesPorPenalEq1` int(11) DEFAULT NULL,
  `golesPorPenalEq2` int(11) DEFAULT NULL,
  `partidoIda` int(11) DEFAULT NULL,
  `partidoVuelta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_eq1` (`equipo1`),
  KEY `fk_eq2` (`equipo2`),
  KEY `fk_formacionEq1` (`formacionEq1`),
  KEY `fk_formacionEq2` (`formacionEq2`),
  KEY `fk_partidoIda` (`partidoIda`),
  KEY `fk_partidoVuelta` (`partidoVuelta`),
  CONSTRAINT `fk_eq1` FOREIGN KEY (`equipo1`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eq2` FOREIGN KEY (`equipo2`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_formacionEq1` FOREIGN KEY (`formacionEq1`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_formacionEq2` FOREIGN KEY (`formacionEq2`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_partidoIda` FOREIGN KEY (`partidoIda`) REFERENCES `Partido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_partidoVuelta` FOREIGN KEY (`partidoVuelta`) REFERENCES `Partido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Partido`
--

/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
LOCK TABLES `Partido` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;


--
-- Definition of table `FER`.`PosicionesEnFormacionStrategy`
--

DROP TABLE IF EXISTS `FER`.`PosicionesEnFormacionStrategy`;
CREATE TABLE  `FER`.`PosicionesEnFormacionStrategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `indice` int(11) NOT NULL DEFAULT '0',
  `posicion` int(11) DEFAULT NULL,
  `formstrategy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=568 DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

--
-- Dumping data for table `FER`.`PosicionesEnFormacionStrategy`
--

/*!40000 ALTER TABLE `PosicionesEnFormacionStrategy` DISABLE KEYS */;
LOCK TABLES `PosicionesEnFormacionStrategy` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `PosicionesEnFormacionStrategy` ENABLE KEYS */;


--
-- Definition of table `FER`.`SuplenteEnFormacion`
--

DROP TABLE IF EXISTS `FER`.`SuplenteEnFormacion`;
CREATE TABLE  `FER`.`SuplenteEnFormacion` (
  `jugador` int(11) NOT NULL DEFAULT '0',
  `formacion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`jugador`,`formacion`) USING BTREE,
  KEY `fk_2` (`formacion`),
  CONSTRAINT `fk` FOREIGN KEY (`jugador`) REFERENCES `Jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_2` FOREIGN KEY (`formacion`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`SuplenteEnFormacion`
--

/*!40000 ALTER TABLE `SuplenteEnFormacion` DISABLE KEYS */;
LOCK TABLES `SuplenteEnFormacion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `SuplenteEnFormacion` ENABLE KEYS */;


--
-- Definition of table `FER`.`Tecnico`
--

DROP TABLE IF EXISTS `FER`.`Tecnico`;
CREATE TABLE  `FER`.`Tecnico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `form_strategy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `new_fk_constraint` (`form_strategy`),
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`form_strategy`) REFERENCES `FormacionStrategy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Tecnico`
--

/*!40000 ALTER TABLE `Tecnico` DISABLE KEYS */;
LOCK TABLES `Tecnico` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Tecnico` ENABLE KEYS */;


--
-- Definition of table `FER`.`Titular`
--

DROP TABLE IF EXISTS `FER`.`Titular`;
CREATE TABLE  `FER`.`Titular` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `posicion` int(11) DEFAULT NULL,
  `jugador` int(11) DEFAULT NULL,
  `formacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1` (`jugador`),
  KEY `fk2` (`formacion`),
  CONSTRAINT `fk1` FOREIGN KEY (`jugador`) REFERENCES `Jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`formacion`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Titular`
--

/*!40000 ALTER TABLE `Titular` DISABLE KEYS */;
LOCK TABLES `Titular` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `Titular` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
