CREATE SEQUENCE booking_info_id_seq start 4 increment 1;

CREATE TABLE IF NOT EXISTS booking_info
(
    id           INT8 PRIMARY KEY,
    start_date   TIMESTAMP,
    end_date     TIMESTAMP,
    final_cost   INT4,
    apartment_id INT8 REFERENCES apartment_info(id),
    user_id      INT8 REFERENCES user_info(id),
    product_id   INT8 REFERENCES discount_info(id)
);

INSERT INTO booking_info (id, start_date, end_date, final_cost, apartment_id, user_id, product_id)
VALUES (1, '2023-10-19 10:23:54', '2024-01-19 10:23:54', 500, 1, 1, 2),
       (2, '2023-12-19 10:23:54', '2024-01-10 10:23:54', 600, 2, 2, 3),
       (3, '2024-01-19 10:23:54', '2024-02-19 10:23:54', 650, 3, 3, 1);
