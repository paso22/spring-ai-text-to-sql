create table player
(
    id           integer not null
        primary key,
    age          integer not null,
    assists      integer not null,
    goals        integer not null,
    name         varchar(255),
    nationality  varchar(255),
    position     varchar(255),
    shirt_number integer not null
);