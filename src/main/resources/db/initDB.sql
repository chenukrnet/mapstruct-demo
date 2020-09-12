create table clients
(
    id         bigserial                not null,
    surname    text                     not null,
    name       text                     not null,
    patronymic text                     not null,
    birthdate  timestamp with time zone not null,
    CONSTRAINT clients_pk PRIMARY KEY (id)
);


create table dictionary_address
(
    id        bigserial not null,
    country   text      not null,
    city      text      not null,
    street    text      not null,
    building  int,
    block     text      null,
    apartment text      not null,
    constraint address_pk primary key (id)
);

create table client_address
(
    client_id  bigserial not null,
    address_id bigserial not null,
    constraint client_address_pk primary key (client_id, address_id)
);

alter table
    client_address
    add constraint
        client_id_fk
        foreign key (client_id)
            references clients (id);


alter table
    client_address
    add constraint
        address_id_fk
        foreign key (address_id)
            references dictionary_address (id)