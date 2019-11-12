CREATE DATABASE  IF NOT EXISTS `SdaScheduler` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `SdaScheduler`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: SdaScheduler
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `Attendents`
--

DROP TABLE IF EXISTS `Attendents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Attendents` (
  `idAttendents` int(11) NOT NULL AUTO_INCREMENT,
  `isPresent` int(11) DEFAULT NULL,
  `comments` char(128) DEFAULT NULL,
  `idModule` int(11) DEFAULT NULL,
  `idStudent` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAttendents`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attendents`
--

LOCK TABLES `Attendents` WRITE;
/*!40000 ALTER TABLE `Attendents` DISABLE KEYS */;
INSERT INTO `Attendents` VALUES (1,1,'prezent',1,7),(2,1,'prezent',1,8),(3,1,'present',1,9),(4,0,'absent',2,7),(5,1,'prezent',2,8),(6,1,'prezent',2,9),(7,1,'prezent',3,7),(8,0,'absent',3,8),(9,0,'absent',3,9),(10,1,'present',4,10),(11,0,'absent',4,11),(12,1,'present',4,12),(13,0,'absent',4,13),(14,0,'absent',5,10),(15,1,'present',5,11),(16,1,'present',5,12),(17,1,'present',5,13),(18,0,'absent',6,14),(19,1,'present',6,15),(20,1,'present',6,16),(21,0,'absent',6,17),(22,1,'present',7,14),(23,1,'present',7,15),(24,1,'absent',7,16),(25,1,'present',7,17);
/*!40000 ALTER TABLE `Attendents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Classroom`
--

DROP TABLE IF EXISTS `Classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Classroom` (
  `idClassroom` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`idClassroom`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Classroom`
--

LOCK TABLES `Classroom` WRITE;
/*!40000 ALTER TABLE `Classroom` DISABLE KEYS */;
INSERT INTO `Classroom` VALUES (1,'Scoala Auto Zac','Oradea,Strada Iancu de Hunedoara'),(2,'City Business Center','Oradea,Strada Coza Voda'),(3,'Intesa','Cluj, Strada Mos Ion'),(4,'Inspectorat','Cluj, centru');
/*!40000 ALTER TABLE `Classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `idCourse` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` char(60) DEFAULT NULL,
  PRIMARY KEY (`idCourse`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (1,'Java ','java basics'),(2,'HIbernate','hibernate and jdbc'),(3,'Sql','sql basics'),(4,'Angular','web pages'),(5,'Spring','spring basics');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Module`
--

DROP TABLE IF EXISTS `Module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Module` (
  `idModule` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `idTeam` int(11) DEFAULT NULL,
  `idTrainer` int(11) DEFAULT NULL,
  `idCourse` int(11) DEFAULT NULL,
  `idClassroom` int(11) DEFAULT NULL,
  PRIMARY KEY (`idModule`),
  KEY `fk_idTeam_idx` (`idTeam`),
  KEY `fk_idTrainer_idx` (`idTrainer`),
  KEY `fk_idCourse_idx` (`idCourse`),
  KEY `fk_idClassrooms_idx` (`idClassroom`),
  CONSTRAINT `fk_idClassrooms` FOREIGN KEY (`idClassroom`) REFERENCES `classroom` (`idClassroom`),
  CONSTRAINT `fk_idCourse` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`),
  CONSTRAINT `fk_idTeam` FOREIGN KEY (`idTeam`) REFERENCES `team` (`idTeam`),
  CONSTRAINT `fk_idTrainer` FOREIGN KEY (`idTrainer`) REFERENCES `person` (`idPerson`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Module`
--

LOCK TABLES `Module` WRITE;
/*!40000 ALTER TABLE `Module` DISABLE KEYS */;
INSERT INTO `Module` VALUES (1,'2019-03-15','2019-07-15',1,1,1,4),(2,'2019-07-20','2019-09-18',1,3,2,4),(3,'2019-09-20','2019-12-12',1,5,3,4),(4,'2019-03-21','2019-05-20',2,2,1,2),(5,'2019-06-01','2019-08-23',2,4,3,2),(6,'2019-01-01','2019-04-09',3,6,1,3),(7,'2019-03-09','2019-06-09',3,18,2,3);
/*!40000 ALTER TABLE `Module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Person` (
  `idPerson` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` char(60) DEFAULT NULL,
  `isTrainer` tinyint(4) DEFAULT NULL,
  `idTeam` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPerson`),
  KEY `fk_idTeam_idx` (`idTeam`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'John','Basket','jbasket@go.ro',1,1),(2,'Mark','Maxx','mmax@go.ro',1,2),(3,'Peter','Sagan','psagan@go.ro',1,1),(4,'Ellia','Viviani','evivi@go.ro',1,2),(5,'Mark','Cavendish','mcaven@go.ro',1,1),(6,'Edi','Grosu','egrosu@go.ro',1,3),(7,'Nairo','Quintana','nquintana@go.ro',0,1),(8,'Peter','Stetina','psteti@go.ro',0,1),(9,'Sam','Bennet','sbenet@go.ro',0,1),(10,'Van','Aert','vaert@go.ro',0,2),(11,'Alberto','Contador','aconta@go.ro',0,2),(12,'Richard','Carapas','rcarapas@go.ro',0,2),(13,'Vincenzo','Nibali','vnibali@go.ro',0,2),(14,'Chriss','Froome','cfroome@go.ro',0,3),(15,'Egan','Bernal','ebernal@go.ro',0,3),(16,'Student_1','Student','s1@go.ro',0,3),(17,'Student_2','Student','s2@go.ro',0,3),(18,'Teacher_2','Teacher','t2@go.ro',1,3);
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Team`
--

DROP TABLE IF EXISTS `Team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Team` (
  `idTeam` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `maxStudents` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTeam`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Team`
--

LOCK TABLES `Team` WRITE;
/*!40000 ALTER TABLE `Team` DISABLE KEYS */;
INSERT INTO `Team` VALUES (1,'team 1 cluj',30),(2,'team 1 oradea',25),(3,'team 2 cluj',13);
/*!40000 ALTER TABLE `Team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-11 21:33:47
