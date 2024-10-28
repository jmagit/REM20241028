/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `petclinic` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `petclinic`;

CREATE TABLE IF NOT EXISTS `owners` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `owners` (`id`, `first_name`, `last_name`, `address`, `city`, `telephone`) VALUES
	(1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023'),
	(2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749'),
	(3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763'),
	(4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198'),
	(5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765'),
	(6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654'),
	(7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387'),
	(8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683'),
	(9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435'),
	(10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

CREATE TABLE IF NOT EXISTS `pets` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `type_id` int unsigned NOT NULL,
  `owner_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `owner_id` (`owner_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `pets_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `owners` (`id`),
  CONSTRAINT `pets_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `pets` (`id`, `name`, `birth_date`, `type_id`, `owner_id`) VALUES
	(1, 'Leo', '2000-09-07', 1, 1),
	(2, 'Basil', '2002-08-06', 6, 2),
	(3, 'Rosy', '2001-04-17', 2, 3),
	(4, 'Jewel', '2000-03-07', 2, 3),
	(5, 'Iggy', '2000-11-30', 3, 4),
	(6, 'George', '2000-01-20', 4, 5),
	(7, 'Samantha', '1995-09-04', 1, 6),
	(8, 'Max', '1995-09-04', 1, 6),
	(9, 'Lucky', '1999-08-06', 5, 7),
	(10, 'Mulligan', '1997-02-24', 2, 8),
	(11, 'Freddy', '2000-03-09', 5, 9),
	(12, 'Lucky', '2000-06-24', 2, 10),
	(13, 'Sly', '2002-06-08', 1, 10);

CREATE TABLE IF NOT EXISTS `specialties` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `specialties` (`id`, `name`) VALUES
	(3, 'dentistry'),
	(1, 'radiology'),
	(2, 'surgery');

CREATE TABLE IF NOT EXISTS `types` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `types` (`id`, `name`) VALUES
	(5, 'bird'),
	(1, 'cat'),
	(2, 'dog'),
	(6, 'hamster'),
	(3, 'lizard'),
	(4, 'snake');

CREATE TABLE IF NOT EXISTS `vets` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `vets` (`id`, `first_name`, `last_name`) VALUES
	(1, 'James', 'Carter'),
	(2, 'Helen', 'Leary'),
	(3, 'Linda', 'Douglas'),
	(4, 'Rafael', 'Ortega'),
	(5, 'Henry', 'Stevens'),
	(6, 'Sharon', 'Jenkins');

CREATE TABLE IF NOT EXISTS `vet_specialties` (
  `vet_id` int unsigned NOT NULL,
  `specialty_id` int unsigned NOT NULL,
  UNIQUE KEY `vet_id` (`vet_id`,`specialty_id`),
  KEY `specialty_id` (`specialty_id`),
  CONSTRAINT `vet_specialties_ibfk_1` FOREIGN KEY (`vet_id`) REFERENCES `vets` (`id`),
  CONSTRAINT `vet_specialties_ibfk_2` FOREIGN KEY (`specialty_id`) REFERENCES `specialties` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `vet_specialties` (`vet_id`, `specialty_id`) VALUES
	(2, 1),
	(5, 1),
	(3, 2),
	(4, 2),
	(3, 3);

CREATE TABLE IF NOT EXISTS `visits` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `pet_id` int unsigned DEFAULT NULL,
  `visit_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pet_id` (`pet_id`),
  CONSTRAINT `visits_ibfk_1` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

INSERT IGNORE INTO `visits` (`id`, `pet_id`, `visit_date`, `description`) VALUES
	(1, 7, '2010-03-04', 'rabies shot'),
	(2, 8, '2011-03-04', 'rabies shot'),
	(3, 8, '2009-06-04', 'neutered'),
	(4, 7, '2008-09-04', 'spayed');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
