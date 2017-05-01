CREATE DATABASE  IF NOT EXISTS `gestionsocios` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gestionsocios`;
-- MySQL dump 10.15  Distrib 10.0.23-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: gestionsocios
-- ------------------------------------------------------
-- Server version	10.0.23-MariaDB-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `combate`
--

DROP TABLE IF EXISTS `combate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combate` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_socio` int(11) DEFAULT NULL,
  `codigo_velada` int(11) DEFAULT NULL,
  `resultado` varchar(3) DEFAULT NULL,
  `comentarios` text,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`),
  KEY `fk_combate_velada_idx` (`codigo_velada`),
  KEY `fk_combate_socio_idx` (`codigo_socio`),
  CONSTRAINT `fk_combate_socio` FOREIGN KEY (`codigo_socio`) REFERENCES `socio` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_combate_velada` FOREIGN KEY (`codigo_velada`) REFERENCES `velada` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combate`
--

LOCK TABLES `combate` WRITE;
/*!40000 ALTER TABLE `combate` DISABLE KEYS */;
INSERT INTO `combate` VALUES (1,2,1,'VUD','Muy bien.',1),(2,2,2,'DSP','Muy mal.',1),(3,3,2,'DUD','Regular.',1),(4,8,2,'VUD','Excelente.',1),(5,1,3,'VUD','En la línea.',1),(6,2,3,'DUD','Injusto.',1),(7,8,3,'VUD','Violento.',1),(8,2,4,'VUD','Parado.',1),(9,3,4,'VUD','Igualado.',1),(10,1,5,'DSP','Igualado.',1),(11,2,5,'VUD','Con suerte.',1),(12,3,5,'DSP','Mala suerte.',1),(13,8,5,'VKT','Desigual.',1);
/*!40000 ALTER TABLE `combate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_socio` int(11) DEFAULT NULL,
  `fechapago` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `concepto` varchar(250) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`),
  KEY `fk_recibos_socios_idx` (`codigo_socio`),
  CONSTRAINT `fk_recibos_socios` FOREIGN KEY (`codigo_socio`) REFERENCES `socio` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT INTO `recibo` VALUES (1,1,'2017-01-03',30,'Cuota enero',1),(2,2,'2017-01-03',30,'Cuota enero',1),(3,3,'2017-01-03',30,'Cuota enero',1),(4,4,'2017-01-03',60,'Cuota diciembre, enero',1),(5,6,'2017-01-03',30,'Cuota enero',1),(6,7,'2017-01-03',30,'Cuota enero',1),(7,1,'2017-02-03',30,'Cuota febrero',1),(8,2,'2017-02-03',30,'Cuota febrero',1),(9,3,'2017-02-03',30,'Cuota febrero',1),(10,6,'2017-02-03',30,'Cuota febrero',1),(11,7,'2017-02-03',30,'Cuota febrero',1),(12,1,'2017-03-03',30,'Cuota marzo',1),(13,2,'2017-03-03',30,'Cuota marzo',1),(14,3,'2017-03-03',30,'Cuota marzo',1),(15,4,'2017-03-03',30,'Cuota marzo',1),(16,7,'2017-03-15',30,'Cuota marzo',1),(17,6,'2017-03-03',30,'Cuota marzo',1),(18,8,'2017-03-15',30,'Cuota marzo',1);
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `nrotarjeta` char(16) NOT NULL,
  `competidor` tinyint(1) NOT NULL DEFAULT '0',
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (1,'Miriam','Pérez Sánchez','666666666','','1234123412341234',1,1),(2,'Unai','López Agirre','655555555','uni@txo.com','',1,1),(3,'Roberto','González Gómez','644444444',NULL,'',0,1),(4,'Laura','Martínez Lobo','633333333',NULL,'',0,1),(5,'Romina','Gonález Bengoa','654321987',NULL,'',0,1),(6,'Paloma','Ramos Atxabal ','611111111',NULL,'',0,1),(7,'Raúl','García Suárez','600000000',NULL,'',0,1),(8,'Olatz','Azuaga Segura','677777777',NULL,'',0,1),(9,'Leire','Bilbao Lepettit','321654987','pepi@dura.com','1234567896325874',1,1);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `velada`
--

DROP TABLE IF EXISTS `velada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `velada` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `lugar` varchar(250) DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `comentarios` text,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `velada`
--

LOCK TABLES `velada` WRITE;
/*!40000 ALTER TABLE `velada` DISABLE KEYS */;
INSERT INTO `velada` VALUES (1,'2016-09-10','Avilés-Canapés.','Asturias','Un desastre.',0),(2,'2016-10-15','Bilbao','Bizkaia','Bien organizada.',1),(3,'2016-12-19','Bilbao','Bizkaia','Empezó tarde.',1),(4,'2017-02-04','Madrid','Madrid','Nos dieron de comer.',1),(5,'2017-03-18','Bilbao','Bizkaia','Muy larga.',1),(6,'2018-02-10','Hernani','Gipuzkoa','Esperamos que nos paguen.',1);
/*!40000 ALTER TABLE `velada` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-16 19:04:03
