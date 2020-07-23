DELIMITER $$
CREATE PROCEDURE getTopPrizesPerCategory (n INT, pnID_Category INT) 
BEGIN
	Select product_name, price from(Select p.name product_name, p.price price from product p 
    inner join category c on c.ID_Category = p.ID_Category
    where ID_category = IFNULL(pnID_Category, ID_category)
    group by product_name 
    order by price desc) TopPrizesPerCategory
    where rownum <= n;
END$$

DELIMITER $$
CREATE PROCEDURE getTopPurchaseAmountPerCategory (n INT, pnID_Category INT) 
BEGIN
	Select purchase  from(Select pu.ID_Purchase purchase, sum(pr.Price) purchase_amount from productxpurchase pp
    inner join product pr on p.ID_Product = pp.ID_Purchase
    inner join purchase pu on p.ID_Product = pp.ID_Product
    inner join category c on c.ID_Category = p.ID_Category
    where ID_category = IFNULL(pnID_Category, ID_category)
    group by purchase 
    order by purchase_amount desc) TopPurchaseAmountPerCategory
    where rownum <= n;
END$$