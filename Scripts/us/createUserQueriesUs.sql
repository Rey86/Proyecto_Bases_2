-- User Queries Us
-- Procedure that gets a list of the views of a product being sold by the user
DELIMITER $$
CREATE PROCEDURE getViewsHistory (psUsername varchar(45)) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
    Select p.name, p.usernamesalesman, up.date_creation viewed from user u
	inner join userviewsproduct up on up.Username = u.Username
    inner join sh.product p on up.ID_Product = p.ID_Product
    where u.Username = ifnull(psUsername, u.username);
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
	Select p.name product, p.Sold sales from user u 
    inner join sh.product p on p.UsernameSalesman = u.Username
    where sold >= 1
    and u.username = psUsername;
END$$

-- Procedure that gets a list of all purchases that cost over 1000 per category made by the user
DELIMITER $$
CREATE PROCEDURE getPurchasesOver1000PerCategory (psUsername varchar(45),  pnID_Category INT)
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
    select pu.ID_Purchase ID_Purchase, pm.Name payment_method, sum(pr.price*pp.Quantity) Total_Price from user u
    inner join sh.purchase pu on pu.Username_Customer = u.Username
    inner join sh.productxpurchase pp on pp.ID_Purchase = pu.ID_Purchase
    inner join sh.product pr on pr.ID_Product = pp.ID_Product
    inner join sh.paymentmethod pm on pm.ID_PaymentMethod = pu.ID_PaymentMethod
    where pr.ID_category = IFNULL(pnID_Category, pr.ID_category)
    and u.username = psUsername
    group by pu.ID_Purchase, pm.Name
    having  Total_Price >= 1000;
END$$

-- Procedure that gets the list of the most recent purchases
DELIMITER $$
CREATE PROCEDURE getPurchaseHistory (psUsername varchar(45), month int) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	Select pu.ID_Purchase ID_Purchase, pu.Date Date, pm.Name Payment_Method,  sum(pr.price) Total_Price
    from user u
    inner join sh.purchase pu on pu.Username_Customer = u.username
    inner join sh.productxpurchase pp on pp.ID_Purchase = pu.ID_Purchase
    inner join sh.product pr on pr.ID_Product = pp.ID_Product
    inner join sh.paymentmethod pm on pm.ID_PaymentMethod = pu.ID_PaymentMethod
    where TIMESTAMPDIFF(MONTH,pu.date,CURDATE()) = ifnull(month, TIMESTAMPDIFF(MONTH,pu.date,CURDATE()))
    AND u.username = psUsername
    group by pu.ID_Purchase, pu.Date, pm.Name;
END$$
