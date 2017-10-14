CREATE DATABASE `neways_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

use neways_db;

CREATE TABLE `user_roles` (
  `ROLE_ID` varchar(50) NOT NULL,
  `USERNAME` varchar(36) NOT NULL,
  `USER_ROLE` varchar(30) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `USER_ROLE_UK` (`USERNAME`,`USER_ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `USERNAME` varchar(36) NOT NULL,
  `PASSWORD` varchar(36) NOT NULL,
  `ENABLED` smallint(6) NOT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO user_roles VALUES('2', 'dbadmin1','ADMIN');
INSERT INTO user_roles VALUES('3', 'dbadmin1', 'USER');
INSERT INTO user_roles VALUES('1', 'dbuser1', 'USER');

INSERT INTO users VALUES('dbadmin1', '12345', '1');
INSERT INTO users VALUES('dbuser1', '12345', '1');