SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `database` DEFAULT CHARACTER SET utf8 ;
USE `database` ;

-- -----------------------------------------------------
-- Table `database`.`clientthings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`clientthings` (
  `id` INT(11) NOT NULL,
  `list_value` VARCHAR(200) NULL DEFAULT NULL,
  `rotation` INT(11) NULL DEFAULT NULL,
  `coordinates` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`comboproperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`comboproperties` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `list_properties` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`things`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`things` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name_thing` VARCHAR(50) NULL DEFAULT NULL,
  `image_ref` VARCHAR(100) NULL DEFAULT NULL,
  `list_properties` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`prop_to_thing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`prop_to_thing` (
  `id_thing_prop` INT(11) NULL DEFAULT NULL,
  `id_properties` INT(11) NULL DEFAULT NULL,
  INDEX `FK__thing_prop_to_combobox` (`id_thing_prop` ASC),
  INDEX `FK__comboproperties_to_thing` (`id_properties` ASC),
  CONSTRAINT `FK__thing_prop_to_combobox`
    FOREIGN KEY (`id_thing_prop`)
    REFERENCES `database`.`things` (`id`),
  CONSTRAINT `FK__comboproperties_to_thing`
    FOREIGN KEY (`id_properties`)
    REFERENCES `database`.`comboproperties` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `password` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `role` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`schemas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`schemas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `param` VARCHAR(200) NULL DEFAULT NULL,
  `sum_raiting` INT(11) NULL DEFAULT NULL,
  `count_users` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`rait`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`rait` (
  `id_user` INT(11) NULL DEFAULT NULL,
  `id_shem` INT(11) NULL DEFAULT NULL,
  `rait` INT(11) NULL DEFAULT '0',
  INDEX `FK__user_to_rait` (`id_user` ASC),
  INDEX `FK__shema` (`id_shem` ASC),
  CONSTRAINT `FK__user_to_rait`
    FOREIGN KEY (`id_user`)
    REFERENCES `database`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK__shema`
    FOREIGN KEY (`id_shem`)
    REFERENCES `database`.`schemas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`thing_to_clientthing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`thing_to_clientthing` (
  `id_clientthing` INT(11) NULL DEFAULT NULL,
  `id_thing` INT(11) NULL DEFAULT NULL,
  INDEX `FK__clientthing_to_thing` (`id_clientthing` ASC),
  INDEX `FK__thing_to_client_thing` (`id_thing` ASC),
  CONSTRAINT `FK__clientthing_to_thing`
    FOREIGN KEY (`id_clientthing`)
    REFERENCES `database`.`clientthings` (`id`),
  CONSTRAINT `FK__thing_to_client_thing`
    FOREIGN KEY (`id_thing`)
    REFERENCES `database`.`things` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`user_to_client_thing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`user_to_client_thing` (
  `id_user` INT(11) NULL DEFAULT NULL,
  `id_client` INT(11) NULL DEFAULT NULL,
  INDEX `FK__user_to_client_thing` (`id_user` ASC),
  INDEX `FK__clientthing_to_user` (`id_client` ASC),
  CONSTRAINT `FK__user_to_client_thing`
    FOREIGN KEY (`id_user`)
    REFERENCES `database`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK__clientthing_to_user`
    FOREIGN KEY (`id_client`)
    REFERENCES `database`.`clientthings` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `database`.`user_to_thing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `database`.`user_to_thing` (
  `id_user` INT(11) NULL DEFAULT NULL,
  `id_thing` INT(11) NULL DEFAULT NULL,
  INDEX `FK__user_to_thing` (`id_user` ASC),
  INDEX `FK__thing_to_user` (`id_thing` ASC),
  CONSTRAINT `FK__user_to_thing`
    FOREIGN KEY (`id_user`)
    REFERENCES `database`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK__thing_to_user`
    FOREIGN KEY (`id_thing`)
    REFERENCES `database`.`things` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
