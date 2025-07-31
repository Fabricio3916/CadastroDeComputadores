-- V2__add_client_relation_to_computer.sql

ALTER TABLE tb_computer
DROP COLUMN client_name;

ALTER TABLE tb_computer
    ADD COLUMN client_id BIGINT NOT NULL;

ALTER TABLE tb_computer
    ADD CONSTRAINT fk_client
        FOREIGN KEY (client_id)
            REFERENCES tb_client(id);
