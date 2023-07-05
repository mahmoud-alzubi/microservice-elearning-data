USE `elearning`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('mahmoud','{bcrypt}$2a$10$9lt2HW.l/pKLaH4pncNDF.FgnqOxX/CFcIl5HXGcnf0wDxXJ5pegy',1),
('mohammad','{bcrypt}$2a$10$EN5n7ox9WkZUUgfRWqyXrO18ExNhPdHS37B9/nU.dyBPPa05RxoLG',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('mohammad','ROLE_STUDENT'),
('mahmoud','ROLE_EMPLOYEE'),
('mahmoud','ROLE_MANAGER'),
('mahmoud','ROLE_ADMIN');

