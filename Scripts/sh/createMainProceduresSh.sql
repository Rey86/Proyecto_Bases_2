-- SH procedures.
-- Category Table
-- Procedure to get a category with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getCategory (pnIdCategory INT) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	SELECT id_category, name
	FROM CATEGORY 
	WHERE id_category = IFNULL(pnIdCategory, id_category);
END$$

-- Procedure to set a category with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setCategory (pnIdCategory INT, pcCategoryName VARCHAR(45)) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	UPDATE CATEGORY
	SET name = pcCategoryName
	WHERE id_category = pnIdCategory;
	Commit;
END$$

-- Procedure to delete a specific category
DELIMITER $$
CREATE PROCEDURE deleteCategory (pnIdCategory INT) 
BEGIN 
	DECLARE vmenError VARCHAR(100);
	DELETE FROM CATEGORY
	WHERE id_category = pnIdCategory;
	Commit;
END$$

-- Procedure to insert a new category
DELIMITER $$
CREATE PROCEDURE insertCategory (pcCategoryName VARCHAR(45))
BEGIN
	DECLARE vmenError VARCHAR(100);
	INSERT INTO CATEGORY (name)
	VALUES (pcCategoryName);
	Commit;
END$$

-- DeliveryType Table
-- Procedure to get a delivery type with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getDeliveryType (pnIdDeliveryType INT) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	SELECT id_deliverytype, name
	FROM DELIVERYTYPE
	WHERE id_deliverytype = IFNULL(pnIdDeliveryType, id_deliverytype);
END$$

-- Procedure to set a delivery type with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setDeliveryType (pnIdDeliveryType INT, pcDeliveryTypeName VARCHAR(45)) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	UPDATE DELIVERYTYPE
	SET name = pcDeliveryTypeName
	WHERE id_deliverytype = pnIdDeliveryType;
	Commit;
END$$

-- Procedure to delete a specific delivery type 
DELIMITER $$
CREATE PROCEDURE deleteDeliveryType (pnIdDeliveryType INT) 
BEGIN 
	DECLARE vmenError VARCHAR(100);
	DELETE FROM DELIVERYTYPE
	WHERE id_deliverytype = pnIdDeliveryType;
	Commit;
END$$

-- Procedure to insert a new delivery type
DELIMITER $$
CREATE PROCEDURE insertDeliveryType (pcDeliveryTypeName VARCHAR(45))
BEGIN
	DECLARE vmenError VARCHAR(100);
	INSERT INTO DELIVERYTYPE (name)
	VALUES (pcDeliveryTypeName);
	Commit;
END$$

-- PaymentMethod Table
-- Procedure to get a payment method with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getPaymentMethod (pnIdPaymentMethod INT) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	SELECT id_paymentmethod, name
	FROM PAYMENTMETHOD
	WHERE id_paymentmethod = IFNULL(pnIdPaymentMethod, id_paymentmethod);
END$$

-- Procedure to set a payment method with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setPaymentMethod (pnIdPaymentMethod INT, pcPaymentMethodName VARCHAR(45)) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	UPDATE PAYMENTMETHOD
	SET name = pcPaymentMethodName
	WHERE id_paymentmethod = pnIdPaymentMethod;
	Commit;
END$$

-- Procedure to delete a specific payment method 
DELIMITER $$
CREATE PROCEDURE deletePaymentMethod (pnIdPaymentMethod INT) 
BEGIN 
	DECLARE vmenError VARCHAR(100);
	DELETE FROM PAYMENTMETHOD
	WHERE id_paymentmethod = pnIdPaymentMethod;
	Commit;
END$$

-- Procedure to insert a new payment method
DELIMITER $$
CREATE PROCEDURE insertPaymentMethod (pcPaymentMethodName VARCHAR(45))
BEGIN
	DECLARE vmenError VARCHAR(100);
	INSERT INTO PAYMENTMETHOD (name)
	VALUES (pcPaymentMethodName);
	Commit;
END$$

-- Product Table
-- Procedure to get a product with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getProduct (pnIdProduct INT) 
BEGIN
	SELECT p.id_product id_product, p.name product_name, p.price price, p.sold sold, p.description description,
    p.usernamecustomer username_customer, usernamesalesman username_salesman, p.id_category id_category,
    c.name category_name, p.id_purchase id_purchase, p.id_deliverytype id_deliverytype, dt.name deliverytype_name
	FROM PRODUCT p
	INNER JOIN CATEGORY c
	ON p.id_category = c.id_category
    INNER JOIN DELIVERYTYPE dt
    ON p.id_deliverytype = dt.id_deliverytype
	WHERE p.id_product = IFNULL(pnIdProduct, p.id_product);
END$$

