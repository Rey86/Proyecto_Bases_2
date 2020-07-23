-- US procedures
-- Gender Table
-- Procedure to get a gender with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getGender (pnIdGender INT) 
BEGIN
	SELECT id_gender, name
	FROM GENDER 
	WHERE id_gender = IFNULL(pnIdGender, id_gender);
END$$

-- Procedure to set a gender with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setGender (pnIdGender INT, pcGenderName VARCHAR(45)) 
BEGIN
	UPDATE GENDER
	SET name = pcGenderName
	WHERE id_gender = pnIdGender;
	Commit;
END$$

-- Procedure to delete a specific gender 
DELIMITER $$
CREATE PROCEDURE deleteGender (pnIdGender INT) 
BEGIN
	DELETE FROM GENDER
	WHERE id_gender = pnIdGender;
	Commit;
END$$

-- Procedure to insert a new gender
DELIMITER $$
CREATE PROCEDURE insertGender (pcGenderName VARCHAR(45))
BEGIN
	INSERT INTO GENDER (name)
	VALUES (pcGenderName);
	Commit;
END$$

-- UserType Table
-- Procedure to get a user type with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getUserType (pnIdUserType INT) 
BEGIN
	SELECT id_usertype, name
	FROM USERTYPE
	WHERE id_usertype = IFNULL(pnIdUserType, id_usertype);
END$$

-- Procedure to set a user type with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setUserType (pnIdUserType INT, pcUserTypeName VARCHAR(45)) 
BEGIN
	UPDATE USERTYPE
	SET name = pcUserTypeName
	WHERE id_usertype = pnIdUserType;
	Commit;
END$$

-- Procedure to delete a specific user type 
DELIMITER $$
CREATE PROCEDURE deleteUserType (pnIdUserType INT) 
BEGIN
	DELETE FROM USERTYPE
	WHERE id_usertype = pnIdUserType;
	Commit;
END$$

-- Procedure to insert a new user type
DELIMITER $$
CREATE PROCEDURE insertUserType (pcUserTypeName VARCHAR(45))
BEGIN
	INSERT INTO USERTYPE (name)
	VALUES (pcUserTypeName);
	Commit;
END$$

-- Nationality Table
-- Procedure to get a nationality with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getNationality (pnIdNationality INT) 
BEGIN
	SELECT id_nationality, name
	FROM NATIONALITY
	WHERE id_nationality = IFNULL(pnIdNationality, id_nationality);
END$$

-- Procedure to set a nationality with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setNationality (pnIdNationality INT, pcNationalityName VARCHAR(45)) 
BEGIN
	UPDATE NATIONALITY
	SET name = pcNationalityName
	WHERE id_nationality = pnIdNationality;
	Commit;
END$$

-- Procedure to delete a specific nationality 
DELIMITER $$
CREATE PROCEDURE deleteNationality (pnIdNationality INT) 
BEGIN
	DELETE FROM NATIONALITY
	WHERE id_nationality = pnIdNationality;
	Commit;
END$$

-- Procedure to insert a new nationality
DELIMITER $$
CREATE PROCEDURE insertNationality (pcNationalityName VARCHAR(45))
BEGIN
	INSERT INTO NATIONALITY (name)
	VALUES (pcNationalityName);
	Commit;
END$$

-- User Table
-- Procedure to get a user with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getUser (pcUsername VARCHAR(45)) 
BEGIN
	SELECT u.username username, u.email email, u.birthdate birthdate, (SYSDATE-u.birthdate) age, 
	u.name first_name, u.firstlastname first_lastname, u.secondlastname second_lastname,
    u.password password, u.id id_user, u.photodirection photo_direction, u.id_community id_community,
    c.name community_name, u.id_usertype id_usertype, ut.name usertype_name, u.id_gender id_gender, 
	g.name gender_name
	FROM USER u
    INNER JOIN COMMUNITY c
    ON u.id_community = c.id_community
    INNER JOIN USERTYPE ut
    ON u.id_usertype = ut.id_usertype
    INNER JOIN GENDER g
    ON u.id_gender = g.id_gender
	WHERE u.username = IFNULL(pcUsername, u.username);
END$$

-- Procedure to set a user with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setUser (pcUsername VARCHAR(45), pcEmail VARCHAR(45), pdBirthdate DATE, 
	pcFirstName VARCHAR(45), pcFirstLastName VARCHAR(45), pcSecondLastName VARCHAR(45), pnIdUser VARCHAR(45),
    pcPhotoDirection VARCHAR(100), pnIdCommunity INT, pnIdUserType INT, pnIdGender INT) 
