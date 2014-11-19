-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.19 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for database
CREATE DATABASE IF NOT EXISTS `database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `database`;


-- Dumping structure for table database.clientthing_to_schema
CREATE TABLE IF NOT EXISTS `clientthing_to_schema` (
  `ID_CLIENTTHING` int(11) NOT NULL,
  `ID_SCHEMA` int(11) NOT NULL,
  PRIMARY KEY (`ID_CLIENTTHING`,`ID_SCHEMA`),
  KEY `FK_schema_to_client_thing` (`ID_SCHEMA`),
  CONSTRAINT `FK__clientthings_to_shema` FOREIGN KEY (`ID_CLIENTTHING`) REFERENCES `clientthings` (`ID_THING_OF_CLIENT`),
  CONSTRAINT `FK__schemas` FOREIGN KEY (`ID_SCHEMA`) REFERENCES `schemas_of_users` (`ID_SCHEMA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.combo_properties
CREATE TABLE IF NOT EXISTS `combo_properties` (
  `ID_COMBO_PROPERTIES` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_PROPERTIES` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_COMBO_PROPERTIES`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.combo_properties_to_thing
CREATE TABLE IF NOT EXISTS `combo_properties_to_thing` (
  `ID_COMBO_PROPERTIES` int(11) NOT NULL,
  `ID_THING` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMBO_PROPERTIES`,`ID_THING`),
  KEY `FK_THING_TO_COMBO_PROPERTIES` (`ID_THING`),
  KEY `ID_COMBO_PROPERTIES` (`ID_COMBO_PROPERTIES`),
  CONSTRAINT `FK_COMBO_PROPERTIES_TO_THING` FOREIGN KEY (`ID_COMBO_PROPERTIES`) REFERENCES `combo_properties` (`ID_COMBO_PROPERTIES`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_THING_TO_COMBO_PROPERTIES` FOREIGN KEY (`ID_THING`) REFERENCES `things` (`ID_THING`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.rait
CREATE TABLE IF NOT EXISTS `rait` (
  `ID_USER` int(11) NOT NULL,
  `ID_SCHEMA` int(11) NOT NULL,
  `RAIT` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_USER`,`ID_SCHEMA`),
  KEY `FK__user_to_rait` (`ID_USER`),
  KEY `FK__shema` (`ID_SCHEMA`),
  CONSTRAINT `FK_SCHEMA_TO_USER` FOREIGN KEY (`ID_SCHEMA`) REFERENCES `schemas_of_users` (`ID_SCHEMA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_TO_SCHEMA` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID_USER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.schemas_of_users
CREATE TABLE IF NOT EXISTS `schemas_of_users` (
  `ID_SCHEMA` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_SCHEMA` varchar(50) NOT NULL DEFAULT 'schema',
  `PARAM_SCHEMA` varchar(200) NOT NULL,
  `SUM_RAITING` int(11) NOT NULL DEFAULT '0',
  `COUNT_USERS` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_SCHEMA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.things
CREATE TABLE IF NOT EXISTS `things` (
  `ID_THING` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_THING` varchar(50) NOT NULL DEFAULT 'element',
  `IMAGE_REF` varchar(100) NOT NULL,
  `LIST_PROPERTIES` varchar(150) NOT NULL,
  PRIMARY KEY (`ID_THING`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.things_of_client
CREATE TABLE IF NOT EXISTS `things_of_client` (
  `ID_THING_OF_CLIENT` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_VALUE` varchar(200) DEFAULT NULL,
  `ROTATION` int(11) DEFAULT NULL,
  `COORDINATES` varchar(50) DEFAULT '0;0',
  PRIMARY KEY (`ID_THING_OF_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.thing_to_thing_of_client
CREATE TABLE IF NOT EXISTS `thing_to_thing_of_client` (
  `ID_THING_OF_CLIENT` int(11) NOT NULL,
  `ID_THING` int(11) NOT NULL,
  PRIMARY KEY (`ID_THING_OF_CLIENT`,`ID_THING`),
  KEY `FK__clientthing_to_thing` (`ID_THING_OF_CLIENT`),
  KEY `FK__thing_to_client_thing` (`ID_THING`),
  CONSTRAINT `FK_THING_OF_CLIENT_TO_THING` FOREIGN KEY (`ID_THING_OF_CLIENT`) REFERENCES `things_of_client` (`ID_THING_OF_CLIENT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_THING_TO_THING_OF_CLIENT` FOREIGN KEY (`ID_THING`) REFERENCES `things` (`ID_THING`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.users
CREATE TABLE IF NOT EXISTS `users` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_USER` varchar(50) NOT NULL DEFAULT 'user',
  `DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `PASSWORD` varchar(200) NOT NULL DEFAULT 'password',
  `EMAIL` varchar(100) NOT NULL,
  `ENABLED` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `ID_USER_ROLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USER` int(11) NOT NULL,
  `ROLE` varchar(50) NOT NULL DEFAULT 'ROLE_ANONIMYS',
  PRIMARY KEY (`ID_USER_ROLE`),
  UNIQUE KEY `ID_USER` (`ID_USER`),
  KEY `fk_role_to_user` (`ID_USER`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.user_to_thing
CREATE TABLE IF NOT EXISTS `user_to_thing` (
  `ID_USER` int(11) NOT NULL,
  `ID_THING` int(11) NOT NULL,
  PRIMARY KEY (`ID_USER`,`ID_THING`),
  KEY `FK__user_to_thing` (`ID_USER`),
  KEY `FK__thing_to_user` (`ID_THING`),
  CONSTRAINT `FK_THING_TO_USER` FOREIGN KEY (`ID_THING`) REFERENCES `things` (`ID_THING`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_TO_THING` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID_USER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table database.user_to_thing_of_client
CREATE TABLE IF NOT EXISTS `user_to_thing_of_client` (
  `ID_USER` int(11) NOT NULL,
  `ID_THING_OF_CLIENT` int(11) NOT NULL,
  PRIMARY KEY (`ID_USER`,`ID_THING_OF_CLIENT`),
  KEY `FK__user_to_client_thing` (`ID_USER`),
  KEY `FK__clientthing_to_user` (`ID_THING_OF_CLIENT`),
  CONSTRAINT `FK_THING_OF_CLIENT_TO_USER` FOREIGN KEY (`ID_THING_OF_CLIENT`) REFERENCES `things_of_client` (`ID_THING_OF_CLIENT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_TO_THING_OF_CLIENT` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID_USER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
