ALTER TABLE product
    ADD num_of_sales INT NULL;

ALTER TABLE product
    MODIFY num_of_sales INT NOT NULL;

ALTER TABLE product
    DROP COLUMN number_of_sales;

ALTER TABLE st_user
    MODIFY user_type INT NULL;