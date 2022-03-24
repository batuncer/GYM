DROP TABLE IF EXISTS `accounts`;
CREATE TABLE accounts( 
id long AUTO_INCREMENT, 
account_name VARCHAR(50) NOT NULL,
account_password VARCHAR(25) NOT NULL,
email VARCHAR(40) NOT NULL,
tel_number VARCHAR(30) NOT NULL,
address VARCHAR(100) NOT NULL,
price float NOT NULL,
isdelete boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `accounts` (`account_name`, `account_password`, `email`, `tel_number`,`address`,`price`,`isdelete`) VALUES ('test1', '1234','test1@mail.com', '44 7456 000000','test road t1 s23 london',25, false);
INSERT INTO `accounts` (`account_name`, `account_password`, `email`, `tel_number`,`address`,`price`,`isdelete`) VALUES ('test2', '1234e3','test3@mail.com', '43 7456 000001','test3 road t2 s23 london',25, false);

DROP TABLE IF EXISTS `users`;
CREATE TABLE users( 
id long AUTO_INCREMENT, 
full_name VARCHAR(50) NOT NULL,
height INT NOT NULL,
weight INT NOT NULL,
email VARCHAR(40) NOT NULL,
tel_number VARCHAR(30) NOT NULL,
isdelete boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `users` (`full_name`,`height`,`weight`,`email`,`tel_number`,`isdelete`) VALUES ('test',180,70,'baki@gmail.com','08111111',false);
INSERT INTO `users` (`full_name`,`height`,`weight`,`email`,`tel_number`,`isdelete`) VALUES ('jack',190,80,'jack@gmail.com','07234243',false);

DROP TABLE IF EXISTS `gym_member_ship`;
CREATE TABLE gym_member_ship( 
id long AUTO_INCREMENT, 
user_id long not null,
account_id long NOT NULL,
price float NOT NULL,
m_type int NOT NULL,
start_date DATETIME not null,
period_date int not null,
create_date DATETIME not null,
isdelete boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `gym_member_ship` (`user_id`,`account_id`,`price`,`m_type`,`start_date`,`period_date`,`create_date`,`isdelete`) VALUES (1,1,25,1,'2022-03-24 21:00',30,'2022-03-24 21:00',false);
INSERT INTO `gym_member_ship` (`user_id`,`account_id`,`price`,`m_type`,`start_date`,`period_date`,`create_date`,`isdelete`) VALUES (2,2,25,1,'2022-03-24 21:00',30,'2022-03-24 21:00',false);