BEGIN
	UPDATE USER
	SET email = pcEmail,
    birthdate = pdBirthdate,
    name = pcFirstName,
    firstlastname = pcFirstLastName,
    secondlastname = pcSecondLastName,
    id = pnIdUser,
    photodirection = pcPhotoDirection,
    id_community = pnIdCommunity,
    id_usertype = pnIdUserType,
    id_gender = pnIdGender
	WHERE username = pcUsername;
	Commit;
END$$

-- Procedure to delete a specific user 
DELIMITER $$
CREATE PROCEDURE deleteUser (pcUsername INT) 
BEGIN
	DELETE FROM USER
	WHERE username = pcUsername;
	Commit;
END$$

-- Procedure to insert a new user
DELIMITER $$
CREATE PROCEDURE insertUser (pcUsername VARCHAR(45), pcEmail VARCHAR(45), pdBirthdate DATE, 
	pcFirstName VARCHAR(45), pcFirstLastName VARCHAR(45), pcSecondLastName VARCHAR(45), 
    pcUserPassword VARCHAR(45), pnIdUser VARCHAR(45), pcPhotoDirection VARCHAR(100), pnIdCommunity INT, 
    pnIdUserType INT, pnIdGender INT)
BEGIN
	INSERT INTO USER (username, email, birthdate, name, firstlastname, secondlastname, password, id, 
		photodirection, id_community, id_usertype, id_gender)
	VALUES (pcUsername, pcEmail, pdBirthdate, pcFirstName, pcFirstLastName, pcSecondLastName, pcUserPassword,
		pnIdUser, pcPhotoDirection, pnIdCommunity, pnIdUserType, pnIdGender);
	Commit;
END$$

-- UserReview Table
-- Procedure to get a user review with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getUserReview (pcUsernameReviewer VARCHAR(45), pcUsernameReviewee VARCHAR(45)) 
BEGIN
	SELECT username_reviewer, username_reviewee, customer, comment, stars
	FROM USERREVIEW
	WHERE username_reviewer = IFNULL(pcUsernameReviewer, username_reviewer) AND
    username_reviewee = IFNULL(pcUsernameReviewee, username_reviewee);
END$$

-- Procedure to set a user review with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setUserReview (pcUsernameReviewer VARCHAR(45), pcUsernameReviewee VARCHAR(45),
	pnCustomer TINYINT, pcComment VARCHAR(140), pnStars INT)
BEGIN
	UPDATE USERREVIEW
	SET customer = pnCustomer,
    comment = pcComment,
    stars = pnStars
	WHERE username_reviewer = pcUsernameReviewer AND username_reviewee = pcUsernameReviewee;
	Commit;
END$$

-- Procedure to delete a specific user review 
DELIMITER $$
CREATE PROCEDURE deleteUserReview (pcUsernameReviewer VARCHAR(45), pcUsernameReviewee VARCHAR(45)) 
BEGIN
	DELETE FROM USERREVIEW
	WHERE username_reviewer = pcUsernameReviewer AND username_reviewee = pcUsernameReviewee;
	Commit;
END$$

-- Procedure to insert a new user review
DELIMITER $$
CREATE PROCEDURE insertUserReview (pcUsernameReviewer VARCHAR(45), pcUsernameReviewee VARCHAR(45),
	pnCustomer TINYINT, pcComment VARCHAR(140), pnStars INT) 
BEGIN
	INSERT INTO USERREVIEW (username_reviewer, username_reviewee, customer, comment, stars)
	VALUES (pcUsernameReviewer, pcUsernameReviewee, pnCustomer, pcComment, pnStars);
	Commit;
END$$

-- ReceiverxSender Table
-- Procedure to get a receiverxsender with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getReceiverxSender (pcUsernameSender VARCHAR(45), pcUsernameReceiver VARCHAR(45)) 
BEGIN
	SELECT username_sender, username_receiver, messagecontent, time
	FROM RECEIVERXSENDER
	WHERE username_sender = IFNULL(pcUsernameSender, username_sender) AND
    username_receiver = IFNULL(pcUsernameReceiver, username_receiver);
END$$

-- Procedure to set a receiverxsender with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setReceiverxSender (pcUsernameSender VARCHAR(45), pcUsernameReceiver VARCHAR(45), 
	pcMessageContent VARCHAR(140), pdtTime DATETIME)
BEGIN
	UPDATE RECEIVERXSENDER
	SET messagecontent = pcMessageContent,
    time = pdtTime
	WHERE username_sender = pcUsernameSender AND username_receiver = pcUsernameReceiver;
	Commit;
