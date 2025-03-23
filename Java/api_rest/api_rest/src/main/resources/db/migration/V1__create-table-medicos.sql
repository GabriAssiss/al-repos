create table medicos(
    id bigint not null auto_increment,
    nome varchar(40) not null,
    email varchar(50) not null unique,
    crm varchar(100) not null unique,
    especialidade varchar(25) not null,
    logradouro varchar(40) not null,
    bairro varchar(40) not null,
    cep char(9) not null,
    complemento varchar(50),
    numero varchar(5),
    uf char(2) not null,
    cidade varchar(30) not null,

    primary key(id)

);