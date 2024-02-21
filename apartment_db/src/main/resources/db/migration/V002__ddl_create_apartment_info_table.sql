CREATE SEQUENCE apartment_info_id_seq start 4 increment 1;

CREATE TABLE IF NOT EXISTS apartment_info
(
    id          INT8 PRIMARY KEY,
    price       INT4,
    rooms_count INT4,
    free_flag   BOOLEAN,
    fool_rating FLOAT
);

INSERT INTO apartment_info(id, price, rooms_count, free_flag, fool_rating)
VALUES (1, 2000, 2, true, 0),
       (2, 3000, 3, true, 0),
       (3, 1500, 4, true, 0);


