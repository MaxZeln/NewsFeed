DROP TABLE IF EXISTS news;
DROP SEQUENCE IF EXISTS global_seq_news;

DROP TABLE IF EXISTS images;
-- DROP SEQUENCE IF EXISTS global_seq_images;




-- CREATE SEQUENCE global_seq_images START WITH 100 INCREMENT BY 1;
CREATE TABLE images
(
    id                 VARCHAR(255) PRIMARY KEY DEFAULT nextval('global_seq_images'),
    content_type       VARCHAR(255),
    name               VARCHAR(255),
    size               BIGINT,
    bytes              BYTEA,
    original_file_name VARCHAR(255)
);

CREATE SEQUENCE global_seq_news START WITH 1 INCREMENT BY 1;
CREATE TABLE news
(
    id                 BIGINT PRIMARY KEY DEFAULT nextval('global_seq_news '),
    title              VARCHAR(150)         NOT NULL,
    content            VARCHAR(1000)        NOT NULL,
    date               DATE DEFAULT now(),
    image_id           VARCHAR(255),

    FOREIGN KEY (image_id)
        REFERENCES images (id)
);



























