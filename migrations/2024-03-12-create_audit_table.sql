--liquibase formatted sql

--changeset v.trofimchenko:add-_audit-table
create table _audit (
    id serial primary key,
    timestamp timestamp,
    method varchar,
    request_url varchar,
    status varchar check (status in ('PROCESSED','REJECTED')),
    user_email varchar
);