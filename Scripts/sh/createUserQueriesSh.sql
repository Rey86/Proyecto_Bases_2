DELIMITER $$
CREATE PROCEDURE getSearchedProducts (psSearchWord varchar(50)) 
BEGIN
	Select name, price from product where name like pvSearchWord;
END$$

DELIMITER $$
CREATE PROCEDURE getPurhaseHistory (month int) 
BEGIN
	-- Corregir calculo de meses
	Select p.ID_Purchase, p.Date, p.Username_Customer Customer, pm.Name
    from purchase p
    inner join paymentmethod pm on pm.ID_PaymentMethod = p.ID_PaymentMethod
    where month(date) = month;
END$$


