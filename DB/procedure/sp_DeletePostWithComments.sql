USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_DeletePostWithComments;
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


END TRY


BEGIN CATCH


ROLLBACK TRANSACTION;


        THROW;


END CATCH


END
GO