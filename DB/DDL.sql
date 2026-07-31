CREATE TABLE users (
                       id BIGINT IDENTITY(1,1) PRIMARY KEY,

                       user_name NVARCHAR(50) NOT NULL,

                       phone NVARCHAR(20) NOT NULL UNIQUE,

                       email NVARCHAR(100),

                       password NVARCHAR(255) NOT NULL,

                       salt NVARCHAR(255) NOT NULL,

                       cover_image NVARCHAR(255),

                       biography NVARCHAR(500)
);


CREATE TABLE posts (
                       id BIGINT IDENTITY(1,1) PRIMARY KEY,

                       user_id BIGINT NOT NULL,

                       content NVARCHAR(MAX) NOT NULL,

                       image NVARCHAR(255),

                       created_at DATETIME2 DEFAULT GETDATE(),

                       CONSTRAINT FK_posts_users
                           FOREIGN KEY (user_id)
                               REFERENCES users(id)
);

CREATE TABLE comments (
                          id BIGINT IDENTITY(1,1) PRIMARY KEY,

                          user_id BIGINT NOT NULL,

                          post_id BIGINT NOT NULL,

                          content NVARCHAR(MAX) NOT NULL,

                          created_at DATETIME2 DEFAULT GETDATE(),


                          CONSTRAINT FK_comments_users
                              FOREIGN KEY (user_id)
                                  REFERENCES users(id),


                          CONSTRAINT FK_comments_posts
                              FOREIGN KEY (post_id)
                                  REFERENCES posts(id)
);