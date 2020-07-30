-- Admin Queries Sh
-- Procedure to get the top n most expensive products, using the category as a filter
DELIMITER $$
CREATE PROCEDURE getTopPricesPerCategory (n INT, pnID_Category INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select p.name product_name, p.price price, c.Name category from product p 
    inner join category c on c.ID_Category = p.ID_Category
    where p.ID_category = IFNULL(pnID_Category, p.ID_category)
    group by product_name 
    order by price desc 
    LIMIT n;
END$$
-- Procedure to get the top n most expensive purchase, using the category as a filter
DELIMITER $$
CREATE PROCEDURE getMaxMinPurchaseAmountPerCategory () 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	select c.name category, max(pr.price) max, min(pr.price) min from product pr
    inner join category c on c.ID_Category = pr.ID_Category
    group by category;
END$$