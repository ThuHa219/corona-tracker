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
-- Table structure for table `patient_info`
--

DROP TABLE IF EXISTS `patient_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient_info` (
  `time_update` varchar(255) DEFAULT NULL,
  `patient_id` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `patient_status` varchar(255) DEFAULT NULL,
  `patient_decription` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_info`
--

LOCK TABLES `patient_info` WRITE;
/*!40000 ALTER TABLE `patient_info` DISABLE KEYS */;
INSERT INTO `patient_info` VALUES ('2020-04-13 19:17:44','BN01',66,'Male','Chinese','TP HCM','Recovered','Li Ding and his wife from Wuhan City (Hubei Province, China) arrived in Hanoi on January 13, then moved to Nha Trang (January 16). Li Zichao worked in Long An province, went to Nha Trang to meet with his father, then from Nha Trang to Ho Chi Minh City and then returned to Long An. On January 17, Dad started to have a fever and on January 20, he had similar symptoms. Father and son were taken to Cho Ray Hospital in the evening of January 22.'),('2020-04-13 19:18:21','BN02',28,'Male','Chinese','TP HCM','Recovered','Son of BN01'),('2020-04-13 19:19:40','BN03',25,'Female','Vietnamese','Thanh Hoa','Recovered','was dispatched to China by Nihon Plast Co., Ltd. (hereinafter referred to as Nihon Plast Co., Ltd.) to China in Wuhan from November and returned to Vietnam on January 17 on Southern China Flight CZ8315, via the airport. Noi Bai (Hanoi).'),('2020-04-13 19:20:34','BN04',29,'Male','Vietnamese','Vinh Phuc','Recovered','Working together and flight with BN03'),('2020-04-13 19:21:24','BN05',23,'Female','Vietnamese','Vinh Phuc','Recovered','It later became Covid-19 infectious to many people in contact with him, including: father, mother, sister, and 2 neighbors who had close contact with this patient.'),('2020-04-28 13:39:29','BN06',25,'Female','Vietnamese','Khanh Hoa','Recovered','This patient is infected by close contact with 2 Chinese father and son (in case of patient No. 1, No. 2)'),('2020-04-28 13:41:13','BN07',73,'Male','American','Ha Noi','Recovered','He was infected with Covid-19 due to a 2-hour transit at Wuhan Tianhe International Airport during a trip from the United States to Vietnam.'),('2020-04-28 13:41:58','BN08',29,'Female','Vietnamese','Vinh Phuc','Recovered','This person was in the same group of the Nihon Plast Company of Japan to Wuhan.'),('2020-04-28 13:42:52','BN09',30,'Male','Vietnamese','Vinh Phuc','Recovered','He also belonging to the training group of Nihon Plast Company of Japan, returning from Wuhan to confirm positive for SARS-CoV-2 virus.'),('2020-04-28 13:44:54','BN10',42,'Female','Vietnamese','Vinh Phuc','Recovered','infected by contact with a fifth patient during the Chinese New Year holiday.'),('2020-04-28 14:01:04','BN11',49,'Female','Vietnamese','Vinh Phuc','Recovered','Mother of BN05'),('2020-04-28 14:01:55','BN12',16,'Female','Vietnamese','Vinh Phuc','Recovered','Younger sister of BN05.'),('2020-04-28 14:03:11','BN13',29,'Female','Vietnamese','Vinh Phuc','Recovered','belongs to the group of workers of Nihon Plast Company'),('2020-04-28 14:04:09','BN14',55,'Female','Vietnamese','Vinh Phuc','Recovered','neighbor of the BN05'),('2020-04-28 14:05:21','BN15',1,'Male','Vietnamese','Vinh Phuc','Confirmed',' Nephew of BN10 who visits his daughter.'),('2020-04-28 14:06:16','BN16',50,'Male','Vietnamese','Vinh Phuc','Recovered','Father of BN05.'),('2020-04-28 14:08:32','BN17',26,'Female','Vietnamese','Ha Noi','Recovered','On February 15, patients departing from Noi Bai airport to visit family members living in London (UK), entering London on February 16. On 18.2, the patient traveled from London to Milan, in the province of Lombardy (Italy) to travel (at this time, the province of Lombardy had not recorded the outbreak of Covid-19).\r\nBy 20.2, the patient would return to London. On 25.2, the patient traveled from London to Paris (France) for a day tour, where the patient met his sister (the information of the sister of an infected patient with Covid-19 is available). On February 26, the patient returned to London.\r\nOn 29.2, the patient manifested cough but did not go to the doctor. By day 1.3, the patient appeared to be more tired, with no fever. On day 1.3, the patient took a flight with flight number VN 0054 of Vietnam Airlines to return home.'),('2020-04-28 14:10:26','BN18',27,'Male','Vietnamese','Ninh Binh','Recovered','He flied to Daegu, South Korea on February 1, returning to Vietnam by plane from Busan to Van Don on April 4.3.\r\nAfter entering Vietnam, this patient was concentratedly isolated, sampled and tested positive for SARS-CoV-2. Passengers on the flight are taken to the concentrated isolation area of ââthe Military School, the 1st Army Corps of 19 Tan Binh Ward, Tam Diep City, Ninh Binh Province.'),('2020-04-28 14:12:11','BN19',64,'Female','Vietnamese','Ha Noi','Confirmed','She had close contact with BN17 in Hanoi.');
/*!40000 ALTER TABLE `patient_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 17:21:46
