CREATE TABLE IF NOT EXISTS email_sender_info
(
    id VARCHAR PRIMARY KEY,
    host VARCHAR,
    password VARCHAR,
    protocol VARCHAR,
    port INT4,
    username VARCHAR
);

INSERT INTO email_sender_info (id, host, password, protocol, port, username)
VALUES ('EMAIL', 'smtp.yandex.ru', 'ubwlcajhqvzvnupr', 'smtps', 465, 'gusevanas7y@yandex.ru')

