USE social_media_system;
GO

DROP PROCEDURE IF EXISTS sp_CreateUser;
GO


CREATE PROCEDURE sp_CreateUser

    @user_name NVARCHAR(50),
    @phone NVARCHAR(50),
    @email NVARCHAR(100),
    @password NVARCHAR(255),
    @salt NVARCHAR(255),
    @user_id BIGINT OUTPUT

AS
BEGIN

    SET NOCOUNT ON;


INSERT INTO users
(
    user_name,
    phone,
    email,
    password,
    salt
)

VALUES
    (
        @user_name,
        @phone,
        @email,
        @password,
        @salt
    );


SET @user_id = CAST(SCOPE_IDENTITY() AS BIGINT);


END
GO