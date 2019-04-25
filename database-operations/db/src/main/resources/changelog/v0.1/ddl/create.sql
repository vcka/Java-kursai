--liquibase formatted sql

--changeset pavel.vrublevskij:create_account_table dbms:postgresql
CREATE TABLE example.account(
 user_id serial PRIMARY KEY,
 username VARCHAR (50) UNIQUE NOT NULL,
 password VARCHAR (50) NOT NULL,
 email VARCHAR (355) UNIQUE NOT NULL,
 created_on TIMESTAMP NOT NULL,
 last_login TIMESTAMP
);
--rollback DROP TABLE if exists example.account;