INSERT INTO users
(
    user_name,
    phone,
    email,
    password,
    salt,
    cover_image,
    biography
)
VALUES
    (
        'Hank Chen',
        '0912345678',
        'hank@test.com',
        'hashed_password_example',
        'salt_example',
        NULL,
        'Backend Engineer'
    );

INSERT INTO posts
(
    user_id,
    content,
    image
)
VALUES
    (
        1,
        'Hello Esun Social Media System',
        NULL
    );

INSERT INTO comments
(
    user_id,
    post_id,
    content
)
VALUES
    (
        1,
        1,
        'First comment'
    );