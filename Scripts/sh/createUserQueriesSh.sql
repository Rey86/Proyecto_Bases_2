-- User Queries Sh
-- Procedure that searches a list of products with names similar to the given varchar
DELIMITER $$
CREATE PROCEDURE getSearchedProducts (psSearchWord varchar(50)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select name, price from product where name like pvSearchWord;
END$$

-- Procedure that gets the list of the most recent purchases
DELIMITER $$
CREATE PROCEDURE getPurhaseHistory (month int) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	-- Corregir calculo de meses
	Select p.ID_Purchase, p.Date, p.Username_Customer Customer, pm.Name
    from purchase p
    inner join paymentmethod pm on pm.ID_PaymentMethod = p.ID_PaymentMethod
    where month(date) = month;
END$$


