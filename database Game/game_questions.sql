-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: game
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(70) DEFAULT NULL,
  `correctAnswer` varchar(70) DEFAULT NULL,
  `wrongAnswer1` varchar(70) DEFAULT NULL,
  `wrongAnswer2` varchar(70) DEFAULT NULL,
  `wrongAnswer3` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (121,'Entomology is the science that studies','Insects','Behavior of human beings','The origin and history of technical and scientific terms','The formation of rocks'),(122,'Eritrea is in the continent of','Africa','Asia','Europe','Australia'),(123,'For which of the following disciplines is Nobel Prize awarded?','All of the above','Physics and Chemistry','Physiology or Medicine','Literature, Peace and Economics'),(124,'Galileo was an Italian astronomer who','All of the above','developed the telescope','discovered four satellites of Jupiter','made the first working thermometer'),(125,'Exposure to sunlight helps a person improve his health because','the ultraviolet rays convert skin oil into Vitamin D','the infrared light kills bacteria in the body','resistance power increases','the pigment cells in the skin get stimulated and produce a healthy tan'),(126,'Fire temple is the place of worship of which religion?','Zoroastrianism (Parsi Religion)','Taoism','Judaism','Shintoism'),(127,'During World War II, when did Germany attack France?','1940','1941','1942','1943'),(128,'The ozone layer restricts','Ultraviolet radiation','Visible light','Infrared radiation','X-rays and gamma rays'),(129,'Euclid was','Greek mathematician','Mythological creature','Politician','Imperator'),(130,'Ecology deals with','Relation between organisms and their environment','Birds','Cell formation','Tissue'),(131,'We can see object on the surface from the submarine with','periscope','kaleidoscope','spectroscope','telescope'),(132,'Fathometer is used to measure','Ocean depth','Earthquakes','Rainfall','Sound intensity'),(133,'For galvanizing iron which of the following metals is used?','Zinc','Aluminium','Copper','Lead'),(134,'For purifying drinking water alum is used','for coagulation of mud particles','to kill bacteria','to remove salts','to remove gases'),(135,'Firdausi was','a poet','inventor','painter','None of the above'),(136,'What is the house number of the Simpsons?','Number 742','Number 427','Number 473','Number 724'),(137,'Which Italian artist painted the Birth of Venus?','Botticelli','Leonardo Da Vinci','Tizian','Giorgio Vasari'),(138,'What is the second largest country in Europe after Russia?','France','Germany','Sweden','Spain'),(139,'How long is the Great Wall of China?','4000 miles','5000 miles','3000 miles','7000 miles'),(140,'The total number of blood cells in normal human body is','30 trillion','20 trillion','25 trillion','15 trilion'),(141,'In which season do we need more fat?','Winter','Summer','Spring','Rainy season'),(142,'If speed of rotation of the earth increases, weight of the body','Decreases','Increases','Remains unchanged','May decrease or increase'),(143,'How many players are there on each side in the game of Basketball?','5','4','6','7'),(144,'The last Winter Olympics Games held was held in?','Sochi,Russia','Albertville','Lillehammer','Salt Lake City(USA)'),(145,'Hybridization is','cross-fertillization between two varietes','downward movement of water through soil','decayed vegetable matter','a process of tilling the land'),(146,'Hygrometer is used to measure','relative humidity','purity of milk','specific gravity of liquid','None of the above'),(147,'Joule is the unit of','energy','temperature','pressure','heat'),(148,'Kemal Ataturk was','the founder of modern Turkey','revolutionary leader of Soviet Union','the first President of Independent Kenya','None of the above'),(149,'Of the following,which one is the best source of protein?','Fish','Butter','Lettuce','Milk');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-25 17:11:48
