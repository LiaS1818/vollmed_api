
create table medicos(
    id bigint not null auto_increment,
    nombre varchar(255) not null,
    email varchar(255) not null unique,
    documento varchar(50) not null unique,
    especialidad varchar(100) not null,
    calle varchar(100) not null,
    distrito  varchar(100) not null,
    complemento varchar(100),
    numero varchar(100),
    ciudad varchar(100) not null,

    primary key(id)
);
