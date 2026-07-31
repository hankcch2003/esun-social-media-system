USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_CreateComment;
GO


CREATE PROCEDURE sp_CreateComment

    @user_id BIGINT,
    @post_id BIGINT,
    @content NVARCHAR(MAX),
    @comment_id BIGINT OUTPUT

AS
BEGIN

    SET NOCOUNT ON;


INSERT INTO comments
(
    user_id,
    post_id,
    content,
    created_at
)

VALUES
    (
        @user_id,
        @post_id,
        @content,
        GETDATE()
    );


SET @comment_id =
        CAST(SCOPE_IDENTITY() AS BIGINT);


END
GO