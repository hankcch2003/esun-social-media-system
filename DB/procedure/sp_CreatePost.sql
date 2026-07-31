USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_CreatePost;
GO


CREATE PROCEDURE sp_CreatePost

    @user_id BIGINT,
    @content NVARCHAR(MAX),
    @image NVARCHAR(255),
    @post_id BIGINT OUTPUT

AS
BEGIN

    SET NOCOUNT ON;


INSERT INTO posts
(
    user_id,
    content,
    image,
    created_at
)

VALUES
    (
        @user_id,
        @content,
        @image,
        GETDATE()
    );


SET @post_id = CAST(SCOPE_IDENTITY() AS BIGINT);


END
GO