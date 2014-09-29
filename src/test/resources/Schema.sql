DROP SCHEMA IF EXISTS javaTrainingDbUnit;

CREATE SCHEMA javaTrainingDbUnit;

USE javaTrainingDbUnit;

CREATE TABLE `Customer` (
  `customerId` int unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) not NULL,
  `lastname` varchar(50) not NULL,
  `telephone` varchar(11) not NULL,
  `email` varchar(50) not NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `AddressType` (
  `addressTypeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`addressTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Address` (
  `addressId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customerId` int(10) unsigned NOT NULL,
  `typeId` int(10) unsigned NOT NULL,
  `firstLine` varchar(200) NOT NULL,
  `secondLine` varchar(200) DEFAULT NULL,
  `thirdLine` varchar(200) DEFAULT NULL,
  `postcode` varchar(9) NOT NULL,
  PRIMARY KEY (`addressId`),
  KEY `customerId` (`customerId`),
  KEY `idxtypeId` (`typeId`),
  CONSTRAINT `address_fk_1` FOREIGN KEY (`typeId`) REFERENCES `AddressType` (`addressTypeId`),
  CONSTRAINT `address_fk_2` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Account` (
  `accountId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customerId` int(10) unsigned NOT NULL,
  `addressId` int(10) unsigned NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `createdDate` date NOT NULL,
  PRIMARY KEY (`accountId`),
  KEY `customerId` (`customerId`),
  KEY `addressCustomerId` (`addressId`,`customerId`),
  CONSTRAINT `account_fk_2` FOREIGN KEY (`customerId`, `addressId`) REFERENCES `Address` (`customerId`, `addressId`),
  CONSTRAINT `account_fk_1` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;