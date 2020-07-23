-- ADM procedures.
-- Procedure to get a parameter with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getParameter (pnIdParameter INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT id_parameter, name, value
	FROM PARAMETER
	WHERE id_parameter = IFNULL(pnIdParameter, id_parameter);
END$$

-- Procedure to set a parameter with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setParameter (pnIdParameter INT, pcParameterName VARCHAR(45), pnParameterValue INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1263 SELECT 'Column set to default value; NULL supplied to NOT NULL column' Message;
    DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
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
	DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	DELETE FROM PARAMETER
	WHERE id_parameter = pnIdParameter;
	Commit;
END$$

-- Procedure to insert a new parameter
DELIMITER $$
CREATE PROCEDURE insertParameter (pcParameterName VARCHAR(45), pnParameterValue INT)
BEGIN
	DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	INSERT INTO PARAMETER (name, value)
	VALUES (pcParameterName, pnParameterValue);
	Commit;
END$$
