-- Admin Queries Sh
-- Procedure to get the top n most expensive products, using the category as a filter
DELIMITER $$
CREATE PROCEDURE getTopPricesPerCategory (n INT, pnID_Category INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select product_name, price from(Select p.name product_name, p.price price from product p 
    inner join category c on c.ID_Category = p.ID_Category
    where ID_category = IFNULL(pnID_Category, ID_category)
    group by product_name 
    order by price desc) TopPricesPerCategory
    where rownum <= n;
END$$
-- Procedure to get the top n most expensive purchase, using the category as a filter
DELIMITER $$
CREATE PROCEDURE getTopPurchaseAmountPerCategory (n INT, pnID_Category INT) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select pr.name product, pr.price price, c.name category from product pr
    inner join category c on c.ID_Category = pr.ID_category
    where sold >=1 and pr.ID_category = IFNULL(pnID_Category, pr.ID_category);
END$$