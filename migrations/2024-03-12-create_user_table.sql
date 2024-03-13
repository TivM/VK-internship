--liquibase formatted sql

--changeset v.trofimchenko:add-_user-table
create table if not exists _user (
    id serial primary key,
    email varchar,
    firstname varchar,
    lastname varchar,
    password varchar,
    role varchar check (role in ('ADMIN','POSTS','USERS','ALBUMS'))
);