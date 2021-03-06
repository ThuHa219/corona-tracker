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
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,0),(2,2108837),(3,1528833),(4,6931132),(5,2547052),(6,484541),(7,1100228),(8,630973),(9,276000),(10,1129907),(11,225899),(12,269619),(13,260996),(14,172586),(15,119500),(16,832222),(17,221912),(18,426836),(19,184213),(20,339552),(21,611583),(22,181527),(23,253826),(24,1111366),(25,390022),(26,169377),(27,0),(28,47460),(29,203025),(30,199400),(31,366013),(32,73929),(33,78207),(34,101800),(35,101728),(36,50002),(37,107943),(38,143919),(39,178083),(40,339775),(41,55020),(42,190540),(43,1046450),(44,355604),(45,139354),(46,115012),(47,3945518),(48,54464),(49,90000),(50,154989),(51,230686),(52,37880),(53,98253),(54,37557),(55,91188),(56,31895),(57,114602),(58,94770),(59,179000),(60,96637),(61,47636),(62,2397),(63,23142),(64,63866),(65,63713),(66,1200000),(67,6500),(68,63102),(69,13632),(70,30102),(71,21164),(72,79551),(73,82092),(74,138270),(75,39367),(76,261004),(77,32783),(78,8021),(79,1673),(80,16997),(81,62267),(82,13924),(83,11763),(84,23525),(85,8669),(86,195430),(87,35117),(88,477790),(89,0),(90,24055),(91,0),(92,466),(93,282862),(94,152597),(95,12304),(96,32200),(97,150223),(98,40459),(99,15904),(100,1907),(101,122752),(102,0),(103,242536),(104,0),(105,0),(106,900),(107,5342),(108,76066),(109,11068),(110,4669),(111,0),(112,16588),(113,51506),(114,113497),(115,0),(116,5215),(117,5791),(118,579),(119,10766),(120,0),(121,0),(122,0),(123,7200),(124,33303),(125,6864),(126,7100),(127,2634),(128,0),(129,16028),(130,2369),(131,10508),(132,51472),(133,8008),(134,3000),(135,2711),(136,8250),(137,20770),(138,21702),(139,0),(140,854),(141,0),(142,0),(143,724),(144,1731),(145,0),(146,404),(147,1353),(148,4947),(149,1927),(150,351),(151,791),(152,0),(153,0),(154,26961),(155,0),(156,3393),(157,704),(158,0),(159,7642),(160,0),(161,481),(162,0),(163,2819),(164,10761),(165,1007),(166,1271),(167,0),(168,848),(169,3242),(170,1032),(171,0),(172,446),(173,5284),(174,61627),(175,151),(176,0),(177,13856),(178,0),(179,401),(180,0),(181,36),(182,5271),(183,604),(184,108),(185,329),(186,0),(187,714),(188,322),(189,36302),(190,0),(191,2337),(192,0),(193,1406),(194,383),(195,83),(196,1043),(197,8460),(198,2165),(199,2155),(200,2172),(201,1500),(202,0),(203,294),(204,0),(205,0),(206,0),(207,7675),(208,0),(209,284),(210,110),(211,831),(212,388),(213,0),(214,1247),(215,0),(216,19),(217,0),(218,0),(219,0),(220,0),(221,0),(222,0),(223,0),(224,120),(225,0),(226,0);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 17:21:47
