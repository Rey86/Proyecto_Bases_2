-- Pl procedures.
-- Country Table
-- Procedure to get a country with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getCountry (pnIdCountry INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT id_country, name
	FROM COUNTRY
	WHERE id_country = IFNULL(pnIdCountry, id_country);
END$$

-- Procedure to set a country with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setCountry (pnIdCountry INT, pcCountryName VARCHAR(45)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1263 SELECT 'Column set to default value; NULL supplied to NOT NULL column' Message;
    DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	UPDATE COUNTRY
	SET name = pcCountryName
	WHERE id_country = pnIdCountry;
	Commit;
END$$

-- Procedure to delete a specific country 
DELIMITER $$
CREATE PROCEDURE deleteCountry (pnIdCountry INT) 
BEGIN 
	DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	DELETE FROM COUNTRY
	WHERE id_country = pnIdCountry;
	Commit;
END$$

-- Procedure to insert a new country
DELIMITER $$
CREATE PROCEDURE insertCountry (pcCountryName VARCHAR(45))
BEGIN
	DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	INSERT INTO COUNTRY (name)
	VALUES (pcCountryName);
	Commit;
END$$

-- Province Table
-- Procedure to get a province with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getProvince (pnIdProvince INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT p.id_province id_province, p.name province_name, p.id_country id_country, c.name country_name
	FROM PROVINCE p
	INNER JOIN COUNTRY c
	ON p.id_country = c.id_country
	WHERE p.id_province = IFNULL(pnIdProvince, p.id_province);
END$$

-- Procedure to set a province with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setProvince (pnIdProvince INT, pcProvinceName VARCHAR(45), pnIdCountry INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1263 SELECT 'Column set to default value; NULL supplied to NOT NULL column' Message;
    DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	UPDATE PROVINCE
	SET name = pcProvinceName,
	id_country = pnIdCountry
	WHERE id_province = pnIdProvince;
	Commit;
END$$

-- Procedure to delete a specific province 
DELIMITER $$
CREATE PROCEDURE deleteProvince (pnIdProvince INT) 
BEGIN 
	DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	DELETE FROM PROVINCE
	WHERE id_province = pnIdProvince;
	Commit;
END$$

-- Procedure to insert a new province
DELIMITER $$
CREATE PROCEDURE insertProvince (pcProvinceName VARCHAR(45), pnIdCountry INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	INSERT INTO PROVINCE (name, id_country)
	VALUES (pcProvinceName, pnIdCountry);
	Commit;
END$$

-- Canton Table
-- Procedure to get a canton with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getCanton (pnIdCanton INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT c.id_canton id_canton, c.name canton_name, c.id_province id_province, p.name province_name
	FROM CANTON c
	INNER JOIN PROVINCE p
	ON c.id_province = p.id_province
	WHERE c.id_canton = IFNULL(pnIdCanton, c.id_canton);
END$$

-- Procedure to set a canton with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setCanton (pnIdCanton INT, pcCantonName VARCHAR(45), pnIdProvince INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1263 SELECT 'Column set to default value; NULL supplied to NOT NULL column' Message;
    DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	UPDATE CANTON
	SET name = pcCantonName,
	id_province = pnIdProvince
	WHERE id_canton = pnIdCanton;
	Commit;
END$$

-- Procedure to delete a specific canton 
DELIMITER $$
CREATE PROCEDURE deleteCanton (pnIdCanton INT) 
BEGIN 
	DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	DELETE FROM CANTON
	WHERE id_canton = pnIdCanton;
	Commit;
END$$

-- Procedure to insert a new canton
DELIMITER $$
CREATE PROCEDURE insertCanton (pcCantonName VARCHAR(45), pnIdProvince INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	INSERT INTO CANTON (name, id_province)
	VALUES (pcCantonName, pnIdProvince);
	Commit;
END$$

-- Community Table
-- Procedure to get a community with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getCommunity (pnIdCommunity INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT c.id_community id_community, c.name community_name, c.id_canton id_canton, ca.name canton_name
	FROM COMMUNITY c
	INNER JOIN CANTON ca
	ON c.id_canton = ca.id_canton
	WHERE c.id_community = IFNULL(pnIdCommunity, c.id_community);
END$$

-- Procedure to set a community with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setCommunity (pnIdCommunity INT, pcCommunityName VARCHAR(45), pnIdCanton INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1263 SELECT 'Column set to default value; NULL supplied to NOT NULL column' Message;
    DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	UPDATE COMMUNITY
	SET name = pcCommunityName,
	id_canton = pnIdCanton
	WHERE id_community = pnIdCommunity;
	Commit;
END$$

-- Procedure to delete a specific community 
DELIMITER $$
CREATE PROCEDURE deleteCommunity (pnIdCommunity INT) 
BEGIN 
	DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	DELETE FROM COMMUNITY
	WHERE id_community = pnIdCommunity;
	Commit;
END$$

-- Procedure to insert a new community
DELIMITER $$
CREATE PROCEDURE insertCommunity (pcCommunityName VARCHAR(45), pnIdCanton INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1232 SELECT 'Incorrect argument type to variable' Message;
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	INSERT INTO COMMUNITY (name, id_canton)
	VALUES (pcCommunityName, pnIdCanton);
	Commit;
END$$