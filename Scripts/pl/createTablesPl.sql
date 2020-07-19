CREATE TABLE `pl`.`country` (
  `ID_Country` INT NOT NULL COMMENT 'Identification number of the country',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the country',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Country`))
COMMENT = 'Table that stores data of countries';

CREATE TABLE `pl`.`province` (
  `ID_Province` INT NOT NULL COMMENT 'Identification number of the province',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the province',
  `ID_Country` INT NOT NULL COMMENT 'Identification number of its country',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Province`),
  INDEX `idx_province_idCountry` (`ID_Country` ASC) VISIBLE,
  CONSTRAINT `fk_province_idCountry`
    FOREIGN KEY (`ID_Country`)
    REFERENCES `pl`.`country` (`ID_Country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of provinces';

CREATE TABLE `pl`.`canton` (
  `ID_Canton` INT NOT NULL COMMENT 'Identification number of the canton',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the canton',
  `ID_Province` INT NOT NULL COMMENT 'Identification number of its province',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Canton`),
  INDEX `idx_canton_idProvince` (`ID_Province` ASC) VISIBLE,
  CONSTRAINT `fk_canton_idProvince`
    FOREIGN KEY (`ID_Province`)
    REFERENCES `pl`.`province` (`ID_Province`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of cantons';

CREATE TABLE `pl`.`community` (
  `ID_Community` INT NOT NULL COMMENT 'Identification number of the community',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the community',
  `ID_Canton` INT NOT NULL COMMENT 'Identification number of its canton',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Community`),
  INDEX `idx_community_idCanton` (`ID_Canton` ASC) VISIBLE,
  CONSTRAINT `fk_community_idCanton`
    FOREIGN KEY (`ID_Canton`)
    REFERENCES `pl`.`canton` (`ID_Canton`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of communities';