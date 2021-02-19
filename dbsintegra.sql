show databases;
create database sintegra;

use sintegra;

create table dados (
	cnpj varchar(15) primary key,
	ie varchar(13) not null unique,
    nomeem varchar(100) not null,
    natureza varchar (100) not null,
    fantasia varchar (100) not null unique,
    ateconomica varchar (100) not null,
    logradouro varchar (50) not null,
    numero int (50) not null,
    complemento varchar (20),
    cep int (10) not null,
    bairro varchar (50) not null,
    municipio varchar (50) not null,
    uf varchar (3) not null
);

drop table dados;

show tables;

describe dados;

insert into dados(cnpj,ie,nomeem,natureza,fantasia,ateconomica,logradouro,numero,complemento,cep,bairro,municipio,uf)
values ("36659272000145","128705570112","A. J. O. DE SOUSA GESSO","Empresário (Individual)","J M GESSO E DECORACAO","Obras de acabamento em gesso e estuque","RUA VIEIRA DE MELO",362,"CONJ 01",02356000,"JARDIM VIRGINIA BIANCA","SAO PAULO","SP");

select * from dados;

drop database dbdetran2;