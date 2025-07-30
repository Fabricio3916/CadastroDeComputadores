CREATE TABLE tb_client (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL,
                           cellphone VARCHAR(255)
);

CREATE TABLE tb_computer (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             brand VARCHAR(255) NOT NULL,
                             client_name VARCHAR(255) NOT NULL,
                             registration_date DATE DEFAULT CURRENT_DATE
);