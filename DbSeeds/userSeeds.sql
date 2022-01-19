CREATE DATABASE IF NOT EXISTS wander_db;
INSERT INTO user(first_name, last_name, user_name, email, phone_number, password, dob, bio, is_admin)
VALUES
    ('Nick', 'Adams', 'thebigdeal916', 'thebigdeal916@icloud.com', '916-996-1799', 'test', '1981-11-23', 'test bio here', false),
    ('Joanna', 'Foss', 'Jfoss', 'jfoss@somemail.com', '123-456-7890', 'testing', '1996-12-25', 'another test bio here', false),
    ('Steven', 'Lacy', 'SLacy', 'SLacy@somemail.com', '123-456-7890', 'testing', '1996-12-25', 'more test bio here', true),
    ('Kevin', 'Orta', 'KOrta', 'orta@somemail.com', '123-456-7890', 'tzesting', '1996-12-25', 'more test bio here', true);