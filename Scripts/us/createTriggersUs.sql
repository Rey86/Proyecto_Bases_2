-- Insert and Update Triggers of GENDER table.

CREATE TRIGGER us.beforeInsertGender
    BEFORE INSERT
    ON us.gender
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateGender
    BEFORE UPDATE
    ON us.gender
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USERTYPE table.

CREATE TRIGGER us.beforeInsertUserType
    BEFORE INSERT
    ON us.usertype
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUserType
    BEFORE UPDATE
    ON us.usertype
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of NATIONALITY table.

CREATE TRIGGER us.beforeInsertNationality
    BEFORE INSERT
    ON us.nationality
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateNationality
    BEFORE UPDATE
    ON us.nationality
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USER table.

CREATE TRIGGER us.beforeInsertUser
    BEFORE INSERT
    ON us.user
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUser
    BEFORE UPDATE
    ON us.user
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USERREVIEWS table.

CREATE TRIGGER us.beforeInsertUserReviews
    BEFORE INSERT
    ON us.userreviews
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUserReviews
    BEFORE UPDATE
    ON us.userreviews
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of RECEIVERXSENDER table.

CREATE TRIGGER us.beforeInsertReceiverxSender
    BEFORE INSERT
    ON us.receiverxsender
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateReceiverxSender
    BEFORE UPDATE
    ON us.receiverxsender
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USERWISHESPRODUCT table.

CREATE TRIGGER us.beforeInsertUserWishesProduct
    BEFORE INSERT
    ON us.userwishesproduct
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUserWishesProduct
    BEFORE UPDATE
    ON us.userwishesproduct
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USERVIEWSPRODUCT table.

CREATE TRIGGER us.beforeInsertUserViewsProduct
    BEFORE INSERT
    ON us.userviewsproduct
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUserViewsProduct
    BEFORE UPDATE
    ON us.userviewsproduct
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USERXNATIONALITY table.

CREATE TRIGGER us.beforeInsertUserxNationality
    BEFORE INSERT
    ON us.userxnationality
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUserxNationality
    BEFORE UPDATE
    ON us.userxnationality
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of PHONENUMBER table.

CREATE TRIGGER us.beforeInsertPhoneNumber
    BEFORE INSERT
    ON us.phonenumber
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdatePhoneNumberssss
    BEFORE UPDATE
    ON us.phonenumber
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of USERWANTSPRODUCT table.

CREATE TRIGGER us.beforeInsertUserWantsProduct
    BEFORE INSERT
    ON us.userwantsproduct
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER us.beforeUpdateUserWantsProduct
    BEFORE UPDATE
    ON us.userwantsproduct
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;