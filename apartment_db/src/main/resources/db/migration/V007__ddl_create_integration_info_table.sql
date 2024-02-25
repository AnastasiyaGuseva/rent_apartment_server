CREATE TABLE IF NOT EXISTS integration_info
(
    id VARCHAR PRIMARY KEY,
    path_info VARCHAR,
    key_info VARCHAR,
    description VARCHAR
    );

INSERT INTO integration_info (id,path_info,key_info,description )
VALUES ('GEO', 'https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s&language=ru', 'ZjNlZmNiNjhkOGUwNGNlNmE4NWVjMzY2OWY0NWU4YTA=', 'Сервис получения информации по локации');