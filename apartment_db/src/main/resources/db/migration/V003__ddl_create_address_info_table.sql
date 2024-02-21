CREATE SEQUENCE address_apartment_id_seq start 4 increment 1;

CREATE TABLE IF NOT EXISTS address_info
(
    id           INT8 PRIMARY KEY,
    city         VARCHAR,
    street       VARCHAR,
    home_number  VARCHAR,
    apartment_id INT8 REFERENCES apartment_info(id)
);

INSERT INTO address_info (id, city, street, home_number, apartment_id)
VALUES (1, 'Самара', 'Куйбышева', '110a', 1),
       (2, 'Москва', 'Большая', '15', 3),
       (3, 'Воронеж', 'Советская', '23', 2);
