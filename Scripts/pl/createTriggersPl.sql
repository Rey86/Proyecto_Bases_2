-- Insert and Update Triggers of COMMUNITY table.

CREATE TRIGGER pl.beforeInsertCommunity
    BEFORE INSERT
    ON pl.COMMUNITY
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;

CREATE TRIGGER pl.beforeUpdateCommunity
    BEFORE UPDATE
    ON pl.COMMUNITY
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of CANTON table.

CREATE TRIGGER pl.beforeInsertCanton
    BEFORE INSERT
    ON pl.CANTON
    For each row SET
	new.user_creation:=USER,
	new.date_creation:=SYSDATE;
    
CREATE TRIGGER pl.beforeUpdateCanton
    BEFORE UPDATE
    ON pl.CANTON
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of PROVINCE table.

CREATE TRIGGER pl.beforeInsertProvince
    BEFORE INSERT
    ON pl.PROVINCE
    For each row SET
    new.user_creation:=USER,
    new.date_creation:=SYSDATE;
    
CREATE TRIGGER pl.beforeUpdateProvince
    BEFORE UPDATE
    ON pl.PROVINCE
    For each row SET
    new.user_last_modification:=USER,
    new.date_last_modification:=SYSDATE;
    
-- Insert and Update Triggers of COUNTRY table.

CREATE TRIGGER pl.beforeInsertCountry
    BEFORE INSERT
    ON pl.COUNTRY
    For each row SET
    new.user_creation:=USER,
    new.date_creation:=SYSDATE;
    
CREATE TRIGGER pl.beforeUpdateCountry
    BEFORE UPDATE
    ON pl.COUNTRY
    For each row SET
	new.user_last_modification:=USER,
	new.date_last_modification:=SYSDATE;