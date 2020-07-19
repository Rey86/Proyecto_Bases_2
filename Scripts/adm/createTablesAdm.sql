CREATE TABLE `adm`.`generallog` (
  `ID_GeneralLog` INT NOT NULL COMMENT 'Log identification number',
  `schemeName` VARCHAR(45) NOT NULL COMMENT 'Name of scheme that underwent change',
  `tableName` VARCHAR(45) NOT NULL COMMENT 'Name of table that underwent change',
  `columnName` VARCHAR(45) NOT NULL COMMENT 'Name of column that underwent change',
  `modificationDate` DATE NOT NULL COMMENT 'Date of the modification',
  `ID_Product` INT NOT NULL COMMENT 'ID of the product that modificated his price',
  `current_value` VARCHAR(45) NOT NULL COMMENT 'Actual value',
  `previous_value` VARCHAR(45) NULL COMMENT 'Old value',
  PRIMARY KEY (`ID_GeneralLog`))
COMMENT = 'Table that register every change of value in the database';

CREATE TABLE `adm`.`parameter` (
  `ID_Parameter` INT NOT NULL COMMENT 'Parameter identification number',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Parameter name',
  `Value` VARCHAR(45) NOT NULL COMMENT 'Parameter value',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Parameter`))
COMMENT = 'Table that stores parameters for querys';