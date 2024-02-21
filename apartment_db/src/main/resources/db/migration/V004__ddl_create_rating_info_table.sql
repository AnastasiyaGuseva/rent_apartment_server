CREATE SEQUENCE rating_apartment_id_seq start 4 increment 1;

CREATE TABLE IF NOT EXISTS rating_info

( id INT8 PRIMARY KEY,
  overall_rating FLOAT,
  comment VARCHAR(2000),
  apartment_entity_id INT8 REFERENCES apartment_info(id)
);

INSERT INTO rating_info (id, overall_rating, comment, apartment_entity_id)
VALUES (1, 4, 'Good experience', 1),
       (2, 5, 'Excellent service', 2),
       (3, 3, 'Average stay', 3),
       (4, 4, 'Friendly staff', 1),
       (5, 5, 'Highly recommended', 2),
       (6, 2, 'Needs improvement', 3),
       (7, 4, 'Comfortable stay', 1),
       (8, 5, 'Great location', 2),
       (9, 3, 'Decent amenities', 3),
       (10, 4, 'Clean rooms', 1),
       (11, 5, 'Amazing views', 2),
       (12, 3, 'Satisfactory service', 3),
       (13, 4, 'Spacious rooms', 1),
       (14, 2, 'Poor maintenance', 2),
       (15, 4, 'Affordable prices', 3),
       (16, 5, 'Helpful staff', 1),
       (17, 3, 'Noisy environment', 2),
       (18, 4, 'Cozy atmosphere', 3),
       (19, 5, 'Luxurious amenities', 1),
       (20, 3, 'Fair pricing', 2);
