-- Insert and Update Triggers of CATEGORY table.

CREATE TRIGGER sh.beforeInsertCategory
    BEFORE INSERT
    ON sh.category
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER sh.beforeUpdateCategory
    BEFORE UPDATE
    ON sh.category
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;

-- Insert and Update Triggers of DELIVERYTYPE table.

CREATE TRIGGER sh.beforeInsertDeliveryType
    BEFORE INSERT
    ON sh.deliverytype
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER sh.beforeUpdateDeliveryType
    BEFORE UPDATE
    ON sh.deliverytype
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of PAYMENTMETHOD table.

CREATE TRIGGER sh.beforeInsertPaymentMethod
    BEFORE INSERT
    ON sh.paymentmethod
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER sh.beforeUpdatePaymentMethod
    BEFORE UPDATE
    ON sh.paymentmethod
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of PURCHASE table.

CREATE TRIGGER sh.beforeInsertPurchase
    BEFORE INSERT
    ON sh.purchase
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER sh.beforeUpdatePurchase
    BEFORE UPDATE
    ON sh.purchase
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of PRODUCT table.

	CREATE TRIGGER sh.beforeInsertProduct
		BEFORE INSERT
		ON sh.product
		For each row SET
		new.user_creation:=USER,
		new.date_creation:=SYSDATE;
    
CREATE TRIGGER sh.beforeUpdateProduct
    BEFORE UPDATE
    ON sh.product
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of REVIEW table.

CREATE TRIGGER sh.beforeInsertReview
    BEFORE INSERT
    ON sh.review
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER sh.beforeUpdateReview
    BEFORE UPDATE
    ON sh.review
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;

-- Triggers to fill GENERALLOG table in admscheme.

CREATE TRIGGER sh.beforeUpdateProductPrice
    BEFORE INSERT
    ON product.price
    for each row
	INSERT INTO adm.generallog
	(scheme_name, table_name, column_name, modification_date, id_product, current_value)
	VALUES ('SH', 'PRODUCT', 'PRICE', SYSDATE, new.id_product, new.price);

    
CREATE TRIGGER sh.beforeUpdateProductPrice
    BEFORE UPDATE
    ON PRODUCT.price
    for each row
	INSERT INTO adm.generallog
	(scheme_name, table_name, column_name, modification_date, id_product, previous_value, current_value)
	VALUES ('SH', 'PRODUCT', 'PRICE', SYSDATE, new.id_product, old.price, new.price);