END$$

-- Procedure to delete a specific receiverxsender
DELIMITER $$
CREATE PROCEDURE deleteReceiverxSender (pcUsernameSender VARCHAR(45), pcUsernameReceiver VARCHAR(45)) 
BEGIN
	DELETE FROM RECEIVERXSENDER
	WHERE username_sender = pcUsernameSender AND username_receiver = pcUsernameReceiver;
	Commit;
END$$

-- Procedure to insert a new receiverxsender
DELIMITER $$
CREATE PROCEDURE insertReceiverxSender (pcUsernameSender VARCHAR(45), pcUsernameReceiver VARCHAR(45), 
	pcMessageContent VARCHAR(140), pdtTime DATETIME) 
BEGIN
	INSERT INTO RECEIVERXSENDER (username_sender, username_receiver, messagecontent, time)
	VALUES (pcUsernameSender, pcUsernameReceiver, pcMessageContent, pdtTime);
	Commit;
END$$

-- UserWishesProduct Table
-- Procedure to delete a specific userwishesproduct
DELIMITER $$
CREATE PROCEDURE deleteUserWishesProduct (pcUsername VARCHAR(45), pnIdProduct INT) 
BEGIN
	DELETE FROM USERWISHESPRODUCT
	WHERE username = pcUsername AND id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to insert a new userwishesproduct
DELIMITER $$
CREATE PROCEDURE insertUserWishesProduct (pcUsername VARCHAR(45), pnIdProduct INT) 
BEGIN
	INSERT INTO USERWISHESPRODUCT (username, id_product)
	VALUES (pcUsername, pnIdProduct);
	Commit;
END$$

-- UserViewsProduct Table
-- Procedure to delete a specific userviewsproduct
DELIMITER $$
CREATE PROCEDURE deleteUserViewsProduct (pcUsername VARCHAR(45), pnIdProduct INT) 
BEGIN
	DELETE FROM USERVIEWSPRODUCT
	WHERE username = pcUsername AND id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to insert a new userviewsproduct
DELIMITER $$
CREATE PROCEDURE insertUserViewsProduct (pcUsername VARCHAR(45), pnIdProduct INT) 
BEGIN
	INSERT INTO USERVIEWSPRODUCT (username, id_product)
	VALUES (pcUsername, pnIdProduct);
	Commit;
END$$

-- UserxNationality Table
-- Procedure to delete a specific userxnationality
DELIMITER $$
CREATE PROCEDURE deleteUserxNationality (pcUsername VARCHAR(45), pnIdNationality INT) 
BEGIN
	DELETE FROM USERXNATIONALITY
	WHERE username = pcUsername AND id_nationality = pnIdNationality;
	Commit;
END$$

-- Procedure to insert a new userxnationality
DELIMITER $$
CREATE PROCEDURE insertUserxNationality (pcUsername VARCHAR(45), pnIdNationality INT) 
BEGIN
	INSERT INTO USERXNATIONALITY (username, id_nationality)
	VALUES (pcUsername, pnIdNationality);
	Commit;
END$$

-- PhoneNumber Table
-- Procedure to delete a specific phone number
DELIMITER $$
CREATE PROCEDURE deletePhoneNumber(pnPhoneNumber INT, pcUsername VARCHAR(45)) 
BEGIN
	DELETE FROM PHONENUMBER
	WHERE phonenumer = pnPhoneNumber AND username = pcUsername;
	Commit;
END$$

-- Procedure to insert a new phone number
DELIMITER $$
CREATE PROCEDURE insertPhoneNumber (pnPhoneNumber INT, pcUsername VARCHAR(45)) 
BEGIN
	INSERT INTO PHONENUMBER (phonenumer, username)
	VALUES (pnPhoneNumber, pcUsername);
	Commit;
END$$

-- UserWantsProduct Table
-- Procedure to delete a specific userwantsproduct
DELIMITER $$
CREATE PROCEDURE deleteUserWantsProduct (pcUsername VARCHAR(45), pnIdProduct INT) 
BEGIN
	DELETE FROM USERWANTSPRODUCT
	WHERE username = pcUsername AND id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to insert a new userwantsproduct
DELIMITER $$
CREATE PROCEDURE insertUserWantsProduct (pcUsername VARCHAR(45), pnIdProduct INT) 
BEGIN
	INSERT INTO USERWANTSPRODUCT (username, id_product)
	VALUES (pcUsername, pnIdProduct);
	Commit;
END$$