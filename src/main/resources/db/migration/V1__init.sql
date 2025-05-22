CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_on datetime              NULL,
    updated_on datetime              NULL,
    is_deleted BIT(1)                NOT NULL,
    name       VARCHAR(255)          NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    user_id        BIGINT       NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (user_id)
);

CREATE TABLE jt_mentor
(
    user_id    BIGINT       NOT NULL,
    avg_rating VARCHAR(255) NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NULL,
    age  INT          NOT NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE ms_instructor
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    age            INT          NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_ms_instructor PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NULL,
    age        INT          NOT NULL,
    avg_rating VARCHAR(255) NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_on      datetime              NULL,
    updated_on      datetime              NULL,
    is_deleted      BIT(1)                NOT NULL,
    title           VARCHAR(255)          NULL,
    price           DOUBLE                NULL,
    `description`   VARCHAR(255)          NULL,
    category_id     BIGINT                NULL,
    image_url       VARCHAR(255)          NULL,
    number_of_sales INT                   NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id             BIGINT       NOT NULL,
    user_type      INT          NULL,
    name           VARCHAR(255) NULL,
    age            INT          NOT NULL,
    specialization VARCHAR(255) NULL,
    avg_rating     VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    age            INT          NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NULL,
    age        INT          NOT NULL,
    avg_rating VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NULL,
    age  INT          NOT NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);