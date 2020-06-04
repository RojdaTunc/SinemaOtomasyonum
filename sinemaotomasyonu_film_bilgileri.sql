-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sinemaotomasyonu
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `film_bilgileri`
--

DROP TABLE IF EXISTS `film_bilgileri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film_bilgileri` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `film_adi` varchar(45) DEFAULT NULL,
  `yonetmen` varchar(45) DEFAULT NULL,
  `film_turu` varchar(45) DEFAULT NULL,
  `salon` varchar(45) DEFAULT NULL,
  `seans` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_bilgileri`
--

LOCK TABLES `film_bilgileri` WRITE;
/*!40000 ALTER TABLE `film_bilgileri` DISABLE KEYS */;
INSERT INTO `film_bilgileri` VALUES (14,'Pardon','Mert BAYKAL','YERLİ','1','21:00'),(15,'Vizontele','Yılmaz ERDOĞAN','YERLİ','2','21:00'),(16,'G.O.R.A.','Ömer Faruk SORAK','YERLİ','2','18:00'),(17,'Esaretin Bedeli','Frank DARABONT','AKSİYON','3','15:00'),(19,'Kara Şövalye','Christopher NOLAN','AKSİYON','3','20:00'),(20,'Suicide Squad','David AYER','FANTASTİK','1','18:30'),(21,'Fokus','Glenn Ficarra','KOMEDİ','1','12:30'),(22,'Testere','James WAN','KORKU','4','13:00'),(23,'Testere','James WAN','KORKU','4','13:00'),(24,'Halka','Gore VERBİNSKİ','KORKU','4','16:00'),(25,'Cinnet','Stanley KUBRİCK','GERİLİM','3','10:00'),(26,'Selvi Boylum Al Yazmalım','Atıf YILMAZ','YERLİ','2','23:00');
/*!40000 ALTER TABLE `film_bilgileri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 21:15:24
