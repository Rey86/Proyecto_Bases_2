-- User Queries Sh
-- Procedure that searches a list of products with names similar to the given varchar
DELIMITER $$
CREATE PROCEDURE getSearchedProducts (psSearchWord varchar(50)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select p.name product, p.price price, p.Quantity Quantity, pm.Name paymentmethod, c.Name category, p.UsernameSalesman Salesman, r.Stars reviews from product p 
    inner join category c on c.ID_Category = p.ID_Category
    inner join review r on r.ID_product = p.ID_Product
    inner join paymentMethod pm on pm.ID_PaymentMethod = p.ID_PaymentMethod
    where p.name like ifnull(pvSearchWord, p.name);
END$$




