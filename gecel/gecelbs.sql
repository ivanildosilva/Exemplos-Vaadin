SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `gecelbs` DEFAULT CHARACTER SET latin1 ;
USE `gecelbs` ;

-- -----------------------------------------------------
-- Table `gecelbs`.`privilegio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gecelbs`.`privilegio` ;

CREATE  TABLE IF NOT EXISTS `gecelbs`.`privilegio` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gecelbs`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gecelbs`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `gecelbs`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NULL DEFAULT NULL ,
  `senha` VARCHAR(45) NULL DEFAULT NULL ,
  `ativo` TINYINT(4) NULL DEFAULT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `foto` VARCHAR(45) NULL DEFAULT NULL ,
  `privilegio` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_usuario_privilegio` (`privilegio` ASC) ,
  CONSTRAINT `fk_usuario_privilegio`
    FOREIGN KEY (`privilegio` )
    REFERENCES `gecelbs`.`privilegio` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gecelbs`.`participante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gecelbs`.`participante` ;

CREATE  TABLE IF NOT EXISTS `gecelbs`.`participante` (
  `matricula` VARCHAR(10) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `sobrenome` VARCHAR(45) NOT NULL ,
  `sexo` VARCHAR(9) NULL DEFAULT NULL ,
  `nascimento` DATETIME NOT NULL ,
  `curso` VARCHAR(45) NOT NULL ,
  `projeto` VARCHAR(45) NOT NULL ,
  `rg` VARCHAR(13) NULL DEFAULT NULL ,
  `cpf` VARCHAR(11) NULL DEFAULT NULL ,
  `obs` VARCHAR(100) NULL DEFAULT NULL ,
  `foto` VARCHAR(45) NULL DEFAULT NULL ,
  `cadastro` DATETIME NULL DEFAULT NULL ,
  `criador` INT(11) NOT NULL ,
  `ativo` TINYINT(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`matricula`) ,
  INDEX `fk_participante_usuario` (`criador` ASC) ,
  CONSTRAINT `fk_participante_usuario`
    FOREIGN KEY (`criador` )
    REFERENCES `gecelbs`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gecelbs`.`contato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gecelbs`.`contato` ;

CREATE  TABLE IF NOT EXISTS `gecelbs`.`contato` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `telefone` VARCHAR(10) NULL DEFAULT NULL ,
  `celular` VARCHAR(10) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL ,
  `participante` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_contato_participante1` (`participante` ASC) ,
  CONSTRAINT `fk_contato_participante1`
    FOREIGN KEY (`participante` )
    REFERENCES `gecelbs`.`participante` (`matricula` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gecelbs`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gecelbs`.`endereco` ;

CREATE  TABLE IF NOT EXISTS `gecelbs`.`endereco` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `logradouro` VARCHAR(45) NULL DEFAULT NULL ,
  `numero` VARCHAR(5) NULL DEFAULT NULL ,
  `bairro` VARCHAR(45) NULL DEFAULT NULL ,
  `cidade` VARCHAR(45) NULL DEFAULT NULL ,
  `cep` INT(11) NULL DEFAULT NULL ,
  `complemento` VARCHAR(45) NULL DEFAULT NULL ,
  `uf` VARCHAR(2) NULL DEFAULT NULL ,
  `participante` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_endereco_participante` (`participante` ASC) ,
  CONSTRAINT `fk_endereco_participante`
    FOREIGN KEY (`participante` )
    REFERENCES `gecelbs`.`participante` (`matricula` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
