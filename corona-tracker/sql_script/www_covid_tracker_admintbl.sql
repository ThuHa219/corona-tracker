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
-- Table structure for table `admintbl`
--

DROP TABLE IF EXISTS `admintbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admintbl` (
  `username` varchar(100) NOT NULL,
  `password` longtext,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admintbl`
--

LOCK TABLES `admintbl` WRITE;
/*!40000 ALTER TABLE `admintbl` DISABLE KEYS */;
INSERT INTO `admintbl` VALUES ('chien','$31$16$SSjvGGmTmskJZn-2FTM4YcSgnjY-6DM8XuKjLW_OGzs'),('ha','$31$16$BJhRKmyHKPIbIm6KFqrjJzt9ptOqiDmeXDm2Cm9ZonA'),('hien','$31$16$2l5DnYxUDT3y5lD5vkDarVGt9gYSIGapulfsaGHVmZI'),('linh','$31$16$UmjR-XI9IPFHRh55yOsJMai9KlpRWCMlJTv299Tn1zA'),('tram','$31$16$pwuXkB3PA95g8HKmgl-bzoo1gjmvrWACRR9NeOS3O9I'),('tramm','$31$16$KQbgsRNw0HEEeD0uU8XRWF386gcLSZy5j3dC-AuXUfc');
/*!40000 ALTER TABLE `admintbl` ENABLE KEYS */;
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
