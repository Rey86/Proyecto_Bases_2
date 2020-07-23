-- ADM procedures.
-- Procedure to get a parameter with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getParameter (pnIdParameter INT) 
BEGIN
	SELECT id_parameter, name, value
	FROM PARAMETER
	WHERE id_parameter = IFNULL(pnIdParameter, id_parameter);
END$$

-- Procedure to set a parameter with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setParameter (pnIdParameter INT, pcParameterName VARCHAR(45), pnParameterValue INT) 
BEGIN
	UPDATE PARAMETER
	SET name = pcParameterName,
	value = pnParameterValue
	WHERE id_parameter = pnIdParameter;
	Commit;
END$$

-- Procedure to delete a specific parameter  
DELIMITER $$
CREATE PROCEDURE deleteParameter (pnIdParameter INT) 
BEGIN 
	DELETE FROM PARAMETER
	WHERE id_parameter = pnIdParameter;
	Commit;
END$$

-- Procedure to insert a new parameter
DELIMITER $$
CREATE PROCEDURE insertParameter (pcParameterName VARCHAR(45), pnParameterValue INT)
BEGIN
	INSERT INTO PARAMETER (name, value)
	VALUES (pcParameterName, pnParameterValue);
	Commit;
END$$
