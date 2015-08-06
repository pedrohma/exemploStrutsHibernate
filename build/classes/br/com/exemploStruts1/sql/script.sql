drop database if exists exemploStruts1;
create database exemploStruts1;
use exemploStruts1;

create table pessoa(
idpessoa	 integer 	auto_increment,
nome 		 varchar(50) not null,
email 		 varchar(50) not null,
cpf			 varchar(14) not null,
infosComp	 varchar(100) not null,
dataEntrada	 date 		 not null,
primary key(idpessoa));

desc pessoa;