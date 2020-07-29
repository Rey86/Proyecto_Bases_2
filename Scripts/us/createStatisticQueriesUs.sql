DELIMITER $$
CREATE PROCEDURE getUserAgeRangePerGender (pnID_Gender Int) 
BEGIN
	DECLARE EXIT HANDLER FOR 1062 SELECT 'Duplicate keys error encountered' Message; 
    DECLARE EXIT HANDLER FOR 1118  SELECT 'Row size too large' Message;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'SQLException encountered' Message; 
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SELECT 'SQLSTATE 23000' ErrorCode;
	SELECT l.user_age_range user_age_range, round(100*count(user) , 2) percentage, count(user) total FROM
    (SELECT CASE WHEN (sysdate()-u.birthdate)/365 >= 0 and (sysdate()-u.birthdate)/365 <= 18 then '0-18'
        WHEN (sysdate()-u.birthdate)/365 >= 19 and (sysdate()-u.birthdate)/365 <= 30 then '19-30'
        WHEN (sysdate()-u.birthdate)/365 >= 31 and (sysdate()-u.birthdate)/365 <= 45 then '31-45'
        WHEN (sysdate()-u.birthdate)/365 >= 46 and (sysdate()-u.birthdate)/365 <= 55 then '46-55'
        WHEN (sysdate()-u.birthdate)/365 >= 56 and (sysdate()-u.birthdate)/365 <= 65 then '56-65'
        WHEN (sysdate()-u.birthdate)/365 >= 66 and (sysdate()-u.birthdate)/365 <= 75 then '66-75'
        WHEN (sysdate()-u.birthdate)/365 >= 76 and (sysdate()-u.birthdate)/365 <= 85 then '76-85'
        ELSE '85+' end as user_age_range
        FROM user u
        inner join sh.product p on p.UsernameSalesman = u.Username
        WHERE u.ID_Gender = ifnull(pnID_Gender, u.ID_Gender)
        ORDER BY u.birthdate) l
        GROUP BY user_age_range;
END$$
