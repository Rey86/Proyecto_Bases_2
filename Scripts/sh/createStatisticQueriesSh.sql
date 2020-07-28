DELIMITER $$
CREATE PROCEDURE getProductPercentagePerCategory () 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT c.name category, round(100*ratio_to_report(count(*)) , 2) percentage, ratio_to_report(count(*)) total
    from product p 
    inner join category c on c.ID_Category = p.ID_Category
    group by category;
END$$

DELIMITER $$
CREATE PROCEDURE getSalesPercentagePerGender () 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT g.name gender, round(100*ratio_to_report(count(*)) , 2) percentage, ratio_to_report(count(*)) total 
    FROM product p
    inner join us.user u on u.Username = p.UsernameSalesman
    inner join us.gender g on g.ID_Gender = u.ID_Gender
    where p.Sold >= 1
    group by gender;
END$$

DELIMITER $$
CREATE PROCEDURE getPurchaseAmountPercentagePerGender () 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
    -- check this
	SELECT g.name gender, round(100*ratio_to_report(count(*)) , 2) percentage, ratio_to_report(count(*)) total 
    FROM purchase pu
    inner join productxpurchase pp on pp.ID_Purchase = pu.ID_Purchase
    inner join product pr on pr.ID_Product =  pp.ID_Product
    inner join us.user u on u.Username = pr.UsernameSalesman
    inner join us.gender g on g.ID_Gender = u.ID_Gender
    group by gender;
END$$