CREATE SEQUENCE discount_info_id_seq start 4 increment 1;

CREATE TABLE IF NOT EXISTS discount_info
(
    id INT8              PRIMARY KEY,
    discount_description VARCHAR,
    discount_amount      INT4,
    is_discount_active   BOOLEAN
);

INSERT INTO discount_info (id, discount_description, discount_amount, is_discount_active)
VALUES (1, 'Скидка на первый заказ', 500, true),
       (2, 'Скидка на длительное проживание', 700, true),
       (3, 'Скидка в праздничный день', 100, true),
       (4, 'Скидка на групповые бронирования', 300, true),
       (5, 'Скидка на повторные бронирования', 500, true),
       (6, 'Скидка в день рождения', 900, true),
       (7, 'Скидка для иногородних', 400, true);
