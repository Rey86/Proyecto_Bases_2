-- Admin Queries Us
-- Procedure that gets the top n most expensive sales done by all users
DELIMITER $$
CREATE PROCEDURE getTopUserSales (n INT) 
BEGIN
	Select username, sale_quantity 	from (select u.Username username, sum(p.Sold) sale_quantity 
    from user u
    inner join sh.product p on p.UsernameSalesman = u.Username
    group by u.Username
    order by sale_quantity desc) TopUserSales
    where rownum <= n;
END$$

-- Procedure that gets the top n most expensive purchases made by all users
DELIMITER $$
CREATE PROCEDURE getTopUserPurchases (n INT) 
BEGIN
	Select username, purchase_quantity 	from (select u.username username, count(p.ID_Purchase) purchase_quantity
    from user u
    inner join sh.purchase p on p.Username_Customer = u.Username
    group by username
    order by purchase_quantity desc) TopUserPurchases
    where rownum <= n;
END$$

-- Procedure that gets a list of the best reviewed users
DELIMITER $$
CREATE PROCEDURE getBestReviewedUsers ()
BEGIN
	select u.username username, avg(r.stars) average_review
    from user u
    inner join userreviews r on r.Username_Reviewee = u.Username
    group by username
    order by average_review desc;
END$$

-- Procedure that gets a list of the worst reviewed users
DELIMITER $$
CREATE PROCEDURE getWorstReviewedUsers ()
BEGIN
	select u.username username, avg(r.stars) average_review
    from user u
    inner join userreviews r on r.Username_Reviewee = u.Username
    group by username
    order by average_review;
END$$



