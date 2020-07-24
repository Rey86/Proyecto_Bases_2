-- User Queries Us
-- Procedure that gets a list of the views of a product being sold by the user
DELIMITER $$
CREATE PROCEDURE getViewsHistory (psUsername varchar(45)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
    Select p.name, uv.username viewed_by, up.date_creation viewed from user u
    inner join sh.product p on p.UsernameSalesman = u.username
    inner join userviewsproduct up on up.ID_Product = p.ID_Product
    inner join user uv on uv.Username = up.Username
    where u.Username = psUsername and up.date_creation = sysdate();
END$$

-- Procedure that gets the list of all products sold by the user
DELIMITER $$
CREATE PROCEDURE getSoldProduct (psUsername varchar(45))
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
    -- Revisar esta
	Select p.name product_name, p.Sold sales from user u 
    inner join sh.product p on p.UsernameSalesman = u.Username
    where u.Username = psUsername and sold >= 1;
END$$

-- Procedure that gets a list of all purchases that cost over 1000 per category made by the user
DELIMITER $$
CREATE PROCEDURE getPurchasesOver1000PerCategory (psUsername varchar(45),  pnID_Category INT)
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
    select pu.ID_Purchase ID_Purchase, pm.Name, sum(pr.price) Total_Price from user u
    inner join sh.purchase pu on pu.Username_Customer = u.Username
    inner join sh.productxpurchase pp on pp.ID_Purchase = pu.ID_Purchase
    inner join sh.product pr on pr.ID_Product = pp.ID_Product
    inner join paymentmethod pm on pm.ID_PaymentMethod = pu.ID_PaymentMethod
    where u.Username = psUsername and Total_Price >= 1000 and p.ID_category = IFNULL(pnID_Category, p.ID_category);
END$$

-- Procedure that gets the list of the most recent purchases
DELIMITER $$
CREATE PROCEDURE getPurhaseHistory (month int, psUsername varchar(45)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	-- Corregir calculo de meses
	Select pu.ID_Purchase ID_Purchase, pu.Date Date, pm.Name,  sum(pr.price) Total_Price
    from user u
    inner join sh.purchase pu on pu.Username_Customer = u.Username
    inner join sh.productxpurchase pp on pp.ID_Purchase = pu.ID_Purchase
    inner join sh.product pr on pr.ID_Product = pp.ID_Product
    inner join paymentmethod pm on pm.ID_PaymentMethod = pu.ID_PaymentMethod
    where u.username = psUsername and month(date) = month;
END$$
