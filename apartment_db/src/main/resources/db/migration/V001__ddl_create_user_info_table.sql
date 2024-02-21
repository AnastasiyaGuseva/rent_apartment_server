CREATE SEQUENCE user_info_id_seq start 4 increment 1;

CREATE TABLE IF NOT EXISTS user_info
(
    id             INT8 PRIMARY KEY,
    nick_name      VARCHAR,
    login          VARCHAR,
    password       VARCHAR,
    token          VARCHAR,
    city_of_living VARCHAR,
    booking_count  INT4,
    birth_date     TIMESTAMP

);

INSERT INTO user_info(id, nick_name, login, password, city_of_living, booking_count, birth_date)
VALUES (1,'sobaka', 'sobaka@gmail.com', 'sobaka666', 'Москва', 0, '2003-12-11'),
       (2,'koshka', 'koshka@gmail.com', 'koshka777', 'Екатеринбург', 0,'2000-01-12'),
       (3,'slon', 'slon@gmail.com', 'slon222', 'Тула', 2,'2012-08-10');
