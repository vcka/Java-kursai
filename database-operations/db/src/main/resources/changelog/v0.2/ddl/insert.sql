--liquibase formatted sql

--changeset pavel.vrublevskij:create_account_table dbms:postgresql

insert into example.account (
user_id, username, password, email, created_on
) values (
1,'vcka','lopas','vcka@ministras.lt','2019-04-25T17:34:18+00:00'
);

--rollback DROP TABLE if exists example.account;