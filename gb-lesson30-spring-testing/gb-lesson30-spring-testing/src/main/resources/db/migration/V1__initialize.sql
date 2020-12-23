create table boxes (
    id bigserial,
    size int not null,
    primary key (id)
    );
insert into boxes (size) values (10),(20),(30), (40);