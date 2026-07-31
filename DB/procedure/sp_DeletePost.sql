USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_DeletePost;
GO


CREATE PROCEDURE sp_DeletePost

    @post_id BIGINT

AS
BEGIN

    SET NOCOUNT ON;


DELETE FROM posts

WHERE id = @post_id;


END
GO