-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: www_covid_tracker
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `coordinate_id` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`),
  KEY `location_fk` (`coordinate_id`),
  CONSTRAINT `location_fk` FOREIGN KEY (`coordinate_id`) REFERENCES `coordinate` (`coordinate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,NULL,'China'),(2,NULL,'Italy'),(3,NULL,'Spain'),(4,NULL,'USA'),(5,NULL,'Germany'),(6,NULL,'Iran'),(7,NULL,'France'),(8,NULL,'S-Korea'),(9,NULL,'Switzerland'),(10,NULL,'UK'),(11,NULL,'Netherlands'),(12,NULL,'Austria'),(13,NULL,'Belgium'),(14,NULL,'Norway'),(15,NULL,'Sweden'),(16,NULL,'Canada'),(17,NULL,'Denmark'),(18,NULL,'Portugal'),(19,NULL,'Malaysia'),(20,NULL,'Brazil'),(21,NULL,'Australia'),(22,NULL,'Japan'),(23,NULL,'Czechia'),(24,NULL,'Turkey'),(25,NULL,'Israel'),(26,NULL,'Ireland'),(27,NULL,'Diamond-Princess-'),(28,NULL,'Luxembourg'),(29,NULL,'Pakistan'),(30,NULL,'Chile'),(31,NULL,'Poland'),(32,NULL,'Ecuador'),(33,NULL,'Greece'),(34,NULL,'Finland'),(35,NULL,'Qatar'),(36,NULL,'Iceland'),(37,NULL,'Indonesia'),(38,NULL,'Singapore'),(39,NULL,'Thailand'),(40,NULL,'Saudi-Arabia'),(41,NULL,'Slovenia'),(42,NULL,'Romania'),(43,NULL,'India'),(44,NULL,'Peru'),(45,NULL,'Bahrain'),(46,NULL,'Philippines'),(47,NULL,'Russia'),(48,NULL,'Estonia'),(49,NULL,'Egypt'),(50,NULL,'Hong-Kong'),(51,NULL,'South-Africa'),(52,NULL,'Lebanon'),(53,NULL,'Iraq'),(54,NULL,'Croatia'),(55,NULL,'Mexico'),(56,NULL,'Panama'),(57,NULL,'Colombia'),(58,NULL,'Slovakia'),(59,NULL,'Kuwait'),(60,NULL,'Serbia'),(61,NULL,'Bulgaria'),(62,NULL,'San-Marino'),(63,NULL,'Armenia'),(64,NULL,'Argentina'),(65,NULL,'Taiwan'),(66,NULL,'UAE'),(67,NULL,'Algeria'),(68,NULL,'Latvia'),(69,NULL,'Costa-Rica'),(70,NULL,'Dominican-Republic'),(71,NULL,'Uruguay'),(72,NULL,'Hungary'),(73,NULL,'Jordan'),(74,NULL,'Lithuania'),(75,NULL,'Morocco'),(76,NULL,'Vietnam'),(77,NULL,'Bosnia-and-Herzegovina'),(78,NULL,'Faeroe-Islands'),(79,NULL,'Andorra'),(80,NULL,'North-Macedonia'),(81,NULL,'Cyprus'),(82,NULL,'Brunei'),(83,NULL,'Moldova'),(84,NULL,'Sri-Lanka'),(85,NULL,'Albania'),(86,NULL,'Belarus'),(87,NULL,'Malta'),(88,NULL,'Venezuela'),(89,NULL,'Burkina-Faso'),(90,NULL,'Tunisia'),(91,NULL,'Guadeloupe'),(92,NULL,'Senegal'),(93,NULL,'Kazakhstan'),(94,NULL,'Azerbaijan'),(95,NULL,'Cambodia'),(96,NULL,'Palestine'),(97,NULL,'New-Zealand'),(98,NULL,'Oman'),(99,NULL,'Georgia'),(100,NULL,'Trinidad-and-Tobago'),(101,NULL,'Ukraine'),(102,NULL,'R&eacute;union'),(103,NULL,'Uzbekistan'),(104,NULL,'Cameroon'),(105,NULL,'Martinique'),(106,NULL,'Liechtenstein'),(107,NULL,'Channel-Islands'),(108,NULL,'Bangladesh'),(109,NULL,'Afghanistan'),(110,NULL,'Honduras'),(111,NULL,'DRC'),(112,NULL,'Nigeria'),(113,NULL,'Cuba'),(114,NULL,'Ghana'),(115,NULL,'Puerto-Rico'),(116,NULL,'Jamaica'),(117,NULL,'Bolivia'),(118,NULL,'Guyana'),(119,NULL,'Paraguay'),(120,NULL,'Macao'),(121,NULL,'Monaco'),(122,NULL,'French-Guiana'),(123,NULL,'Guatemala'),(124,NULL,'Rwanda'),(125,NULL,'Montenegro'),(126,NULL,'Togo'),(127,NULL,'French-Polynesia'),(128,NULL,'Guam'),(129,NULL,'Mauritius'),(130,NULL,'Barbados'),(131,NULL,'Ivory-Coast'),(132,NULL,'Kyrgyzstan'),(133,NULL,'Maldives'),(134,NULL,'Mayotte'),(135,NULL,'Gibraltar'),(136,NULL,'Mongolia'),(137,NULL,'Ethiopia'),(138,NULL,'Kenya'),(139,NULL,'Seychelles'),(140,NULL,'Equatorial-Guinea'),(141,NULL,'Tanzania'),(142,NULL,'US-Virgin-Islands'),(143,NULL,'Gabon'),(144,NULL,'Aruba'),(145,NULL,'Saint-Martin'),(146,NULL,'Suriname'),(147,NULL,'Bahamas'),(148,NULL,'New-Caledonia'),(149,NULL,'Cayman-Islands'),(150,NULL,'Cura&ccedil;ao'),(151,NULL,'Cabo-Verde'),(152,NULL,'CAR'),(153,NULL,'Congo'),(154,NULL,'El-Salvador'),(155,NULL,'Liberia'),(156,NULL,'Madagascar'),(157,NULL,'Namibia'),(158,NULL,'St-Barth'),(159,NULL,'Zimbabwe'),(160,NULL,'Sudan'),(161,NULL,'Angola'),(162,NULL,'Benin'),(163,NULL,'Bermuda'),(164,NULL,'Bhutan'),(165,NULL,'Fiji'),(166,NULL,'Greenland'),(167,NULL,'Guinea'),(168,NULL,'Haiti'),(169,NULL,'Isle-of-Man'),(170,NULL,'Mauritania'),(171,NULL,'Nicaragua'),(172,NULL,'Saint-Lucia'),(173,NULL,'Zambia'),(174,NULL,'Nepal'),(175,NULL,'Antigua-and-Barbuda'),(176,NULL,'Chad'),(177,NULL,'Djibouti'),(178,NULL,'Eritrea'),(179,NULL,'Gambia'),(180,NULL,'Vatican-City'),(181,NULL,'Montserrat'),(182,NULL,'Niger'),(183,NULL,'Papua-New-Guinea'),(184,NULL,'St-Vincent-Grenadines'),(185,NULL,'Sint-Maarten'),(186,NULL,'Somalia'),(187,NULL,'Eswatini'),(188,NULL,'Timor-Leste'),(189,NULL,'Uganda'),(190,NULL,'All'),(191,NULL,'Mozambique'),(192,NULL,'Syria'),(193,NULL,'Grenada'),(194,NULL,'Dominica'),(195,NULL,'Turks-and-Caicos'),(196,NULL,'Belize'),(197,NULL,'Myanmar'),(198,NULL,'Laos'),(199,NULL,'Libya'),(200,NULL,'Mali'),(201,NULL,'Guinea-Bissau'),(202,NULL,'British-Virgin-Islands'),(203,NULL,'Saint-Kitts-and-Nevis'),(204,NULL,'Anguilla'),(205,NULL,'MS-Zaandam-'),(206,NULL,'MS-Zaandam'),(207,NULL,'Botswana'),(208,NULL,'Sierra-Leone'),(209,NULL,'Burundi'),(210,NULL,'Caribbean-Netherlands'),(211,NULL,'Malawi'),(212,NULL,'Falkland-Islands'),(213,NULL,'Western-Sahara'),(214,NULL,'South-Sudan'),(215,NULL,'Saint-Pierre-Miquelon'),(216,NULL,'Sao-Tome-and-Principe'),(217,NULL,'North-America'),(218,NULL,'Europe'),(219,NULL,'Asia'),(220,NULL,'South-America'),(221,NULL,'Oceania'),(222,NULL,'Africa'),(223,NULL,'Diamond-Princess'),(224,NULL,'Yemen'),(225,NULL,'Tajikistan'),(226,NULL,'Comoros');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 17:21:48
