USE social_media_system;
GO

DROP PROCEDURE IF EXISTS sp_GetPostById;
GO


CREATE PROCEDURE sp_GetPostById

    @id BIGINT

AS
BEGIN

    SET NOCOUNT ON;


SELECT

    p.id,
    p.user_id,
    p.content,
    p.image,
    p.created_at

FROM posts p

WHERE p.id = @id;


END
GO