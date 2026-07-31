USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_GetUserByPhone;
GO


CREATE PROCEDURE sp_GetUserByPhone

    @phone NVARCHAR(50)

AS
BEGIN

    SET NOCOUNT ON;


SELECT

    id,
    user_name,
    phone,
    email,
    password,
    salt,
    cover_image,
    biography

FROM users

WHERE phone = @phone;


END
GO