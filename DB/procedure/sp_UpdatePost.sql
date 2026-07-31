USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_UpdatePost;
GO


CREATE PROCEDURE sp_UpdatePost

    @post_id BIGINT,
    @content NVARCHAR(MAX),
    @image NVARCHAR(255)

AS
BEGIN

    SET NOCOUNT ON;


UPDATE posts

SET

    content = @content,
    image = @image

WHERE id = @post_id;


END
GO