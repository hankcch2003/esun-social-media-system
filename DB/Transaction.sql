USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_CreatePostWithComment;
GO

DROP PROCEDURE IF EXISTS sp_DeletePostWithComments;
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



DECLARE @post_id BIGINT;


SET @post_id = CAST(SCOPE_IDENTITY() AS BIGINT);



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
        @comment_content,
        GETDATE()
    );



COMMIT TRANSACTION;


SELECT
    'Success' AS Result,
    @post_id AS PostId;


END TRY


BEGIN CATCH


ROLLBACK TRANSACTION;


SELECT
    ERROR_MESSAGE() AS ErrorMessage;


END CATCH


END
GO




CREATE PROCEDURE sp_DeletePostWithComments

    @post_id BIGINT

AS
BEGIN

    SET NOCOUNT ON;


BEGIN TRANSACTION;


BEGIN TRY


DELETE FROM comments

WHERE post_id = @post_id;



DELETE FROM posts

WHERE id = @post_id;



COMMIT TRANSACTION;


SELECT
    'Delete Success' AS Result;


END TRY


BEGIN CATCH


ROLLBACK TRANSACTION;


SELECT
    ERROR_MESSAGE() AS ErrorMessage;


END CATCH


END
GO