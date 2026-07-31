USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_CreatePostWithComment;
GO


CREATE PROCEDURE sp_CreatePostWithComment

    @user_id BIGINT,
    @content NVARCHAR(MAX),
    @image NVARCHAR(255),
    @comment_content NVARCHAR(MAX)

AS
BEGIN

    SET NOCOUNT ON;


BEGIN TRANSACTION;


BEGIN TRY


        DECLARE @post_id BIGINT;


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


SET @post_id =
            CAST(SCOPE_IDENTITY() AS BIGINT);



INSERT INTO comments
(
    post_id,
    user_id,
    content,
    created_at
)

VALUES
    (
        @post_id,
        @user_id,
        @comment_content,
        GETDATE()
    );



COMMIT TRANSACTION;


END TRY


BEGIN CATCH


ROLLBACK TRANSACTION;


        THROW;


END CATCH


END
GO