/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.29 : Database - manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `manager`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `perms` varchar(255) DEFAULT 'null',
  `perms_employee` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`,`perms`,`perms_employee`) values (1,'admin','123','',NULL);
insert  into `admin`(`id`,`username`,`password`,`perms`,`perms_employee`) values (2,'root','456',NULL,NULL);
insert  into `admin`(`id`,`username`,`password`,`perms`,`perms_employee`) values (3,'admin1','1234','null',NULL);
insert  into `admin`(`id`,`username`,`password`,`perms`,`perms_employee`) values (4,'admin2','2345','null',NULL);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id_department` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) NOT NULL,
  PRIMARY KEY (`id_department`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id_department`,`departmentName`) values (1,'纪检部');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `birth` date DEFAULT NULL,
  `id_card` varchar(11) NOT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `perms` varchar(255) DEFAULT 'user:update',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`age`,`gender`,`birth`,`id_card`,`department_name`,`perms`) values (1,'五六',123,0,'2020-03-13','456','学习部','user:update');
insert  into `employee`(`id`,`name`,`age`,`gender`,`birth`,`id_card`,`department_name`,`perms`) values (2,'吴七',88,0,'2019-11-05','567','宣传部','user:update');
insert  into `employee`(`id`,`name`,`age`,`gender`,`birth`,`id_card`,`department_name`,`perms`) values (3,'张三',12,1,'2020-05-07','213','体育部','user:update');
insert  into `employee`(`id`,`name`,`age`,`gender`,`birth`,`id_card`,`department_name`,`perms`) values (7,'王五',88,1,'2020-04-29','3212','学习部','user:update');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
