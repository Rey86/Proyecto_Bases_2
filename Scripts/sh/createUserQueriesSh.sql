-- User Queries Sh
-- Procedure that searches a list of products with names similar to the given varchar
DELIMITER $$
CREATE PROCEDURE getSearchedProducts (psSearchWord varchar(50)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select p.id_product id_product, p.name product, p.price price, p.Quantity Quantity, 
	c.Name category, dt.Name deliverytype, p.UsernameSalesman Salesman from product p 
    inner join category c on c.ID_Category = p.ID_Category
    inner join deliverytype dt on p.id_deliverytype = dt.id_deliverytype
    where p.name like ifnull(psSearchWord, p.name);
END$$




