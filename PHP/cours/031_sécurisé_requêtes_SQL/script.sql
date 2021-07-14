DROP DATABASE IF EXISTS `fv_database`;
CREATE DATABASE IF NOT EXISTS `fv_database`;
USE `fv_database`;

CREATE TABLE IF NOT EXISTS `fv_clients`
(
	`id_client` INT NOT NULL AUTO_INCREMENT,
	`client_firstname` VARCHAR(65) NOT NULL,
	`client_lastname` VARCHAR(65) NOT NULL,
	`client_birthday` DATE NOT NULL,
	`client_loyalty` INT NOT NULL,
	
	PRIMARY KEY(`id_client`)
);

INSERT INTO `fv_clients`(`client_firstname`, `client_lastname`, `client_birthday`, `client_loyalty`)
VALUES
('Jason', 'CHAMPAGNE', '1991-02-10', 15),
('Bamogo', 'SAKO', '1965-09-15', 3),
('Emmanuel', 'MACRON', '1977-12-21', 100),
('Coco', 'LASTICOT', '1327-02-28', '0'),
('Tic', 'KIT', '2000-05-16', '5'),
('Tac', 'KAT', '2000-05-16', '5');