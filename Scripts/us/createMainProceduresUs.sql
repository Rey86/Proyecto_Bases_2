-- US procedures
-- Gender Table
-- Procedure to get a gender with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getGender (pnIdGender INT) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	SELECT id_gender, name
	FROM GENDER 
	WHERE id_gender = IFNULL(pnIdGender, id_gender);
END$$

-- Procedure to set a gender with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setGender (pnIdGender INT, pcGenderName VARCHAR(45)) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	UPDATE GENDER
	SET name = pcGenderNameName
	WHERE id_gender = pnIdGender;
	Commit;
END$$

-- Procedure to delete a specific gender 
DELIMITER $$
CREATE PROCEDURE deleteGender (pnIdGender INT) 
BEGIN 
	DECLARE vmenError VARCHAR(100);
	DELETE FROM GENDER
	WHERE id_gender = pnIdGender;
	Commit;
END$$

-- Procedure to insert a new gender
DELIMITER $$
CREATE PROCEDURE insertGender (pcGenderName VARCHAR(45))
BEGIN
	DECLARE vmenError VARCHAR(100);
	INSERT INTO GENDER (name)
	VALUES (pcGenderName);
	Commit;
END$$