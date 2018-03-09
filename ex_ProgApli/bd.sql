-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE,
SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema vendas
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema vendas
-- -----------------------------------------------------
USE `bd` ;
-- -----------------------------------------------------
-- Table `vendas`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `modalidades`(
 `id` INT(100) UNSIGNED NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(100) NOT NULL,
  `ouro` INT(15) NULL DEFAULT NULL,
 `prata` INT(60) NOT NULL UNIQUE,
  `bronze` INT(60) NOT NULL UNIQUE,
 PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
