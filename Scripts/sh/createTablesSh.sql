CREATE TABLE `sh`.`category` (
  `ID_Category` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the product category',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the product category',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Category`))
COMMENT = 'Table that stores data of product categories';

CREATE TABLE `sh`.`deliverytype` (
  `ID_DeliveryType` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the delivery type',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the delivery type',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_DeliveryType`))
COMMENT = 'Table that stores data of delivery types';

CREATE TABLE `sh`.`paymentmethod` (
  `ID_PaymentMethod` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the payment method',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the payment method',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_PaymentMethod`))
COMMENT = 'Table that stores data of payment methods';

CREATE TABLE `sh`.`purchase` (
  `ID_Purchase` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the purchase',
  `Date` DATE NOT NULL COMMENT 'Date of tcountryhe purchase',
  `Username_Customer` VARCHAR(45) NOT NULL COMMENT 'Identification name of user that makes the purchase',
  `ID_PaymentMethod` INT NOT NULL COMMENT 'Identification number of the payment method that is being used',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Purchase`),
  INDEX `idx_purchase_usernameCustomer` (`Username_Customer` ASC) VISIBLE,
  INDEX `idx_purchase_idPaymentMethod` (`ID_PaymentMethod` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_usernameCustomer`
    FOREIGN KEY (`Username_Customer`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_idPaymentMethod`
    FOREIGN KEY (`ID_PaymentMethod`)
    REFERENCES `sh`.`paymentmethod` (`ID_PaymentMethod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of purchases';

CREATE TABLE `sh`.`product` (
  `ID_Product` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the product',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the product',
  `Price` INT UNSIGNED NOT NULL COMMENT 'Price of the product',
  `Sold` INT UNSIGNED NOT NULL COMMENT 'Boolean that shows if the product is sold',
  `Description` VARCHAR(140) NOT NULL COMMENT 'Description of the product',
  `Quantity` INT UNSIGNED NOT NULL COMMENT 'Quantity of the product',
  `UsernameSalesman` VARCHAR(45) NOT NULL COMMENT 'Identification name of the salesman',
  `ID_Category` INT NOT NULL COMMENT 'Identification number of the product category',
  `ID_DeliveryType` INT NOT NULL COMMENT 'Identification number of the delivery type of the product',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Product`),
  INDEX `idx_product_usernameSalesman` (`UsernameSalesman` ASC) VISIBLE,
  INDEX `idx_product_idCategory` (`ID_Category` ASC) VISIBLE,
  INDEX `idx_product_idDeliveryType` (`ID_DeliveryType` ASC) VISIBLE,
  CONSTRAINT `fk_product_usernameSalesman`
    FOREIGN KEY (`UsernameSalesman`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_idCategory`
    FOREIGN KEY (`ID_Category`)
    REFERENCES `sh`.`category` (`ID_Category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_idDeliveryType`
    FOREIGN KEY (`ID_DeliveryType`)
    REFERENCES `sh`.`deliverytype` (`ID_DeliveryType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of products';

CREATE TABLE `sh`.`review` (
  `ID_Review` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the review',
  `Stars` INT UNSIGNED NOT NULL COMMENT 'Calification of the product that is being reviewed',
  `Comment` VARCHAR(45) NOT NULL COMMENT 'Comment of the product that is being reviewed',
  `ID_Product` INT NOT NULL COMMENT 'Identification number of the product that is being reviewed',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Review`),
  INDEX `idx_review_idProduct` (`ID_Product` ASC) VISIBLE,
  CONSTRAINT `fk_review_idProduct`
    FOREIGN KEY (`ID_Product`)
    REFERENCES `sh`.`product` (`ID_Product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of review of the products';

CREATE TABLE `sh`.`photo` (
  `ID_Photo` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the photo',
  `ID_Product` INT NOT NULL COMMENT 'Identification number of the product that is on the photo',
  `Description` VARCHAR(140) NOT NULL COMMENT 'Description of the photo',
  `Direction` VARCHAR(100) NOT NULL COMMENT 'Direction of photo of the product',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Photo`),
  INDEX `idx_photo_idProduct` (`ID_Product` ASC) VISIBLE,
  CONSTRAINT `fk_photo_idProduct`
    FOREIGN KEY (`ID_Product`)
    REFERENCES `sh`.`product` (`ID_Product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores the directions of the photos of products';

CREATE TABLE `sh`.`productxpurchase` (
  `ID_Product` INT NOT NULL COMMENT 'Identification number of the product',
  `ID_Purchase` INT NOT NULL COMMENT 'Identification number of the purchase',
  `Quantity` INT UNSIGNED NOT NULL COMMENT 'Quantity of the products in the purchase',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Product`, `ID_Purchase`),
  INDEX `fk_productxpurchase_idPurchase_idx` (`ID_Purchase` ASC) VISIBLE,
  CONSTRAINT `fk_productxpurchase_idProduct`
    FOREIGN KEY (`ID_Product`)
    REFERENCES `sh`.`product` (`ID_Product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productxpurchase_idPurchase`
    FOREIGN KEY (`ID_Purchase`)
    REFERENCES `sh`.`purchase` (`ID_Purchase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
	COMMENT = 'Table that stores the products of each purchase';