-- Procedure to set a product with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setProduct (pnIdProduct INT, pcProductName VARCHAR(45), pnPrice INT, pnSold TINYINT, 
	pcDescription VARCHAR(140), pcUsernameCustomer VARCHAR(45), pcUsernameSalesman VARCHAR(45),
	pnIdCategory INT, pnIdPurchase INT, pnIdDeliveryType INT) 
BEGIN
	UPDATE PRODUCT
	SET name = pcProductName,
	price = pnPrice,
    sold = pnSold,
    description = pcDescription,
    usernamecustomer = pcUsernameCustomer,
    usernamesalesman = pcUsernameSalesman,
    id_category = pnIdCategory,
    id_purchase = pnIdPurchase,
    id_deliverytype = pnIdDeliveryType
	WHERE id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to delete a specific product 
DELIMITER $$
CREATE PROCEDURE deleteProduct (pnIdProduct INT) 
BEGIN 
	DECLARE vmenError VARCHAR(100);
	DELETE FROM PRODUCT
	WHERE id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to insert a new product
DELIMITER $$
CREATE PROCEDURE insertProduct (pcProductName VARCHAR(45), pnPrice INT, pnSold TINYINT, 
	pcDescription VARCHAR(140), pcUsernameCustomer VARCHAR(45), pcUsernameSalesman VARCHAR(45),
	pnIdCategory INT, pnIdPurchase INT, pnIdDeliveryType INT) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	INSERT INTO PRODUCT (name, price, sold, description, usernamecustomer, usernamesalesman, id_category, 
		id_purchase, id_deliverytype)
	VALUES (pcProductName, pnPrice, pnSold, pcDescription, pcUsernameCustomer, pcUsernameSalesman,
		pnIdCategory, pnIdPurchase, pnIdDeliveryType);
	Commit;
END$$

-- Purchase Table
-- Procedure to get a purchase with specific id to show it in the screen  
DELIMITER $$
CREATE PROCEDURE getPurchase (pnIdPurchase INT) 
BEGIN
	SELECT p.id_purchase id_purchase, p.date purchase_date, p.username_customer username_customer, 
    p.id_paymentmethod id_paymentmethod, pm.name paymentmethod_name, sum(pr.price) sub_total, 
    sum(pr.price)+sum(pr.price)*0.13 total
	FROM PURCHASE p
	INNER JOIN PAYMENTMETHOD pm
	ON p.id_paymentmethod = pm.id_paymentmethod
    INNER JOIN PRODUCT pr
    ON p.id_product = pr.id_product
	WHERE p.id_purchase = IFNULL(pnIdPurchase, p.id_purchase)
    GROUP BY id_purchase;
END$$

-- Procedure to set a purchase with specific id and the new values wrote by the user  
DELIMITER $$
CREATE PROCEDURE setPurchase (pnIdPurchase INT, pcProductName VARCHAR(45), pnPrice INT, pnSold TINYINT, 
	pcDescription VARCHAR(140), pcUsernameCustomer VARCHAR(45), pcUsernameSalesman VARCHAR(45),
	pnIdCategory INT, pnIdPurchase INT, pnIdDeliveryType INT) 
BEGIN
	UPDATE PRODUCT
	SET name = pcProductName,
	price = pnPrice,
    sold = pnSold,
    description = pcDescription,
    usernamecustomer = pcUsernameCustomer,
    usernamesalesman = pcUsernameSalesman,
    id_category = pnIdCategory,
    id_purchase = pnIdPurchase,
    id_deliverytype = pnIdDeliveryType
	WHERE id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to delete a specific purchase 
DELIMITER $$
CREATE PROCEDURE deletePurchase (pnIdProduct INT) 
BEGIN 
	DECLARE vmenError VARCHAR(100);
	DELETE FROM PRODUCT
	WHERE id_product = pnIdProduct;
	Commit;
END$$

-- Procedure to insert a new purchase
DELIMITER $$
CREATE PROCEDURE insertPurchase (pcProductName VARCHAR(45), pnPrice INT, pnSold TINYINT, 
	pcDescription VARCHAR(140), pcUsernameCustomer VARCHAR(45), pcUsernameSalesman VARCHAR(45),
	pnIdCategory INT, pnIdPurchase INT, pnIdDeliveryType INT) 
BEGIN
	DECLARE vmenError VARCHAR(100);
	INSERT INTO PRODUCT (name, price, sold, description, usernamecustomer, usernamesalesman, id_category, 
		id_purchase, id_deliverytype)
	VALUES (pcProductName, pnPrice, pnSold, pcDescription, pcUsernameCustomer, pcUsernameSalesman,
		pnIdCategory, pnIdPurchase, pnIdDeliveryType);
	Commit;
END$$