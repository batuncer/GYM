DROP TABLE IF EXISTS `accounts`;
CREATE TABLE accounts( 
id long AUTO_INCREMENT, 
accountName VARCHAR(50) NOT NULL,
accountPassword VARCHAR(25) NOT NULL,
email VARCHAR(40) NOT NULL,
telNumber VARCHAR(30) NOT NULL,
isdelete boolean NOT NULL,
PRIMARY KEY (id)
);
INSERT INTO `accounts` (`accountName`, `accountPassword`, `email`, `telNumber`,`isdelete` ) VALUES ('baki', '12345', 'baki@gmail.com','1234567' ,false);
