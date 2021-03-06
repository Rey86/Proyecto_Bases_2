-- Insert and Update Triggers of PARAMETER table.

CREATE TRIGGER adm.beforeInsertParameter
    BEFORE INSERT
    ON adm.parameter
    For each row SET
	new.user_creation:=SYSTEM_USER(),
	new.date_creation:=SYSDATE(); 

CREATE TRIGGER adm.beforeUpdateParameter
    BEFORE UPDATE
    ON adm.parameter
    For each row SET
	new.user_last_modification:=SYSTEM_USER(),
	new.date_last_modification:=SYSDATE();
