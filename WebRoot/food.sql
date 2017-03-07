/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.30 : Database - homework
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`homework` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `homework`;

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `commentid` int(20) NOT NULL AUTO_INCREMENT,
  `food` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  `comment` varchar(100) NOT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FKF437E194972E5A4` (`food`),
  KEY `FKF437E194BFD518A4` (`customer`),
  CONSTRAINT `FKF437E194972E5A4` FOREIGN KEY (`food`) REFERENCES `t_food` (`foodid`),
  CONSTRAINT `FKF437E194BFD518A4` FOREIGN KEY (`customer`) REFERENCES `t_customer` (`customerid`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`food`) REFERENCES `t_food` (`foodid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`customer`) REFERENCES `t_customer` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`commentid`,`food`,`customer`,`comment`) values (2,3,2,'香嫩可口，入口即化。'),(3,3,2,'鲜嫩多汁。'),(4,3,2,'美味香滑');

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `customerid` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `role` int(20) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`customerid`,`name`,`password`,`role`) values (1,'admin','123',0),(2,'hq','123',1),(3,'zhz','123',2);

/*Table structure for table `t_food` */

DROP TABLE IF EXISTS `t_food`;

CREATE TABLE `t_food` (
  `foodid` int(20) NOT NULL AUTO_INCREMENT,
  `foodname` varchar(20) NOT NULL,
  `price` int(20) NOT NULL,
  `filepath` varchar(80) NOT NULL,
  `vipprice` int(20) NOT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_food` */

insert  into `t_food`(`foodid`,`foodname`,`price`,`filepath`,`vipprice`) values (3,'鸡腿',30,'upload/8bfd62fa-76e9-40f3-8521-872433b265c5.jpg',25),(4,'寿司',20,'upload/shousi.jpg',18),(5,'沙拉',30,'upload/salad.jpg',25),(6,'羊排',100,'upload/beef.jpg',95),(7,'螃蟹',80,'upload/seafood.jpg',75);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `orderid` int(20) NOT NULL AUTO_INCREMENT,
  `food` int(20) NOT NULL,
  `customer` int(20) NOT NULL,
  `foodnum` int(2) NOT NULL,
  `total` int(20) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FKA0C0C3C3972E5A4` (`food`),
  KEY `FKA0C0C3C3BFD518A4` (`customer`),
  CONSTRAINT `FKA0C0C3C3972E5A4` FOREIGN KEY (`food`) REFERENCES `t_food` (`foodid`),
  CONSTRAINT `FKA0C0C3C3BFD518A4` FOREIGN KEY (`customer`) REFERENCES `t_customer` (`customerid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`food`) REFERENCES `t_food` (`foodid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`customer`) REFERENCES `t_customer` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`orderid`,`food`,`customer`,`foodnum`,`total`) values (1,3,2,1,45),(2,3,2,1,45),(3,3,2,1,45),(4,3,2,1,45),(5,3,2,1,45),(6,3,2,1,45),(7,4,2,1,18),(8,4,2,1,18),(9,3,2,1,45);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
