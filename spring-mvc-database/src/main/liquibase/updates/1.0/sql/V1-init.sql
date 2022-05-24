DROP SEQUENCE if exists spring_mvc.user_id_seq;

CREATE SEQUENCE spring_mvc.users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;


drop table if exists spring_mvc.users;

CREATE TABLE spring_mvc.users
(
    id bigint NOT NULL DEFAULT nextval('spring_mvc.users_id_seq'::regclass),
    name text NOT NULL,
    sur_name text NOT NULL,
    patronymic text NOT NULL,
    phone text,
    email text,
    login text NOT NULL,
    pass text NOT NULL,
    birth_date date,
    PRIMARY KEY (id)
);

