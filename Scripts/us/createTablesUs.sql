CREATE TABLE `us`.`gender` (
  `ID_Gender` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the gender',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the gender',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Gender`))
COMMENT = 'Table that stores data of genders';

CREATE TABLE `us`.`usertype` (
  `ID_UserType` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the user type',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the user type',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_UserType`))
COMMENT = 'Table that stores data of user types';

CREATE TABLE `us`.`nationality` (
  `ID_Nationality` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification number of the nationality',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the nationality',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`ID_Nationality`))
COMMENT = 'Table that stores data of nationalities';

CREATE TABLE `us`.`user` (
  `Username` VARCHAR(45) NOT NULL COMMENT 'Identification name of the user',
  `Email` VARCHAR(45) NOT NULL COMMENT 'Email of the user',
  `Birthdate` DATE NOT NULL COMMENT 'Date of birth of the user',
  `Name` VARCHAR(45) NOT NULL COMMENT 'Name of the user',
  `firstLastName` VARCHAR(45) NOT NULL COMMENT 'First last name of the user',
  `secondLastName` VARCHAR(45) NOT NULL COMMENT 'Second last name of the user',
  `Password` VARCHAR(45) NOT NULL COMMENT 'Password of the user',
  `ID` VARCHAR(45) NOT NULL COMMENT 'Identification number of the user',
  `PhotoDirection` VARCHAR(100) NOT NULL COMMENT 'Direction of photo of the user',
  `ID_Community` INT NOT NULL COMMENT 'Identification number of community of the user',
  `ID_UserType` INT NOT NULL COMMENT 'Identification number of type of the user',
  `ID_Gender` INT NOT NULL COMMENT 'Identification number of gender of the user',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`Username`),
  UNIQUE INDEX `user_id_uk` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `user_photoDirection_uk` (`PhotoDirection` ASC) VISIBLE,
  INDEX `idx_user_idCommunity` (`ID_Community` ASC) VISIBLE,
  INDEX `idx_user_idUserType` (`ID_UserType` ASC) VISIBLE,
  INDEX `idx_user_idGender` (`ID_Gender` ASC) VISIBLE,
  CONSTRAINT `fk_user_idCommunity`
    FOREIGN KEY (`ID_Community`)
    REFERENCES `pl`.`community` (`ID_Community`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_idUserType`
    FOREIGN KEY (`ID_UserType`)
    REFERENCES `us`.`usertype` (`ID_UserType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_idGender`
    FOREIGN KEY (`ID_Gender`)
    REFERENCES `us`.`gender` (`ID_Gender`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of users';

CREATE TABLE `us`.`userreviews` (
  `Username_Reviewer` VARCHAR(45) NOT NULL COMMENT 'Identification name of user that makes the review',
  `Username_Reviewee` VARCHAR(45) NOT NULL COMMENT 'Identification name of user that receives the review',
  `Customer` TINYINT NOT NULL COMMENT 'Boolean that shows if the reviewer is customer',
  `Comment` VARCHAR(140) NOT NULL COMMENT 'Comment of the review',
  `Stars` INT NOT NULL COMMENT 'Calification of the user',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`Username_Reviewer`, `Username_Reviewee`),
  INDEX `idx_userreviews_usernameReviewee` (`Username_Reviewee` ASC) VISIBLE,
  CONSTRAINT `fk_userreviews_usernameReviewer`
    FOREIGN KEY (`Username_Reviewer`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userreviews_usernameReviewee`
    FOREIGN KEY (`Username_Reviewee`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of reviews of the users';

CREATE TABLE `us`.`receiverxsender` (
  `Username_Sender` VARCHAR(45) NOT NULL COMMENT 'Identification name of user that sends the message',
  `Username_Receiver` VARCHAR(45) NOT NULL COMMENT 'Identification name of user that receives the message',
  `MessageContent` VARCHAR(140) NOT NULL COMMENT 'Comment of the message',
  `Time` DATETIME NOT NULL COMMENT 'Time when the message was sent',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`Username_Sender`, `Username_Receiver`),
  INDEX `idx_receiverxsender_usernameSender` (`Username_Receiver` ASC) VISIBLE,
  CONSTRAINT `fk_receiverxsender_usernameSender`
    FOREIGN KEY (`Username_Sender`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receiverxsender_usernameReceiver`
    FOREIGN KEY (`Username_Receiver`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of messages of the users';

CREATE TABLE `us`.`userwishesproduct` (
  `Username` VARCHAR(45) NOT NULL COMMENT 'Identification name the user that owns the wish list',
  `ID_Product` INT NOT NULL COMMENT 'Identification number of product that is on the wish list',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`Username`, `ID_Product`),
  INDEX `idx_userwishesproduct_idProduct` (`ID_Product` ASC) VISIBLE,
  CONSTRAINT `fk_userwishesproduct_username`
    FOREIGN KEY (`Username`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userwishesproduct_idProduct`
    FOREIGN KEY (`ID_Product`)
    REFERENCES `sh`.`product` (`ID_Product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of products on the wish list of each user';

CREATE TABLE `us`.`userviewsproduct` (
  `Username` VARCHAR(45) NOT NULL COMMENT 'Identification name the user that saw the product',
  `ID_Product` INT NOT NULL COMMENT 'Identification number of product that has been seen',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`Username`, `ID_Product`),
  INDEX `idx_userviewsproduct_idProduct` (`ID_Product` ASC) VISIBLE,
  CONSTRAINT `fk_userviewsproduct_username`
    FOREIGN KEY (`Username`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userviewsproduct_idProduct`
    FOREIGN KEY (`ID_Product`)
    REFERENCES `sh`.`product` (`ID_Product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores data of products that have been seen';

CREATE TABLE `us`.`userxnationality` (
  `Username` VARCHAR(45) NOT NULL COMMENT 'Identification name the user',
  `ID_Nationality` INT NOT NULL COMMENT 'Identification number of the nationality',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`Username`, `ID_Nationality`),
  INDEX `idx_userxnationality_idNationality` (`ID_Nationality` ASC) INVISIBLE,
  CONSTRAINT `fk_userxnationality_username`
    FOREIGN KEY (`Username`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userxnationality_idNationality`
    FOREIGN KEY (`ID_Nationality`)
    REFERENCES `us`.`nationality` (`ID_Nationality`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores the different nacionalities of each user';

CREATE TABLE `us`.`phonenumber` (
  `PhoneNumber` INT NOT NULL COMMENT 'The phone number of the user',
  `Username` VARCHAR(45) NOT NULL COMMENT 'Identification name the user that owns the phone number',
  `date_creation` DATE NOT NULL COMMENT 'Date of creation',
  `user_creation` VARCHAR(45) NOT NULL COMMENT 'User who created it',
  `date_last_modification` DATE NULL COMMENT 'Date of the last modification',
  `user_last_modification` VARCHAR(45) NULL COMMENT 'Last user who modified it',
  PRIMARY KEY (`PhoneNumber`, `Username`),
  INDEX `idx_phonenumber_username` (`Username` ASC) VISIBLE,
  CONSTRAINT `fk_phonenumber_username`
    FOREIGN KEY (`Username`)
    REFERENCES `us`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Table that stores the phone numbers of the user';