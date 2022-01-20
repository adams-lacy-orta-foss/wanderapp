USE wander_db;
INSERT INTO user (first_name, last_name, username, email, phone_number, password, dob, bio, is_admin) VALUES
    ('Nick', 'Adams', 'thebigdeal916', 'thebigdeal916@icloud.com', '916-996-1799', 'test', '1981-11-23', 'test bio here', false),
    ('Joanna', 'Foss', 'Jfoss', 'jfoss@somemail.com', '123-456-7890', 'testing', '1996-12-25', 'another test bio here', false),
    ('Steven', 'Lacy', 'SLacy', 'SLacy@somemail.com', '123-456-7890', 'testing', '1996-12-25', 'more test bio here', true),
    ('Kevin', 'Orta', 'KOrta', 'orta@somemail.com', '123-456-7890', 'testing', '1996-12-25', 'more test bio here', true);



INSERT INTO trails(trail_data_points, trail_difficulty, trail_elevation, trail_head_location, trail_length, trail_name, trail_rating)
VALUES ('test data point 1', 5, 1500, 'San Antonio', 2, 'test trail name 1', 5),
       ('test data point 2', 7, 1125, 'Austin', 4, 'test trail name 2', 3),
       ('test data point 3', 1, 350, 'Dallas', 1.2, 'test trail name 3', 1);