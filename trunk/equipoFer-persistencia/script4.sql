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
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_tecnicoequipo` (`tecnico`),
  CONSTRAINT `fk_tecnicoequipo` FOREIGN KEY (`tecnico`) REFERENCES `Tecnico` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

--
-- Dumping data for table `FER`.`Equipo`
--

/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
LOCK TABLES `Equipo` WRITE;
INSERT INTO `FER`.`Equipo` VALUES  (3,'Boca',3,0),
 (4,'River',4,0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;


--
-- Definition of table `FER`.`Formacion`
--

DROP TABLE IF EXISTS `FER`.`Formacion`;
CREATE TABLE  `FER`.`Formacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipo` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk3` (`equipo`),
  CONSTRAINT `fk3` FOREIGN KEY (`equipo`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Formacion`
--

/*!40000 ALTER TABLE `Formacion` DISABLE KEYS */;
LOCK TABLES `Formacion` WRITE;
INSERT INTO `FER`.`Formacion` VALUES  (1,3,0),
 (2,4,0),
 (3,3,0),
 (4,4,0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Formacion` ENABLE KEYS */;


--
-- Definition of table `FER`.`FormacionStrategy`
--

DROP TABLE IF EXISTS `FER`.`FormacionStrategy`;
CREATE TABLE  `FER`.`FormacionStrategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` char(50) CHARACTER SET ucs2 DEFAULT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`FormacionStrategy`
--

/*!40000 ALTER TABLE `FormacionStrategy` DISABLE KEYS */;
LOCK TABLES `FormacionStrategy` WRITE;
INSERT INTO `FER`.`FormacionStrategy` VALUES  (3,'FormacionStrategyImpl',0),
 (4,'FormacionStrategyImpl',0);
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
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jugadorhabilidad` (`jugador`),
  CONSTRAINT `fk_jugadorhabilidad` FOREIGN KEY (`jugador`) REFERENCES `Jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Habilidad`
--

/*!40000 ALTER TABLE `Habilidad` DISABLE KEYS */;
LOCK TABLES `Habilidad` WRITE;
INSERT INTO `FER`.`Habilidad` VALUES  (15,'HabilidadImpl',15,12,2,0),
 (16,'HabilidadImpl',16,12,3,0),
 (17,'HabilidadImpl',17,12,7,0),
 (18,'HabilidadImpl',18,12,5,0),
 (19,'HabilidadImpl',19,12,0,0),
 (20,'HabilidadImpl',20,12,5,0),
 (21,'HabilidadImpl',21,12,7,0),
 (22,'HabilidadImpl',22,12,7,0),
 (23,'HabilidadImpl',23,12,0,0),
 (24,'HabilidadImpl',24,12,7,0),
 (25,'HabilidadImpl',25,12,5,0),
 (26,'HabilidadImpl',26,12,5,0),
 (27,'HabilidadImpl',27,12,2,0),
 (28,'HabilidadImpl',28,12,3,0);
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
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_equipojugador` (`equipo`),
  CONSTRAINT `fk_equipojugador` FOREIGN KEY (`equipo`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Jugador`
--

/*!40000 ALTER TABLE `Jugador` DISABLE KEYS */;
LOCK TABLES `Jugador` WRITE;
INSERT INTO `FER`.`Jugador` VALUES  (15,'Martin',3,0),
 (16,'Jose',3,0),
 (17,'Seba',3,0),
 (18,'Marcelo',3,0),
 (19,'Juan',3,0),
 (20,'Fabian',3,0),
 (21,'Carlos',3,0),
 (22,'Seba',4,0),
 (23,'Juan',4,0),
 (24,'Carlos',4,0),
 (25,'Fabian',4,0),
 (26,'Marcelo',4,0),
 (27,'Martin',4,0),
 (28,'Jose',4,0);
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
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_p_eq1` (`equipo1`),
  KEY `fk_p_eq2` (`equipo2`),
  CONSTRAINT `fk_p_eq1` FOREIGN KEY (`equipo1`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_p_eq2` FOREIGN KEY (`equipo2`) REFERENCES `Equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Partido`
--

/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
LOCK TABLES `Partido` WRITE;
INSERT INTO `FER`.`Partido` VALUES  (1,3,4,0),
 (2,3,4,0),
 (3,3,4,0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;


--
-- Definition of table `FER`.`PartidoDeCopa`
--

DROP TABLE IF EXISTS `FER`.`PartidoDeCopa`;
CREATE TABLE  `FER`.`PartidoDeCopa` (
  `id` int(11) NOT NULL,
  `golesPorPenalEq1` int(11) DEFAULT NULL,
  `golesPorPenalEq2` int(11) DEFAULT NULL,
  `partidoIda` int(11) DEFAULT NULL,
  `partidoVuelta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_partidoIda` (`partidoIda`),
  KEY `fk_partidoVuelta` (`partidoVuelta`),
  CONSTRAINT `fk_pc_id` FOREIGN KEY (`id`) REFERENCES `Partido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`PartidoDeCopa`
--

/*!40000 ALTER TABLE `PartidoDeCopa` DISABLE KEYS */;
LOCK TABLES `PartidoDeCopa` WRITE;
INSERT INTO `FER`.`PartidoDeCopa` VALUES  (3,0,0,1,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `PartidoDeCopa` ENABLE KEYS */;


--
-- Definition of table `FER`.`PartidoSimple`
--

DROP TABLE IF EXISTS `FER`.`PartidoSimple`;
CREATE TABLE  `FER`.`PartidoSimple` (
  `id` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `golesEq1` int(11) DEFAULT NULL,
  `golesEq2` int(11) DEFAULT NULL,
  `formacionEq1` int(11) DEFAULT NULL,
  `formacionEq2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ps_formacionEq1` (`formacionEq1`),
  KEY `fk_ps_formacionEq2` (`formacionEq2`),
  CONSTRAINT `fk_ps_id` FOREIGN KEY (`id`) REFERENCES `Partido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ps_formacionEq1` FOREIGN KEY (`formacionEq1`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ps_formacionEq2` FOREIGN KEY (`formacionEq2`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`PartidoSimple`
--

/*!40000 ALTER TABLE `PartidoSimple` DISABLE KEYS */;
LOCK TABLES `PartidoSimple` WRITE;
INSERT INTO `FER`.`PartidoSimple` VALUES  (1,'2010-03-21 10:30:00',3,5,1,2),
 (2,'2010-03-22 04:30:00',2,4,3,4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `PartidoSimple` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

--
-- Dumping data for table `FER`.`PosicionesEnFormacionStrategy`
--

/*!40000 ALTER TABLE `PosicionesEnFormacionStrategy` DISABLE KEYS */;
LOCK TABLES `PosicionesEnFormacionStrategy` WRITE;
INSERT INTO `FER`.`PosicionesEnFormacionStrategy` VALUES  (1,0,0,3),
 (2,1,3,3),
 (3,2,2,3),
 (4,3,5,3),
 (5,4,7,3),
 (6,0,0,4),
 (7,1,3,4),
 (8,2,2,4),
 (9,3,5,4),
 (10,4,7,4);
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
INSERT INTO `FER`.`SuplenteEnFormacion` VALUES  (20,1),
 (21,1),
 (22,2),
 (25,2),
 (20,3),
 (21,3),
 (22,4),
 (25,4);
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
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `new_fk_constraint` (`form_strategy`),
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`form_strategy`) REFERENCES `FormacionStrategy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Tecnico`
--

/*!40000 ALTER TABLE `Tecnico` DISABLE KEYS */;
LOCK TABLES `Tecnico` WRITE;
INSERT INTO `FER`.`Tecnico` VALUES  (3,'Bianchi',3,0),
 (4,'Bianchi',4,0);
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
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1` (`jugador`),
  KEY `fk2` (`formacion`),
  CONSTRAINT `fk1` FOREIGN KEY (`jugador`) REFERENCES `Jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`formacion`) REFERENCES `Formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FER`.`Titular`
--

/*!40000 ALTER TABLE `Titular` DISABLE KEYS */;
LOCK TABLES `Titular` WRITE;
INSERT INTO `FER`.`Titular` VALUES  (1,3,16,1,0),
 (2,7,17,1,0),
 (3,5,18,1,0),
 (4,0,19,1,0),
 (5,2,15,1,0),
 (6,5,26,2,0),
 (7,3,28,2,0),
 (8,0,23,2,0),
 (9,7,24,2,0),
 (10,2,27,2,0),
 (11,5,18,3,0),
 (12,3,16,3,0),
 (13,7,17,3,0),
 (14,0,19,3,0),
 (15,2,15,3,0),
 (16,5,26,4,0),
 (17,2,27,4,0),
 (18,7,24,4,0),
 (19,3,28,4,0),
 (20,0,23,4,0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Titular` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
