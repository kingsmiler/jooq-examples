
DROP DATABASE library;
CREATE DATABASE library COLLATE = 'utf8_general_ci' CHARACTER SET = 'utf8';
USE `library`;

CREATE TABLE `author` (
  `id`         INT NOT NULL,
  `first_name` VARCHAR(255) DEFAULT NULL,
  `last_name`  VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);