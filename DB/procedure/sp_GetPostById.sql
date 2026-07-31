USE social_media_system;
GO


DROP PROCEDURE IF EXISTS sp_GetPostById;
GO


CREATE PROCEDURE sp_GetPostById

    @post_id BIGINT

AS
BEGIN

    SET NOCOUNT ON;


SELECT

    p.id,
    p.content,
    p.image,
    p.created_at,

    u.id AS user_id,
    u.user_name,
    u.phone,
    u.email,
    u.cover_image,
    u.biography

FROM posts p

         INNER JOIN users u

                    ON p.user_id = u.id

WHERE p.id = @post_id;


END
GO