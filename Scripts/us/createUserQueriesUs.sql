DELIMITER $$
CREATE PROCEDURE getViewsHistory (psUsername varchar(45)) 
BEGIN
	Select p.name, uv.username viewed_by from user u
    inner join sh.product p on p.UsernameSalesman = u.username
    inner join userviewsproduct up on up.ID_Product = p.ID_Product
    inner join user uv on uv.Username = up.Username
    where u.Username = psUsername and up.date_creation = sysdate();
END$$

DELIMITER $$
CREATE PROCEDURE getSoldProduct (psUsername varchar(45))
BEGIN
	-- Revisar esta
	Select p.name product_name, p.Sold sales from user u 
    inner join sh.product p on p.UsernameSalesman = u.Username
    where u.Username = psUsername and sold >= 1;
END$$

DELIMITER $$
CREATE PROCEDURE getPurchasesOver1000PerCategory (psUsername varchar(45))
BEGIN
	select pu.ID_Purchase, sum(pr.price) Total_Price from user u
    inner join sh.purchase pu on pu.Username_Customer = u.Username
    inner join sh.productxpurchase pp on pp.ID_Purchase = pu.ID_Purchase
    inner join sh.product pr on pr.ID_Product = pp.ID_Product
    where u.Username = psUsername and Total_Price >= 1000;
END$$

